package rdw.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ToolPage" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="page" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *                 &lt;attribute name="groupId" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="count" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="code" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "toolPage"
})
public class ToolUsage {

    @XmlElement(name = "ToolPage", required = true)
    protected List<ToolPage> toolPage;
    @XmlAttribute(name = "type", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String type;
    @XmlAttribute(name = "code", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String code;

    /**
     * Gets the value of the toolPage property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the toolPage property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getToolPage().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ToolPage }
     *
     *
     */
    public List<ToolPage> getToolPage() {
        if (toolPage == null) {
            toolPage = new ArrayList<ToolPage>();
        }
        return this.toolPage;
    }

    /**
     * Gets the value of the type property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the code property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCode(String value) {
        this.code = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="page" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
     *       &lt;attribute name="groupId" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="count" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ToolPage {

        @XmlAttribute(name = "page", required = true)
        @XmlSchemaType(name = "unsignedInt")
        protected long page;
        @XmlAttribute(name = "groupId", required = true)
        @XmlSchemaType(name = "anySimpleType")
        protected String groupId;
        @XmlAttribute(name = "count", required = true)
        @XmlSchemaType(name = "unsignedInt")
        protected long count;

        /**
         * Gets the value of the page property.
         *
         */
        public long getPage() {
            return page;
        }

        /**
         * Sets the value of the page property.
         *
         */
        public void setPage(long value) {
            this.page = value;
        }

        /**
         * Gets the value of the groupId property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getGroupId() {
            return groupId;
        }

        /**
         * Sets the value of the groupId property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setGroupId(String value) {
            this.groupId = value;
        }

        /**
         * Gets the value of the count property.
         *
         */
        public long getCount() {
            return count;
        }

        /**
         * Sets the value of the count property.
         *
         */
        public void setCount(long value) {
            this.count = value;
        }

    }

}
