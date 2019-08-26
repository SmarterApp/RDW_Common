enable 'xml'

def xslAllRules = resourceAsString('/xsl/exam.xsl')
applyXsl xslAllRules

outputXml
