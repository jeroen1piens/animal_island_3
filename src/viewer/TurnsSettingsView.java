package viewer;

public class TurnsSettingsView {

    public void displayNumberTurns(int numberTurns) {
        System.out.println("The current number of turns is: " + numberTurns);
    }

    public void displayOptions() {
        System.out.println();
        System.out.println("Turn Settings - Island Simulator");;
        CommonMessages.requestMenuChoice();
        System.out.println();
        System.out.println("1\t Display current settings");
        System.out.println("2\t Number of turns in a simulation");
        System.out.println("3\t Go back");
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
