package viewer;

public class SettingsMenuView {

    public void displayOptions() {
        System.out.println();
        System.out.println("Settings - Island Simulator");
        CommonMessages.requestMenuChoice();
        System.out.println();
        System.out.println("1\t Size of the island.");
        System.out.println("2\t Number of initial organisms on the island.");
        System.out.println("3\t Number of turns in a simulation.");
        System.out.println("4\t Go back to the start menu.");
    }

    public void displayNotAMenuOption() {
        CommonMessages.displayNotAMenuOption();
    }

}
