package rdw.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="subject" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="testId" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="bankKey" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *       &lt;attribute name="contract" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="mode" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="online"/>
 *             &lt;enumeration value="paper"/>
 *             &lt;enumeration value="scanned"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="grade" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="handScoreProject" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *       &lt;attribute name="assessmentType" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="academicYear" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *       &lt;attribute name="assessmentVersion" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class Test {

    @XmlAttribute(name = "name", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String name;
    @XmlAttribute(name = "subject", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String subject;
    @XmlAttribute(name = "testId", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String testId;
    @XmlAttribute(name = "bankKey")
    @XmlSchemaType(name = "unsignedInt")
    protected Long bankKey;
    @XmlAttribute(name = "contract", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String contract;
    @XmlAttribute(name = "mode", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String mode;
    @XmlAttribute(name = "grade", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String grade;
    @XmlAttribute(name = "handScoreProject")
    @XmlSchemaType(name = "unsignedInt")
    protected Long handScoreProject;
    @XmlAttribute(name = "assessmentType", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String assessmentType;
    @XmlAttribute(name = "academicYear", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long academicYear;
    @XmlAttribute(name = "assessmentVersion", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String assessmentVersion;

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
     * Gets the value of the subject property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSubject(String value) {
        this.subject = value;
    }

    /**
     * Gets the value of the testId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTestId() {
        return testId;
    }

    /**
     * Sets the value of the testId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTestId(String value) {
        this.testId = value;
    }

    /**
     * Gets the value of the bankKey property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getBankKey() {
        return bankKey;
    }

    /**
     * Sets the value of the bankKey property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setBankKey(Long value) {
        this.bankKey = value;
    }

    /**
     * Gets the value of the contract property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContract() {
        return contract;
    }

    /**
     * Sets the value of the contract property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContract(String value) {
        this.contract = value;
    }

    /**
     * Gets the value of the mode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMode(String value) {
        this.mode = value;
    }

    /**
     * Gets the value of the grade property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Sets the value of the grade property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGrade(String value) {
        this.grade = value;
    }

    /**
     * Gets the value of the handScoreProject property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getHandScoreProject() {
        return handScoreProject;
    }

    /**
     * Sets the value of the handScoreProject property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setHandScoreProject(Long value) {
        this.handScoreProject = value;
    }

    /**
     * Gets the value of the assessmentType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAssessmentType() {
        return assessmentType;
    }

    /**
     * Sets the value of the assessmentType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAssessmentType(String value) {
        this.assessmentType = value;
    }

    /**
     * Gets the value of the academicYear property.
     *
     */
    public long getAcademicYear() {
        return academicYear;
    }

    /**
     * Sets the value of the academicYear property.
     *
     */
    public void setAcademicYear(long value) {
        this.academicYear = value;
    }

    /**
     * Gets the value of the assessmentVersion property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAssessmentVersion() {
        return assessmentVersion;
    }

    /**
     * Sets the value of the assessmentVersion property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAssessmentVersion(String value) {
        this.assessmentVersion = value;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", testId='" + testId + '\'' +
                ", grade='" + grade + '\'' +
                ", assessmentType='" + assessmentType + '\'' +
                ", academicYear=" + academicYear +
                ", assessmentVersion='" + assessmentVersion + '\'' +
                '}';
    }
}
