package viewer;

public class AnalysisSettingsView {

    public void displayOptions() {
        System.out.println();
        System.out.println("Analysis Settings View - Island Simulator");
        CommonMessages.requestMenuChoice();
        System.out.println();
        System.out.println("1\t Display current settings");
        System.out.println("2\t Change horizontal length");
        System.out.println("3\t Change vertical length");
        System.out.println("4\t Go back");
    }
}
