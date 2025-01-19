package analyser;

public class AnalysisSettings {
    private static boolean deceasedOrganismsAnalysisOn = true;
    private static boolean livingOrganismsAnalysisOn = true;
    private static boolean newBornOrganismsAnalysisOn = true;

    public static boolean isDeceasedOrganismsAnalysisOn() {
        return deceasedOrganismsAnalysisOn;
    }

    public static void setDeceasedOrganismsAnalysisOn(boolean deceasedOrganismsAnalysisOn) {
        deceasedOrganismsAnalysisOn = deceasedOrganismsAnalysisOn;
    }

    public static boolean isLivingOrganismsAnalysisOn() {
        return livingOrganismsAnalysisOn;
    }

    public static void setLivingOrganismsAnalysisOn(boolean livingOrganismsAnalysisOn) {
        livingOrganismsAnalysisOn = livingOrganismsAnalysisOn;
    }

    public static boolean isNewBornOrganismsAnalysisOn() {
        return newBornOrganismsAnalysisOn;
    }

    public static void setNewBornOrganismsAnalysisOn(boolean newBornOrganismsAnalysisOn) {
        newBornOrganismsAnalysisOn = newBornOrganismsAnalysisOn;
    }
}
