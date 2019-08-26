<!DOCTYPE xsl:stylesheet >
<xsl:stylesheet
    version="2.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:trt="urn:trt">
  <xsl:output method="xml" omit-xml-declaration="yes" indent="yes"/>

  <!--
    These are characters that must be converted when "unescaping" embedded
    XML response data. (e.g. "&amp;lt;" will result in "<")
    Characters not present in the map below are left un-touched (e.g. "&amp;#39;" will result in "&#39;" rather than "'")
  -->
  <xsl:variable name="escapedChars">
    <entry key="&amp;lt;">&lt;</entry>
    <entry key="&amp;gt;">&gt;</entry>
    <entry key="&amp;amp;">&amp;</entry>
    <entry key="&amp;quot;">&quot;</entry>
  </xsl:variable>

  <!-- Helper function for "unescaping" wrapped XML content -->
  <xsl:function name="trt:unescape">
    <xsl:param name="escapedContent"/>
    <xsl:analyze-string regex="(&amp;[^;]+;)" select="$escapedContent">
      <xsl:matching-substring>
        <xsl:variable name="unescapedCharacter" select="$escapedChars/entry[@key=regex-group(1)]/text()"/>
        <xsl:choose>
          <xsl:when test="string-length($unescapedCharacter) > 0">
            <xsl:value-of select="$unescapedCharacter"/>
          </xsl:when>
          <xsl:otherwise>
            <xsl:value-of select="regex-group(1)"/>
          </xsl:otherwise>
        </xsl:choose>
      </xsl:matching-substring>
      <xsl:non-matching-substring>
        <xsl:value-of select="."/>
      </xsl:non-matching-substring>
    </xsl:analyze-string>
  </xsl:function>

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

  <!-- this rule converts IAT multiple-choice and multiple-select responses to the expected format ("A,C,D") -->
  <xsl:template match="Response[contains(text(),'choiceInteraction_1') and not(contains(text(), 'choiceInteraction_2'))]/text()">
    <xsl:variable name="choices" select="replace(., '\s*&lt;(?!/?value)[^&gt;]+&gt;\s*', '', ';j')"/>
    <xsl:variable name="choiceCharacters" select="replace($choices, '&lt;[^&lt;]+-choice-(\w)&lt;[^&gt;]+&gt;', '$1,')"/>
    <xsl:value-of select="substring($choiceCharacters, 1, string-length($choiceCharacters)-1)"/>
  </xsl:template>

  <!--
    This rule converts EBSR multiple-choice and multiple-select responses to the expected format:
    <itemResponse>
      <response id="EBSR1">
        <value>A</value>
      </response>
      <response id="EBSR2">
        <value>C</value>
      </response>
    </itemResponse>
  -->
  <xsl:template match="Response[contains(text(),'choiceInteraction_1') and contains(text(), 'choiceInteraction_2')]/text()">
    <xsl:variable name="convertedResponses" select="replace(., 'choiceInteraction_(\d).RESPONSE', 'EBSR$1')"/>
    <xsl:value-of select="replace($convertedResponses, 'choiceInteraction_\d-choice-(\w)', '$1')"/>
  </xsl:template>

  <!--
    This rule converts Match Interaction (MI) responses to the expected format:
    <itemResponse>
      <response id="RESPONSE">
        <value>1 a</value>
        <value>2 b</value>
        <value>3 a</value>
        <value>4 b</value>
      </response>
    </itemResponse>
  -->
  <xsl:template match="Response[contains(text(),'matchInteraction_')]/text()">
    <xsl:variable name="convertedResponses" select="replace(., 'matchInteraction_\d.RESPONSE', 'RESPONSE')"/>
    <xsl:value-of select="replace($convertedResponses, 'matchInteraction_\d-(\d)\W*matchInteraction_\d-(\w)', '$1 $2')"/>
  </xsl:template>

  <!--
    This rule converts Table Interaction (TI) responses to the expected format:
    <responseSpec>
      <responseTable>
        <tr><th id="col0" /><th id="col1" /><th id="col2" /><th id="col3" /><th id="col4" /><th id="col5" /><th id="col6" /><th id="col7" /><th id="col8" /><th id="col9" /><th id="col10" /></tr>
        <tr><td /><td>B</td><td /><td /><td>A</td><td /><td /><td>C</td><td /><td /><td>D</td></tr>
      </responseTable>
    </responseSpec>
  -->
  <xsl:template match="Response[contains(text(),'tableInteraction_')]/text()">
    <xsl:variable name="escapedResponse" select="replace(., '.+&lt;value&gt;(.+)&lt;/value&gt;.+', '$1', 's')"/>
    <xsl:value-of select="trt:unescape($escapedResponse)"/>
  </xsl:template>

  <!--
    This rule converts Hot Text Interaction (HTQ) responses to the expected format:
    <itemResponse>
      <response id="1">
        <value>2</value>
        <value>4</value>
      </response>
    </itemResponse>
  -->
  <xsl:template match="Response[contains(text(),'hotTextInteraction_')]/text()">
    <xsl:variable name="convertedIds" select="replace(., 'hotTextInteraction_(\d).RESPONSE', '$1')"/>
    <xsl:value-of select="replace($convertedIds, 'hotTextInteraction_\d-hottext-(\d)', '$1')"/>
  </xsl:template>

  <!--
    This rule converts Equation Interaction (EQ) responses to the expected format:
    <response>
      <math xmlns="http://www.w3.org/1998/Math/MathML" title="50">
        <mstyle><mn>50</mn></mstyle>
      </math>
    </response>
  -->
  <xsl:template match="Response[contains(text(),'equationInteraction_')]/text()">
    <xsl:variable name="escapedResponse" select="replace(., '.+&lt;value&gt;(.+)&lt;/value&gt;.+', '$1', 's')"/>
    <xsl:value-of select="trt:unescape($escapedResponse)"/>
  </xsl:template>

  <!--
    This rule converts Grid Interaction (GI) responses to the expected format:
    <?xml version="1.0" encoding="UTF-8"?>
    <AnswerSet>
      <Question id="">
        <QuestionPart id="1">
          <ObjectSet>
            <AtomicObject>{AminusB(91,49)}</AtomicObject>
            <AtomicObject>{BC(193,49)}</AtomicObject>
            <AtomicObject>{C(299,49)}</AtomicObject>
            <RegionGroupObject name="PartA" numselected="1">
              <RegionObject name="Step1" isselected="false" />
              <RegionObject name="Step2" isselected="true" />
              <RegionObject name="Step3" isselected="false" />
              <RegionObject name="Step4" isselected="false" />
            </RegionGroupObject>
          </ObjectSet>
          <SnapPoint>70@91,361;193,361;299,361;407,361;299,345;299,377</SnapPoint>
        </QuestionPart>
      </Question>
    </AnswerSet>
  -->
  <xsl:template match="Response[contains(text(),'gridInteraction_')]/text()">
    <xsl:variable name="escapedResponse" select="replace(., '.+&lt;value&gt;(.+)&lt;/value&gt;.+', '$1', 's')"/>
    <xsl:value-of select="trt:unescape($escapedResponse)"/>
  </xsl:template>

  <!--
    This rule converts Short Answer / Writing Extended Response Interaction (SA|ER|WER) responses to the expected WYSIWYG format:
    <p>&nbsp; This is <strong>free-entry</strong> text that <i>students</i> can:
    <ul><li>enter</li><li>style</li><li>organize</li></ul>
    <p>however they like. We can&#39;t unescape everything.
  -->
  <xsl:template match="Response[contains(text(),'textEntryInteraction_')]/text()">
    <xsl:variable name="escapedResponse" select="replace(., '.+&lt;value&gt;(.+)&lt;/value&gt;.+', '$1', 's')"/>
    <xsl:value-of select="trt:unescape($escapedResponse)"/>
  </xsl:template>


</xsl:stylesheet>
