<!DOCTYPE xsl:stylesheet >
<xsl:stylesheet
    version="2.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:trt="urn:trt">
  <xsl:output method="xml" omit-xml-declaration="yes" indent="yes"/>

  <!-- identity rule copies everything by default -->
  <xsl:template match="@*|node()">
    <xsl:copy>
      <xsl:apply-templates select="@*|node()"/>
    </xsl:copy>
  </xsl:template>

  <!-- this rule removes leading 10 from item bank key -->
  <xsl:template match="Item[starts-with(@bankKey, '10')]/@bankKey">
    <xsl:attribute name="bankKey">
      <xsl:value-of select="substring(., 3)"/>
    </xsl:attribute>
  </xsl:template>

</xsl:stylesheet>
