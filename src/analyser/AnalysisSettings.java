package analyser;

public class AnalysisSettings {
    private static boolean deceasedOrganismsAnalysisOn = true;
    private static boolean livingOrganismsAnalysisOn = true;

    public static boolean isDeceasedOrganismsAnalysisOn() {
        return deceasedOrganismsAnalysisOn;
    }

    public static void setDeceasedOrganismsAnalysisOn(boolean deceasedOrganismsAnalysisOn) {
        AnalysisSettings.deceasedOrganismsAnalysisOn = deceasedOrganismsAnalysisOn;
    }

    public static boolean isLivingOrganismsAnalysisOn() {
        return livingOrganismsAnalysisOn;
    }

    public static void setLivingOrganismsAnalysisOn(boolean livingOrganismsAnalysisOn) {
        AnalysisSettings.livingOrganismsAnalysisOn = livingOrganismsAnalysisOn;
    }
}
