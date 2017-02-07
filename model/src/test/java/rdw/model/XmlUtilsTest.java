package rdw.model;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlUtilsTest {

    @Test
    public void itShouldUnmarshalSampleTDSReport() {
        final TDSReport tdsReport = XmlUtils.tdsReportFromXml(this.getClass().getResourceAsStream("/TDSReport.sample.xml"));
        assertSampleTDSReport(tdsReport);
    }

    @Test
    public void itShouldUnmarshalSample2TDSReport() {
        final TDSReport tdsReport = XmlUtils.tdsReportFromXml(this.getClass().getResourceAsStream("/TDSReport.sample2.xml"));
        assertSample2TDSReport(tdsReport);
    }

    @Test(expected = RuntimeException.class)
    public void itShouldRejectBadXml() {
        XmlUtils.tdsReportFromXml(this.getClass().getResourceAsStream("/TDSReport.bad.xml"));
    }

    @Test(expected = RuntimeException.class)
    public void itShouldRejectNonConforming() {
        final TDSReport tdsReport = XmlUtils.tdsReportFromXml(this.getClass().getResourceAsStream("/TDSReport.invalid.xml"));
        assertThat(tdsReport).isNull();
    }

    @Test
    public void itShouldRoundtripSampleTDSReport() throws UnsupportedEncodingException {
        TDSReport tdsReport = XmlUtils.tdsReportFromXml(this.getClass().getResourceAsStream("/TDSReport.sample.xml"));
        final String xml = XmlUtils.tdsReportToXml(tdsReport);
        tdsReport = XmlUtils.tdsReportFromXml(new ByteArrayInputStream(xml.getBytes("UTF-8")));
        assertSampleTDSReport(tdsReport);
    }

    @Test
    public void itShouldUnmarshalSamplesFromETS() {
        for (final String sample : new String[] {
            "SBAC-IAB-FIXED-G4E-Editing-ELA-4.xml",
            "SBAC-IAB-FIXED-G4M-OA-MATH-4.xml",
            "SBAC-IAB-FIXED-G6E-Revision-ELA-6.xml",
            "SBAC-IAB-FIXED-G6M-RP.xml",
            "SBAC-IAB-FIXED-G11M-AlgLin.xml",
            "SBAC-ICA-FIXED-G5E-COMBINED-2017.xml",
            "SBAC-ICA-FIXED-G5M-COMBINED-2017.xml",
            "SBAC-ICA-FIXED-G6M-COMBINED-2017.xml",
            "SBAC-ICA-FIXED-G7E-COMBINED-2017.xml",
            "SBAC-ICA-FIXED-G8E-COMBINED-2017.xml"
        }) {
            final TDSReport tdsReport = XmlUtils.tdsReportFromXml(this.getClass().getResourceAsStream("/" + sample));
            assertThat(tdsReport.getTest().getTestId()).isEqualTo(sample.substring(0, sample.length() - 4));
        }
    }

    private void assertSampleTDSReport(final TDSReport tdsReport) {
        assertThat(tdsReport).isNotNull();
        // spot check a few values
        assertThat(tdsReport.getTest().getAcademicYear()).isEqualTo(2014);
        assertThat(tdsReport.getExaminee().getKey()).isEqualTo(922171);
        assertThat(tdsReport.getExaminee().getExamineeAttributeOrExamineeRelationship()).hasSize(27);
        assertThat(tdsReport.getOpportunity().getTaName()).isEqualTo("Ringnell, Brandi");
        assertThat(tdsReport.getOpportunity().getScore()).hasSize(12);
        assertThat(tdsReport.getOpportunity().getScore().stream()
                .filter(score -> score.getMeasureOf().equals("Overall") && score.getMeasureLabel().equals("PerformanceLevel"))
                .findFirst().get().getValue()).isEqualTo("2");
        assertThat(tdsReport.getToolUsage().get(0).getToolPage().get(0).getGroupId()).isEqualTo("I-200-22489");
    }

    private void assertSample2TDSReport(final TDSReport tdsReport) {
        assertThat(tdsReport).isNotNull();
        // spot check a few values
        assertThat(tdsReport.getTest().getAcademicYear()).isEqualTo(0);
        assertThat(tdsReport.getExaminee().getKey()).isEqualTo(5);
        assertThat(tdsReport.getExaminee().getExamineeAttributeOrExamineeRelationship()).hasSize(50);
        assertThat(tdsReport.getOpportunity().getTaName()).isEqualTo("Test Admin4");
        assertThat(tdsReport.getOpportunity().getItem()).hasSize(27);
    }
}