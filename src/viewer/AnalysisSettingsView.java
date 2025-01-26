package viewer;

public class AnalysisSettingsView {

    public void displayOptions() {
        System.out.println();
        System.out.println("Analysis Settings View - Island Simulator");
        CommonMessages.requestMenuChoice();
        System.out.println();
        System.out.println("1\t Display current settings");
        System.out.println("2\t Deceased Organism Analysis On");
        System.out.println("3\t Deceased Organism Analysis Off");
        System.out.println("4\t Living Organism Analysis On");
        System.out.println("5\t Living Organism Analysis Off");
        System.out.println("6\t Go back");
    }

    public void displayCurrentSettings(boolean deceasedOrganismAnalysisOn, boolean livingOrganismAnalysisOn) {
        if(deceasedOrganismAnalysisOn) {
            System.out.println("Deceased Organism Analysis On");
        }
        else {
            System.out.println("Deceased Organism Analysis Off");
        }
        if (livingOrganismAnalysisOn) {
            System.out.println("Living Organism Analysis On");
        }
        else {
            System.out.println("Deceased Organism Analysis Off");
        }
    }

    public void askInput() {
        System.out.println("Please enter a number:");
    }

    public void displayNotAMenuOption() {
        CommonMessages.displayNotAMenuOption();
    }

    public void displayNotValidInput() {
        CommonMessages.displayNotValidInput();
    }
}
