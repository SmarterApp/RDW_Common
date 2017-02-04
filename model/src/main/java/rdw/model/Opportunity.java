package rdw.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
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
 *         &lt;element name="Segment" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="position" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *                       &lt;minInclusive value="1"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="formId" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="formKey" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="algorithmVersion" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Accommodation" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="code" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="segment" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedInt">
 *                       &lt;minInclusive value="0"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="context" use="required" type="{}Context" />
 *                 &lt;attribute name="contextDate" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Score" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="measureOf" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="measureLabel" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="standardError" type="{}NullableFloat" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="GenericVariable" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="context" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Item" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Response" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *                           &lt;attribute name="type">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *                                 &lt;enumeration value="value"/>
 *                                 &lt;enumeration value="reference"/>
 *                                 &lt;enumeration value=""/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ScoreInfo" type="{}ScoreInfoType" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="position" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *                 &lt;attribute name="segmentId" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="bankKey" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *                 &lt;attribute name="key" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *                 &lt;attribute name="operational" use="required" type="{}Bit" />
 *                 &lt;attribute name="isSelected" use="required" type="{}Bit" />
 *                 &lt;attribute name="format" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="score" use="required" type="{}UFloatAllowNegativeOne" />
 *                 &lt;attribute name="scoreStatus">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *                       &lt;enumeration value="NOTSCORED"/>
 *                       &lt;enumeration value="SCORED"/>
 *                       &lt;enumeration value="WAITINGFORMACHINESCORE"/>
 *                       &lt;enumeration value="SCORINGERROR"/>
 *                       &lt;enumeration value="APPEALED"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="adminDate" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *                 &lt;attribute name="numberVisits" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *                 &lt;attribute name="mimeType" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *                       &lt;enumeration value="text/plain"/>
 *                       &lt;enumeration value="text/xml"/>
 *                       &lt;enumeration value="text/html"/>
 *                       &lt;enumeration value="audio/ogg"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="clientId" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="strand" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="contentLevel" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="pageNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *                 &lt;attribute name="pageVisits" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *                 &lt;attribute name="pageTime" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="dropped" use="required" type="{}Bit" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="server" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="database" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="clientName" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="key" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="oppId" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="startDate" type="{}NullableDateTime" />
 *       &lt;attribute name="status" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="appeal"/>
 *             &lt;enumeration value="completed"/>
 *             &lt;enumeration value="expired"/>
 *             &lt;enumeration value="handscoring"/>
 *             &lt;enumeration value="invalidated"/>
 *             &lt;enumeration value="paused"/>
 *             &lt;enumeration value="reported"/>
 *             &lt;enumeration value="reset"/>
 *             &lt;enumeration value="scored"/>
 *             &lt;enumeration value="submitted"/>
 *             &lt;enumeration value="pending"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="opportunity" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *       &lt;attribute name="statusDate" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="dateCompleted" type="{}NullableDateTime" />
 *       &lt;attribute name="pauseCount" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *       &lt;attribute name="itemCount" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *       &lt;attribute name="ftCount" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *       &lt;attribute name="abnormalStarts" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *       &lt;attribute name="gracePeriodRestarts" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *       &lt;attribute name="taId" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="taName" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="sessionId" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="windowId" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="windowOpportunity" type="{}NullableUInt" />
 *       &lt;attribute name="dateForceCompleted" type="{}NullableDateTime" />
 *       &lt;attribute name="qaLevel" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="assessmentParticipantSessionPlatformUserAgent" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "segment",
    "accommodation",
    "score",
    "genericVariable",
    "item"
})
public class Opportunity {

    @XmlElement(name = "Segment")
    protected List<Segment> segment;
    @XmlElement(name = "Accommodation")
    protected List<Accommodation> accommodation;
    @XmlElement(name = "Score")
    protected List<Score> score;
    @XmlElement(name = "GenericVariable")
    protected List<GenericVariable> genericVariable;
    @XmlElement(name = "Item")
    protected List<Item> item;
    @XmlAttribute(name = "server", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String server;
    @XmlAttribute(name = "database")
    @XmlSchemaType(name = "anySimpleType")
    protected String database;
    @XmlAttribute(name = "clientName", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String clientName;
    @XmlAttribute(name = "key", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String key;
    @XmlAttribute(name = "oppId", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String oppId;
    @XmlAttribute(name = "startDate")
    protected String startDate;
    @XmlAttribute(name = "status", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String status;
    @XmlAttribute(name = "opportunity", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long opportunity;
    @XmlAttribute(name = "statusDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar statusDate;
    @XmlAttribute(name = "dateCompleted")
    protected String dateCompleted;
    @XmlAttribute(name = "pauseCount", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long pauseCount;
    @XmlAttribute(name = "itemCount", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long itemCount;
    @XmlAttribute(name = "ftCount", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long ftCount;
    @XmlAttribute(name = "abnormalStarts", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long abnormalStarts;
    @XmlAttribute(name = "gracePeriodRestarts", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long gracePeriodRestarts;
    @XmlAttribute(name = "taId")
    @XmlSchemaType(name = "anySimpleType")
    protected String taId;
    @XmlAttribute(name = "taName")
    @XmlSchemaType(name = "anySimpleType")
    protected String taName;
    @XmlAttribute(name = "sessionId")
    @XmlSchemaType(name = "anySimpleType")
    protected String sessionId;
    @XmlAttribute(name = "windowId", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String windowId;
    @XmlAttribute(name = "windowOpportunity")
    protected String windowOpportunity;
    @XmlAttribute(name = "dateForceCompleted")
    protected String dateForceCompleted;
    @XmlAttribute(name = "qaLevel")
    @XmlSchemaType(name = "anySimpleType")
    protected String qaLevel;
    @XmlAttribute(name = "assessmentParticipantSessionPlatformUserAgent", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String assessmentParticipantSessionPlatformUserAgent;

    /**
     * Gets the value of the segment property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the segment property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSegment().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Segment }
     *
     *
     */
    public List<Segment> getSegment() {
        if (segment == null) {
            segment = new ArrayList<>();
        }
        return this.segment;
    }

    /**
     * Gets the value of the accommodation property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accommodation property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccommodation().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Accommodation }
     *
     *
     */
    public List<Accommodation> getAccommodation() {
        if (accommodation == null) {
            accommodation = new ArrayList<>();
        }
        return this.accommodation;
    }

    /**
     * Gets the value of the score property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the score property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScore().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Score }
     *
     *
     */
    public List<Score> getScore() {
        if (score == null) {
            score = new ArrayList<>();
        }
        return this.score;
    }

    /**
     * Gets the value of the genericVariable property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericVariable property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericVariable().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericVariable }
     *
     *
     */
    public List<GenericVariable> getGenericVariable() {
        if (genericVariable == null) {
            genericVariable = new ArrayList<>();
        }
        return this.genericVariable;
    }

    /**
     * Gets the value of the item property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Item }
     *
     *
     */
    public List<Item> getItem() {
        if (item == null) {
            item = new ArrayList<>();
        }
        return this.item;
    }

    /**
     * Gets the value of the server property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getServer() {
        return server;
    }

    /**
     * Sets the value of the server property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setServer(String value) {
        this.server = value;
    }

    /**
     * Gets the value of the database property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDatabase() {
        return database;
    }

    /**
     * Sets the value of the database property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDatabase(String value) {
        this.database = value;
    }

    /**
     * Gets the value of the clientName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Sets the value of the clientName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setClientName(String value) {
        this.clientName = value;
    }

    /**
     * Gets the value of the key property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the oppId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOppId() {
        return oppId;
    }

    /**
     * Sets the value of the oppId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOppId(String value) {
        this.oppId = value;
    }

    /**
     * Gets the value of the startDate property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the opportunity property.
     *
     */
    public long getOpportunity() {
        return opportunity;
    }

    /**
     * Sets the value of the opportunity property.
     *
     */
    public void setOpportunity(long value) {
        this.opportunity = value;
    }

    /**
     * Gets the value of the statusDate property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getStatusDate() {
        return statusDate;
    }

    /**
     * Sets the value of the statusDate property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setStatusDate(XMLGregorianCalendar value) {
        this.statusDate = value;
    }

    /**
     * Gets the value of the dateCompleted property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDateCompleted() {
        return dateCompleted;
    }

    /**
     * Sets the value of the dateCompleted property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDateCompleted(String value) {
        this.dateCompleted = value;
    }

    /**
     * Gets the value of the pauseCount property.
     *
     */
    public long getPauseCount() {
        return pauseCount;
    }

    /**
     * Sets the value of the pauseCount property.
     *
     */
    public void setPauseCount(long value) {
        this.pauseCount = value;
    }

    /**
     * Gets the value of the itemCount property.
     *
     */
    public long getItemCount() {
        return itemCount;
    }

    /**
     * Sets the value of the itemCount property.
     *
     */
    public void setItemCount(long value) {
        this.itemCount = value;
    }

    /**
     * Gets the value of the ftCount property.
     *
     */
    public long getFtCount() {
        return ftCount;
    }

    /**
     * Sets the value of the ftCount property.
     *
     */
    public void setFtCount(long value) {
        this.ftCount = value;
    }

    /**
     * Gets the value of the abnormalStarts property.
     *
     */
    public long getAbnormalStarts() {
        return abnormalStarts;
    }

    /**
     * Sets the value of the abnormalStarts property.
     *
     */
    public void setAbnormalStarts(long value) {
        this.abnormalStarts = value;
    }

    /**
     * Gets the value of the gracePeriodRestarts property.
     *
     */
    public long getGracePeriodRestarts() {
        return gracePeriodRestarts;
    }

    /**
     * Sets the value of the gracePeriodRestarts property.
     *
     */
    public void setGracePeriodRestarts(long value) {
        this.gracePeriodRestarts = value;
    }

    /**
     * Gets the value of the taId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTaId() {
        return taId;
    }

    /**
     * Sets the value of the taId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTaId(String value) {
        this.taId = value;
    }

    /**
     * Gets the value of the taName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTaName() {
        return taName;
    }

    /**
     * Sets the value of the taName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTaName(String value) {
        this.taName = value;
    }

    /**
     * Gets the value of the sessionId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Sets the value of the sessionId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSessionId(String value) {
        this.sessionId = value;
    }

    /**
     * Gets the value of the windowId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWindowId() {
        return windowId;
    }

    /**
     * Sets the value of the windowId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWindowId(String value) {
        this.windowId = value;
    }

    /**
     * Gets the value of the windowOpportunity property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWindowOpportunity() {
        return windowOpportunity;
    }

    /**
     * Sets the value of the windowOpportunity property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWindowOpportunity(String value) {
        this.windowOpportunity = value;
    }

    /**
     * Gets the value of the dateForceCompleted property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDateForceCompleted() {
        return dateForceCompleted;
    }

    /**
     * Sets the value of the dateForceCompleted property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDateForceCompleted(String value) {
        this.dateForceCompleted = value;
    }

    /**
     * Gets the value of the qaLevel property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getQaLevel() {
        return qaLevel;
    }

    /**
     * Sets the value of the qaLevel property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setQaLevel(String value) {
        this.qaLevel = value;
    }

    /**
     * Gets the value of the assessmentParticipantSessionPlatformUserAgent property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAssessmentParticipantSessionPlatformUserAgent() {
        return assessmentParticipantSessionPlatformUserAgent;
    }

    /**
     * Sets the value of the assessmentParticipantSessionPlatformUserAgent property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAssessmentParticipantSessionPlatformUserAgent(String value) {
        this.assessmentParticipantSessionPlatformUserAgent = value;
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
     *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="code" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="segment" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedInt">
     *             &lt;minInclusive value="0"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="context" use="required" type="{}Context" />
     *       &lt;attribute name="contextDate" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Accommodation {

        @XmlAttribute(name = "type", required = true)
        @XmlSchemaType(name = "anySimpleType")
        protected String type;
        @XmlAttribute(name = "value", required = true)
        @XmlSchemaType(name = "anySimpleType")
        protected String value;
        @XmlAttribute(name = "code", required = true)
        @XmlSchemaType(name = "anySimpleType")
        protected String code;
        @XmlAttribute(name = "segment", required = true)
        protected long segment;
        @XmlAttribute(name = "context", required = true)
        protected Context context;
        @XmlAttribute(name = "contextDate", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar contextDate;

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
         * Gets the value of the value property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setValue(String value) {
            this.value = value;
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
         * Gets the value of the segment property.
         *
         */
        public long getSegment() {
            return segment;
        }

        /**
         * Sets the value of the segment property.
         *
         */
        public void setSegment(long value) {
            this.segment = value;
        }

        /**
         * Gets the value of the context property.
         *
         * @return
         *     possible object is
         *     {@link Context }
         *
         */
        public Context getContext() {
            return context;
        }

        /**
         * Sets the value of the context property.
         *
         * @param value
         *     allowed object is
         *     {@link Context }
         *
         */
        public void setContext(Context value) {
            this.context = value;
        }

        /**
         * Gets the value of the contextDate property.
         *
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *
         */
        public XMLGregorianCalendar getContextDate() {
            return contextDate;
        }

        /**
         * Sets the value of the contextDate property.
         *
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *
         */
        public void setContextDate(XMLGregorianCalendar value) {
            this.contextDate = value;
        }

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
     *       &lt;attribute name="context" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class GenericVariable {

        @XmlAttribute(name = "context", required = true)
        @XmlSchemaType(name = "anySimpleType")
        protected String context;
        @XmlAttribute(name = "name", required = true)
        @XmlSchemaType(name = "anySimpleType")
        protected String name;
        @XmlAttribute(name = "value", required = true)
        @XmlSchemaType(name = "anySimpleType")
        protected String value;

        /**
         * Gets the value of the context property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getContext() {
            return context;
        }

        /**
         * Sets the value of the context property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setContext(String value) {
            this.context = value;
        }

        /**
         * Gets the value of the name property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the value property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setValue(String value) {
            this.value = value;
        }

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
     *       &lt;sequence>
     *         &lt;element name="Response" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
     *                 &lt;attribute name="type">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
     *                       &lt;enumeration value="value"/>
     *                       &lt;enumeration value="reference"/>
     *                       &lt;enumeration value=""/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ScoreInfo" type="{}ScoreInfoType" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="position" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
     *       &lt;attribute name="segmentId" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="bankKey" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
     *       &lt;attribute name="key" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
     *       &lt;attribute name="operational" use="required" type="{}Bit" />
     *       &lt;attribute name="isSelected" use="required" type="{}Bit" />
     *       &lt;attribute name="format" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="score" use="required" type="{}UFloatAllowNegativeOne" />
     *       &lt;attribute name="scoreStatus">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
     *             &lt;enumeration value="NOTSCORED"/>
     *             &lt;enumeration value="SCORED"/>
     *             &lt;enumeration value="WAITINGFORMACHINESCORE"/>
     *             &lt;enumeration value="SCORINGERROR"/>
     *             &lt;enumeration value="APPEALED"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="adminDate" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
     *       &lt;attribute name="numberVisits" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
     *       &lt;attribute name="mimeType" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
     *             &lt;enumeration value="text/plain"/>
     *             &lt;enumeration value="text/xml"/>
     *             &lt;enumeration value="text/html"/>
     *             &lt;enumeration value="audio/ogg"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="clientId" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="strand" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="contentLevel" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="pageNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
     *       &lt;attribute name="pageVisits" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
     *       &lt;attribute name="pageTime" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="dropped" use="required" type="{}Bit" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "response",
        "scoreInfo"
    })
    public static class Item {

        @XmlElement(name = "Response")
        protected Item.Response response;
        @XmlElement(name = "ScoreInfo")
        protected ScoreInfoType scoreInfo;
        @XmlAttribute(name = "position", required = true)
        @XmlSchemaType(name = "unsignedInt")
        protected long position;
        @XmlAttribute(name = "segmentId", required = true)
        @XmlSchemaType(name = "anySimpleType")
        protected String segmentId;
        @XmlAttribute(name = "bankKey", required = true)
        @XmlSchemaType(name = "unsignedInt")
        protected long bankKey;
        @XmlAttribute(name = "key", required = true)
        @XmlSchemaType(name = "unsignedInt")
        protected long key;
        @XmlAttribute(name = "operational", required = true)
        protected short operational;
        @XmlAttribute(name = "isSelected", required = true)
        protected short isSelected;
        @XmlAttribute(name = "format", required = true)
        @XmlSchemaType(name = "anySimpleType")
        protected String format;
        @XmlAttribute(name = "score", required = true)
        protected String score;
        @XmlAttribute(name = "scoreStatus")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String scoreStatus;
        @XmlAttribute(name = "adminDate", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar adminDate;
        @XmlAttribute(name = "numberVisits", required = true)
        @XmlSchemaType(name = "unsignedInt")
        protected long numberVisits;
        @XmlAttribute(name = "mimeType", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String mimeType;
        @XmlAttribute(name = "clientId")
        @XmlSchemaType(name = "anySimpleType")
        protected String clientId;
        @XmlAttribute(name = "strand", required = true)
        @XmlSchemaType(name = "anySimpleType")
        protected String strand;
        @XmlAttribute(name = "contentLevel", required = true)
        @XmlSchemaType(name = "anySimpleType")
        protected String contentLevel;
        @XmlAttribute(name = "pageNumber", required = true)
        @XmlSchemaType(name = "unsignedInt")
        protected long pageNumber;
        @XmlAttribute(name = "pageVisits", required = true)
        @XmlSchemaType(name = "unsignedInt")
        protected long pageVisits;
        @XmlAttribute(name = "pageTime", required = true)
        protected int pageTime;
        @XmlAttribute(name = "dropped", required = true)
        protected short dropped;

        /**
         * Gets the value of the response property.
         *
         * @return
         *     possible object is
         *     {@link Item.Response }
         *
         */
        public Item.Response getResponse() {
            return response;
        }

        /**
         * Sets the value of the response property.
         *
         * @param value
         *     allowed object is
         *     {@link Item.Response }
         *
         */
        public void setResponse(Item.Response value) {
            this.response = value;
        }

        /**
         * Gets the value of the scoreInfo property.
         *
         * @return
         *     possible object is
         *     {@link ScoreInfoType }
         *
         */
        public ScoreInfoType getScoreInfo() {
            return scoreInfo;
        }

        /**
         * Sets the value of the scoreInfo property.
         *
         * @param value
         *     allowed object is
         *     {@link ScoreInfoType }
         *
         */
        public void setScoreInfo(ScoreInfoType value) {
            this.scoreInfo = value;
        }

        /**
         * Gets the value of the position property.
         *
         */
        public long getPosition() {
            return position;
        }

        /**
         * Sets the value of the position property.
         *
         */
        public void setPosition(long value) {
            this.position = value;
        }

        /**
         * Gets the value of the segmentId property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getSegmentId() {
            return segmentId;
        }

        /**
         * Sets the value of the segmentId property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setSegmentId(String value) {
            this.segmentId = value;
        }

        /**
         * Gets the value of the bankKey property.
         *
         */
        public long getBankKey() {
            return bankKey;
        }

        /**
         * Sets the value of the bankKey property.
         *
         */
        public void setBankKey(long value) {
            this.bankKey = value;
        }

        /**
         * Gets the value of the key property.
         *
         */
        public long getKey() {
            return key;
        }

        /**
         * Sets the value of the key property.
         *
         */
        public void setKey(long value) {
            this.key = value;
        }

        /**
         * Gets the value of the operational property.
         *
         */
        public short getOperational() {
            return operational;
        }

        /**
         * Sets the value of the operational property.
         *
         */
        public void setOperational(short value) {
            this.operational = value;
        }

        /**
         * Gets the value of the isSelected property.
         *
         */
        public short getIsSelected() {
            return isSelected;
        }

        /**
         * Sets the value of the isSelected property.
         *
         */
        public void setIsSelected(short value) {
            this.isSelected = value;
        }

        /**
         * Gets the value of the format property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getFormat() {
            return format;
        }

        /**
         * Sets the value of the format property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setFormat(String value) {
            this.format = value;
        }

        /**
         * Gets the value of the score property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getScore() {
            return score;
        }

        /**
         * Sets the value of the score property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setScore(String value) {
            this.score = value;
        }

        /**
         * Gets the value of the scoreStatus property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getScoreStatus() {
            return scoreStatus;
        }

        /**
         * Sets the value of the scoreStatus property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setScoreStatus(String value) {
            this.scoreStatus = value;
        }

        /**
         * Gets the value of the adminDate property.
         *
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *
         */
        public XMLGregorianCalendar getAdminDate() {
            return adminDate;
        }

        /**
         * Sets the value of the adminDate property.
         *
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *
         */
        public void setAdminDate(XMLGregorianCalendar value) {
            this.adminDate = value;
        }

        /**
         * Gets the value of the numberVisits property.
         *
         */
        public long getNumberVisits() {
            return numberVisits;
        }

        /**
         * Sets the value of the numberVisits property.
         *
         */
        public void setNumberVisits(long value) {
            this.numberVisits = value;
        }

        /**
         * Gets the value of the mimeType property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getMimeType() {
            return mimeType;
        }

        /**
         * Sets the value of the mimeType property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setMimeType(String value) {
            this.mimeType = value;
        }

        /**
         * Gets the value of the clientId property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getClientId() {
            return clientId;
        }

        /**
         * Sets the value of the clientId property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setClientId(String value) {
            this.clientId = value;
        }

        /**
         * Gets the value of the strand property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getStrand() {
            return strand;
        }

        /**
         * Sets the value of the strand property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setStrand(String value) {
            this.strand = value;
        }

        /**
         * Gets the value of the contentLevel property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getContentLevel() {
            return contentLevel;
        }

        /**
         * Sets the value of the contentLevel property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setContentLevel(String value) {
            this.contentLevel = value;
        }

        /**
         * Gets the value of the pageNumber property.
         *
         */
        public long getPageNumber() {
            return pageNumber;
        }

        /**
         * Sets the value of the pageNumber property.
         *
         */
        public void setPageNumber(long value) {
            this.pageNumber = value;
        }

        /**
         * Gets the value of the pageVisits property.
         *
         */
        public long getPageVisits() {
            return pageVisits;
        }

        /**
         * Sets the value of the pageVisits property.
         *
         */
        public void setPageVisits(long value) {
            this.pageVisits = value;
        }

        /**
         * Gets the value of the pageTime property.
         *
         */
        public int getPageTime() {
            return pageTime;
        }

        /**
         * Sets the value of the pageTime property.
         *
         */
        public void setPageTime(int value) {
            this.pageTime = value;
        }

        /**
         * Gets the value of the dropped property.
         *
         */
        public short getDropped() {
            return dropped;
        }

        /**
         * Sets the value of the dropped property.
         *
         */
        public void setDropped(short value) {
            this.dropped = value;
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
         *       &lt;attribute name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
         *       &lt;attribute name="type">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
         *             &lt;enumeration value="value"/>
         *             &lt;enumeration value="reference"/>
         *             &lt;enumeration value=""/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "content"
        })
        public static class Response {

            @XmlValue
            protected String content;
            @XmlAttribute(name = "date")
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar date;
            @XmlAttribute(name = "type")
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String type;

            /**
             * Gets the value of the content property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getContent() {
                return content;
            }

            /**
             * Sets the value of the content property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setContent(String value) {
                this.content = value;
            }

            /**
             * Gets the value of the date property.
             *
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *
             */
            public XMLGregorianCalendar getDate() {
                return date;
            }

            /**
             * Sets the value of the date property.
             *
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *
             */
            public void setDate(XMLGregorianCalendar value) {
                this.date = value;
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

        }

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
     *       &lt;attribute name="measureOf" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="measureLabel" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="standardError" type="{}NullableFloat" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Score {

        @XmlAttribute(name = "measureOf", required = true)
        @XmlSchemaType(name = "anySimpleType")
        protected String measureOf;
        @XmlAttribute(name = "measureLabel", required = true)
        @XmlSchemaType(name = "anySimpleType")
        protected String measureLabel;
        @XmlAttribute(name = "value", required = true)
        @XmlSchemaType(name = "anySimpleType")
        protected String value;
        @XmlAttribute(name = "standardError")
        protected String standardError;

        /**
         * Gets the value of the measureOf property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getMeasureOf() {
            return measureOf;
        }

        /**
         * Sets the value of the measureOf property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setMeasureOf(String value) {
            this.measureOf = value;
        }

        /**
         * Gets the value of the measureLabel property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getMeasureLabel() {
            return measureLabel;
        }

        /**
         * Sets the value of the measureLabel property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setMeasureLabel(String value) {
            this.measureLabel = value;
        }

        /**
         * Gets the value of the value property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the standardError property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getStandardError() {
            return standardError;
        }

        /**
         * Sets the value of the standardError property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setStandardError(String value) {
            this.standardError = value;
        }

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
     *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="position" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
     *             &lt;minInclusive value="1"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="formId" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="formKey" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="algorithmVersion" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Segment {

        @XmlAttribute(name = "id", required = true)
        @XmlSchemaType(name = "anySimpleType")
        protected String id;
        @XmlAttribute(name = "position", required = true)
        protected short position;
        @XmlAttribute(name = "formId")
        @XmlSchemaType(name = "anySimpleType")
        protected String formId;
        @XmlAttribute(name = "formKey")
        @XmlSchemaType(name = "anySimpleType")
        protected String formKey;
        @XmlAttribute(name = "algorithm", required = true)
        @XmlSchemaType(name = "anySimpleType")
        protected String algorithm;
        @XmlAttribute(name = "algorithmVersion", required = true)
        @XmlSchemaType(name = "anySimpleType")
        protected String algorithmVersion;

        /**
         * Gets the value of the id property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setId(String value) {
            this.id = value;
        }

        /**
         * Gets the value of the position property.
         *
         */
        public short getPosition() {
            return position;
        }

        /**
         * Sets the value of the position property.
         *
         */
        public void setPosition(short value) {
            this.position = value;
        }

        /**
         * Gets the value of the formId property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getFormId() {
            return formId;
        }

        /**
         * Sets the value of the formId property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setFormId(String value) {
            this.formId = value;
        }

        /**
         * Gets the value of the formKey property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getFormKey() {
            return formKey;
        }

        /**
         * Sets the value of the formKey property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setFormKey(String value) {
            this.formKey = value;
        }

        /**
         * Gets the value of the algorithm property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getAlgorithm() {
            return algorithm;
        }

        /**
         * Sets the value of the algorithm property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setAlgorithm(String value) {
            this.algorithm = value;
        }

        /**
         * Gets the value of the algorithmVersion property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getAlgorithmVersion() {
            return algorithmVersion;
        }

        /**
         * Sets the value of the algorithmVersion property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setAlgorithmVersion(String value) {
            this.algorithmVersion = value;
        }

    }



    // ************************************************************************
    // ************************************************************************
    // ************************************************************************
    // ************************************************************************
    // These setters support CSV parsing

    public void setAccommodationAmericanSignLanguage(final String value) {
        setTypeAccommodation("AmericanSignLanguage", value);
    }

    public void setAccommodationBraille(final String value) {
        setTypeAccommodation("Braille", value);
    }

    public void setAccommodationClosedCaptioning(final String value) {
        setTypeAccommodation("ClosedCaptioning", value);
    }

    public void setAccommodationTextToSpeech(final String value) {
        setTypeAccommodation("TextToSpeech", value);
    }

    public void setAccommodationAbacus(final String value) {
        setTypeAccommodation("Abacus", value);
    }

    public void setAccommodationAlternateResponseOptions(final String value) {
        setTypeAccommodation("AlternateResponseOptions", value);
    }

    public void setAccommodationCalculator(final String value) {
        setTypeAccommodation("Calculator", value);
    }

    public void setAccommodationMultiplicationTable(final String value) {
        setTypeAccommodation("MultiplicationTable", value);
    }

    public void setAccommodationPrintOnDemand(final String value) {
        setTypeAccommodation("PrintOnDemand", value);
    }

    public void setAccommodationPrintOnDemandItems(final String value) {
        setTypeAccommodation("PrintOnDemandItems", value);
    }

    public void setAccommodationReadAloud(final String value) {
        setTypeAccommodation("ReadAloud", value);
    }

    public void setAccommodationScribe(final String value) {
        setTypeAccommodation("Scribe", value);
    }

    public void setAccommodationSpeechToText(final String value) {
        setTypeAccommodation("SpeechToText", value);
    }

    public void setAccommodationStreamlineMode(final String value) {
        setTypeAccommodation("StreamlineMode", value);
    }

    public void setAccommodationNoiseBuffer(final String value) {
        setTypeAccommodation("NoiseBuffer", value);
    }

    private void setTypeAccommodation(final String type, final String value) {
        final Accommodation accommodation = findOrCreateAccommodation(type);
        accommodation.setValue(value);
        accommodation.setCode(accessibilityNumericToFeatureCode(value));
    }

    private String accessibilityNumericToFeatureCode(final String value) {
        switch (value) {
            case "0":
            default:    return "UUU";
            case "1":   return "UUN";
            case "2":   return "UUY";
            case "3":   return "UNU";
            case "4":   return "UNN";
            case "5":   return "UNY";
            case "6":   return "UYU";
            case "7":   return "UYN";
            case "8":   return "UYY";
            case "9":   return "NUU";
            case "10":  return "NUN";
            case "11":  return "NUY";
            case "12":  return "NNU";
            case "13":  return "NNN";
            case "14":  return "NNY";
            case "15":  return "NYU";
            case "16":  return "NYN";
            case "17":  return "NYY";
            case "18":  return "YUU";
            case "19":  return "YUN";
            case "20":  return "YUY";
            case "21":  return "YNU";
            case "22":  return "YNN";
            case "23":  return "YNY";
            case "24":  return "YYU";
            case "25":  return "YYN";
            case "26":  return "YYY";
        }
    }

    private Accommodation findOrCreateAccommodation(final String type) {
        final List<Accommodation> accommodations = getAccommodation();
        for (final Accommodation accommodation : accommodations) {
            if (type.equalsIgnoreCase(accommodation.getType())) {
                return accommodation;
            }
        }
        final Accommodation accommodation = new Accommodation();
        accommodation.setType(type);
        accommodations.add(accommodation);
        return accommodation;
    }


    public void setOverallScaleScore(final String value) {
        setScoreOfLabel("Overall", "ScaleScore", value);
    }

    public void setOverallMinimumValue(final String value) {
        setStandardErrorFromMinimalValue("Overall", value);
    }

    public void setOverallPerformanceLevel(final String value) {
        setScoreOfLabel("Overall", "PerformanceLevel", value);
    }

    public void setClaim1ScaleScore(final String value) {
        setScoreOfLabel("Claim1", "ScaleScore", value);
    }

    public void setClaim1MinimumValue(final String value) {
        setStandardErrorFromMinimalValue("Claim1", value);
    }

    public void setClaim1PerformanceLevel(final String value) {
        setScoreOfLabel("Claim1", "PerformanceLevel", value);
    }

    public void setClaim2ScaleScore(final String value) {
        setScoreOfLabel("Claim2", "ScaleScore", value);
    }

    public void setClaim2MinimumValue(final String value) {
        setStandardErrorFromMinimalValue("Claim2", value);
    }

    public void setClaim2PerformanceLevel(final String value) {
        setScoreOfLabel("Claim2", "PerformanceLevel", value);
    }

    public void setClaim3ScaleScore(final String value) {
        setScoreOfLabel("Claim3", "ScaleScore", value);
    }

    public void setClaim3MinimumValue(final String value) {
        setStandardErrorFromMinimalValue("Claim3", value);
    }

    public void setClaim3PerformanceLevel(final String value) {
        setScoreOfLabel("Claim3", "PerformanceLevel", value);
    }

    public void setClaim4ScaleScore(final String value) {
        setScoreOfLabel("Claim4", "ScaleScore", value);
    }

    public void setClaim4MinimumValue(final String value) {
        setStandardErrorFromMinimalValue("Claim4", value);
    }

    public void setClaim4PerformanceLevel(final String value) {
        setScoreOfLabel("Claim4", "PerformanceLevel", value);
    }

    private void setScoreOfLabel(final String of, final String label, final String value) {
        final Score score = findOrCreateScore(of, label);
        score.setValue(value);
    }

    private void setStandardErrorFromMinimalValue(final String of, final String value) {
        final Score score = findOrCreateScore(of, "ScaleScore");
        try {
            score.setStandardError(Integer.toString(Integer.valueOf(score.getValue()) - Integer.valueOf(value)));
        } catch (final NumberFormatException ei) {
            try {
                score.setStandardError(Double.toString(Double.valueOf(score.getValue()) - Double.valueOf(value)));
            } catch (final NumberFormatException ed) {
                // TODO - meh, whatever
            }
        }
    }

    private Score findOrCreateScore(final String of, final String label) {
        final List<Score> scores = getScore();
        for (final Score score : scores) {
            if (of.equalsIgnoreCase(score.getMeasureOf()) && label.equalsIgnoreCase(score.getMeasureLabel())) {
                return score;
            }
        }
        final Score score = new Score();
        score.setMeasureOf(of);
        score.setMeasureLabel(label);
        scores.add(score);
        return score;
    }


    // ************************************************************************
    // ************************************************************************
    // ************************************************************************
    // ************************************************************************
}
