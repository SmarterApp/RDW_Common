package scripts


import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.commons.csv.CSVPrinter
import org.apache.commons.io.IOUtils
import org.jdom2.Document
import org.jdom2.Element
import org.jdom2.input.SAXBuilder
import org.jdom2.output.Format
import org.jdom2.output.LineSeparator
import org.jdom2.output.XMLOutputter
import org.jdom2.transform.JDOMResult
import org.jdom2.transform.JDOMSource
import org.jdom2.xpath.XPathFactory
import org.opentestsystem.rdw.common.model.ImportException
import org.opentestsystem.rdw.common.model.ImportStatus
import org.opentestsystem.rdw.script.PipelineScript
import org.opentestsystem.rdw.utils.DataElementError
import org.opentestsystem.rdw.utils.DataElementErrorCollector
import org.opentestsystem.rdw.utils.ParserHelper
import org.xml.sax.InputSource

import javax.xml.transform.Transformer
import javax.xml.transform.TransformerFactory
import javax.xml.transform.stream.StreamSource
import java.nio.charset.StandardCharsets

import static java.nio.charset.StandardCharsets.UTF_8

/**
 * Base class for Groovy pipeline scripts. Provides a DSL that will be available to the scripts.
 */
abstract class DSLScriptBase extends PipelineScript {
    static {
        // Disable starting new threads from the script. They complicate error handling
        // and might be used to bypass security restrictions.
        Thread.metaClass.start { throw new SecurityException("Illegal to start new thread from script") }
    }

    // Collection of errors found by validating scripts.
    private DataElementErrorCollector errorCollector = new DataElementErrorCollector()

    // Parser Helper wrapping error collector
    private ParserHelper parserHelper = new ParserHelper(errorCollector)

    private final List<String> enabledExtensions = new ArrayList<>();

    /**
     * Returns original input if no errors have been found, otherwise throws ImportException.
     * This can be called anywhere to fast fail on input errors, but for scripts
     * that primarily do validation, it must at least be
     * called at the end of the script, where it will return the untransformed input to be used as input
     * for the next script in the pipeline or to throw an exception that summarizes the contents of the
     * error collector.
     *
     * @return original input if no errors found, otherwise exception thrown
     * @throws ImportException if any errors have been found. The collected errors will be summarized by this exception.
     * @param status code for the failure, defaults to ImportStatus.BAD_DATA
     */
    def getCheckValid(ImportStatus status = ImportStatus.BAD_DATA) {
        if (errorCollector.isEmpty()) {
            return input
        }

        throw new ImportException(status, errorCollector.toJson())
    }

    ParserHelper getParserHelper() {
        return parserHelper
    }

    DataElementErrorCollector getDataElementErrorCollector(){
        return errorCollector;
    }

    /**
     * This method is the same as {@link #getCheckValid(ImportStatus)}, but allows the status to be passed
     * in as a string. This should match (case-insensitive) one of names in the ImportStatus enum.
     *
     * @param statusString string matching one of the Import Status enums.
     * @return see{@link #getCheckValid(ImportStatus)}
     */
    Boolean checkValid(String statusString) {
        ImportStatus status = stringToImportStatus(statusString)
        getCheckValid(status)
    }

    /**
     * Adds a DataElementError to the error collector.
     *
     * @param elementName
     * @param value
     * @param error
     *
     * @see DataElementError
     */
    void addError(String elementName, String value, String error) {
        errorCollector.add(new DataElementError(elementName, value, error));
    }

    /**
     * Throws an ImportException immediately on execution with status BAD_DATA.
     *
     * @param message message used for import exception.
     * @throws ImportException
     */
    void errorImmediately(String message) {
        errorImmediately(ImportStatus.BAD_DATA, message)
    }

    /**
     * Throws an ImportException immediately on execution with status BAD_DATA.
     *
     * @param statusString status for import exception if convertible to an ImportStatus enum value.
     * @param message message used for import exception.
     * @throws ImportException
     */
    void errorImmediately(String statusString, String message) {
        errorImmediately(stringToImportStatus(statusString), message)
    }

    /**
     * Throws an ImportException immediately on execution with status BAD_DATA.
     *
     * @param status status for import exception.
     * @param message message used for import exception.
     * @throws ImportException
     */
    void errorImmediately(ImportStatus status, String message) {
        throw new ImportException(status, message)
    }

    /**
     * Resolves missing properties by delegating to custom property resolver if one has been set.
     *
     * @param name the name of the property to resolve
     * @return an object that the property resolver maps to the name.
     * @throws MissingPropertyException if name cannot be resolved
     */
    def propertyMissing(String name) {
        // Avoid endless recursion
        if (name == 'propertyResolver') {
            return null
        }

        if (propertyResolver != null) {
            try {
                def property = propertyResolver.resolveProperty(name)
                if (property != null) {
                    return property
                }
            } catch (Exception e) {
                throw new MissingPropertyException(name, this.class, e)
            }
        }

        throw new MissingPropertyException(name, this.class)
    }

    public InputStream resourceAsStream(String path) {
        return getClass().getResourceAsStream(path)
    }

    public byte[] resourceAsBytes(String path) throws IOException {
        return IOUtils.toByteArray(resourceAsStream(path))
    }

    public String resourceAsString(String path) throws IOException {
        return IOUtils.toString(resourceAsStream(path), UTF_8)
    }

    // Convert string to ImportStatus enum value. Returns BAD_DATA if conversion fails.
    private ImportStatus stringToImportStatus(String statusString) {
        for (ImportStatus status : ImportStatus.values()) {
            if (status.name().equalsIgnoreCase(statusString)) {
                return status
            }
        }

        // Default
        return ImportStatus.BAD_DATA
    }

    /**
     * Enables domain specific language (DSL) as needed by the script.
     *
     * @param type the type of DSL to enable. Currently only supports 'xml'
     */
    void enable(String type) {
        if ('xml'.equalsIgnoreCase(type)) {
            enableXmlExtensions()
        } else if ('csv'.equalsIgnoreCase(type)) {
            enableCsvExtensions()
        } else {
            throw new RuntimeException("Unsupported extension type: " + type)
        }
    }

    // Checks that incompatible extensions not enabled for same script
    private void checkExtension(String type) {
        // There are only two extensions now, so just check that no other extension has already been enabled.
        if (enabledExtensions.isEmpty()) {
            enabledExtensions.add(type)
        } else if (!(enabledExtensions.size() == 1 && enabledExtensions.contains(type))) {
            throw new RuntimeException("Cannot enable " + type +
                    " extensions. Only one extension can be enabled for a script.")
        }
    }

    //  Adds CSV parsing and transformation helper methods to the script class.
    //  See readme for specific examples of using these helper methods.
    private void enableCsvExtensions() {
        checkExtension('csv')

        Reader reader = convertToReader(getProperty('input'))

        CSVFormat csvFormat = CSVFormat.RFC4180.withFirstRecordAsHeader().withCommentMarker('#' as char)
        StringWriter csvStringWriter = new StringWriter()
        CSVPrinter csvPrinter = new CSVPrinter(csvStringWriter, csvFormat)
        boolean transformed = false

        CSVParser csvParser = csvFormat.parse(reader)

        Map<String,Integer> headerMap = csvParser.getHeaderMap()

        this.setProperty('csvParser', csvParser)

        // Transformation for rows of the CSV input, which is assumed to begin with a header with no duplication
        // in header names. Each row is transformed by the defined rule, which can perform one or more
        // transformations on the row's contents or delete the row entirely.
        this.metaClass.transformRows {rule ->
            transformed = true
            csvPrinter.printRecord(csvParser.getHeaderMap().keySet())
            if (rule instanceof Closure) {
                csvParser.each {
                    this.currentRowDeleted = false

                    // Handle blank lines
                    if (it.size() == 1 && !it.iterator().next()?.trim()) {
                        csvPrinter.printRecord()
                        return
                    }

                    if (it.getComment() != null && it.getComment().length() > 0) {
                        csvPrinter.printComment(it.getComment())
                    }
                    Map values = it.toMap()

                    // Add the ability to delete the row from the CSV output
                    values.getMetaClass().delete {
                        this.currentRowDeleted = true
                    }

                    // Treat the row values as properties based on the column header. Error if the requested
                    // properties does not exist in the column headers.
                    values.getMetaClass().setProperty {property, value ->
                        if (!headerMap.containsKey(property)) {
                            throw new IllegalArgumentException('[' + property + '] not contained in CSV headers')
                        }
                        delegate.put(property, value)
                    }
                    values.getMetaClass().getProperty {property ->
                        if (!headerMap.containsKey(property)) {
                            throw new IllegalArgumentException('[' + property + '] not contained in CSV headers')
                        }
                        // Value could be null if line is truncated (i.e., has fewer fields than there are headers)
                        // Force it to empty string to avoid NPE in scripts.
                        def value = delegate.get(property)
                        value == null ? "" : value
                    }

                    rule(values)

                    if (!this.currentRowDeleted) {
                        csvPrinter.printRecord(orderValues(values, headerMap.keySet()))
                    }
                }
            }
            csvParser.close()


            return this.getOutputCsv()
        }

        // Outputs the transformed CSV as a string, or just returns the input value if no transformations
        // exist in the script.
        this.metaClass.getOutputCsv {
            if (!transformed) {
                return input
            }

            csvPrinter.flush()
            return csvStringWriter.toString()
        }

        // Auxiliary method needed to put row values in order. The CSVRecord only provides these as an
        // unsorted map. The header map does return its keyset in the correct order.
        this.metaClass.orderValues {values, headers ->
            List<String> orderedValues = new ArrayList<>(headers.size())
            for (String header : headers) {
                orderedValues.add(values.get(header))
            }
            return orderedValues
        }
    }

    // Adds XML parsing, transformation, formatting helper methods to the script class.
    // See readme for specific examples of using these helper methods.
    private void enableXmlExtensions() {
        checkExtension('xml')

        // XML documents can have a character encoding in their declarations, which the parser will use
        // if it can. (It will fall back to UTF-8 if no declaration is present.) To make this work
        // we have to use an input stream for byte arrays. Strings are already encoded so a reader is correct.
        def input = convertToInputStream(getProperty('input'))
        if (input == null) {
            input = convertToReader(getProperty('input'))
        }

        Document document = new SAXBuilder().build(new InputSource(input))

        this.setProperty("document", document)

        // Unescapes up embedded HTML tags in embedded  in TRT values.
        String.metaClass.unescapeHtmlTags {
            delegate.replaceAll('&lt;','<').replaceAll('&gt;','>')
        }

        // Allows text content to be accessed as element.text and attributes values to be accessed as element.propName
        Element.metaClass.getProperty { property ->
            if (property == 'text') {
                delegate.coalesceText(true)
                delegate.getText()
            } else {
                delegate.getAttributeValue(property)
            }
        }

        // Allows text content to set by assignment to element.text and attributes by assignment to element.propName
        Element.metaClass.setProperty { property, value ->
            if (property == 'text') {
                delegate.setText(value)
            } else {
                delegate.setAttribute(property, value)
            }
        }

        // Helper method for modifying XML documents. Loops through elements matching given XPath expression and
        // applies the rule to each of them.
        this.metaClass.transform {xpath ->
            [by: {rule ->
                if (rule instanceof Closure) {
                    def elements = XPathFactory.instance().compile(xpath as String).evaluate(getProperty('document'))
                    elements.each { rule(it) }
                }
            }]
        }

        // Helper method for modifying XML documents. Filters the elements matching the provided rule. When modified
        // with "when", all elements matching the rule are removed from the document. When modified with "unless"
        // all the elements not matching the rule will be removed from the document.
        this.metaClass.delete {xpath ->
            [when: {rule ->
                if (rule instanceof Closure) {
                    def elements = XPathFactory.instance().compile(xpath as String).evaluate(getProperty('document'))
                    elements.each {
                        if(rule(it)) {
                            delete(it)
                        }
                    }
                }
            },
             unless: {rule ->
                 if (rule instanceof Closure) {
                     def elements = XPathFactory.instance().compile(xpath as String).evaluate(getProperty('document'))
                     elements.each {
                         if(!rule(it)) {
                             delete(it)
                         }
                     }
                 }
             }]
        }

        // Helper to delete a single element form a document with: delete element
        this.metaClass.delete {Element element ->
            if (element != null) {
                element.detach()
            }
        }

        // Converts the document object to a string. Typically this should be the last statement in a script.
        this.metaClass.getOutputXml {
            if (input instanceof Reader) {
                getOutputXmlAsString()
            } else {
                getOutputXmlAsByteArray()
            }
        }

        this.metaClass.getOutputXmlAsByteArray {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
            new XMLOutputter().with {
                format = Format.getRawFormat()
                format.setLineSeparator(LineSeparator.NONE)
                format.setOmitDeclaration(true)
                output(getProperty('document'), outputStream)
            }

            return outputStream.toByteArray()
        }

        this.metaClass.getOutputXmlAsString {
            StringWriter stringWriter = new StringWriter()

            new XMLOutputter().with {
                format = Format.getRawFormat()
                format.setLineSeparator(LineSeparator.NONE)
                format.setOmitDeclaration(true)
                output(getProperty('document'), stringWriter)
            }

            return stringWriter.toString()
        }

        // Apply as XSL transformation to the document by: apply xsl
        // where xsl is a String containing the XSL document, a file represented by a java.io.File object,
        // or an open java.io.InputStream.
        this.metaClass.applyXsl {xsl ->
            if (xsl instanceof String) {
                xsl = new ByteArrayInputStream(xsl.getBytes(StandardCharsets.UTF_8))
            }

            JDOMSource source = new JDOMSource((Document)getProperty('document'))
            Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(xsl))
            JDOMResult out = new JDOMResult()
            transformer.transform(source, out)

            setProperty('document', out.document)
        }
    }

    private Reader convertToReader(Object input) {
        if (input == null) {
            throw new RuntimeException("Input cannot be null")
        }

        if (input instanceof String) {
            return new StringReader(input)
        } else if (input instanceof byte[]) {
            return new InputStreamReader(new ByteArrayInputStream(input), UTF_8)
        } else if (input instanceof InputStream) {
            return new InputStreamReader(input, UTF_8)
        } else if (input instanceof Reader) {
            return input
        }

        throw new RuntimeException("Unsupported input type: " + input.getClass())
    }

    private InputStream convertToInputStream(Object input) {
        if (input instanceof byte[]) {
            return new ByteArrayInputStream(input)
        } else if (input instanceof InputStream) {
            return input
        }

        return null
    }
}
