package viewer;

public class IslandSizeSettingsView {

    public void displayIslandHorizontalLength(int horizontalLength) {
        System.out.println("The current horizontalLength of the island is: " + horizontalLength);
    }

    public void displayIslandVerticalLength(int verticalLength) {
        System.out.println("The current verticalLength of the island is: " + verticalLength);
    }

    public void displayOptions() {
        System.out.println();
        System.out.println("Island Size Settings - Island Simulator");
        CommonMessages.requestMenuChoice();
        System.out.println();
        System.out.println("1\t Display current settings");
        System.out.println("2\t Change horizontal length");
        System.out.println("3\t Change vertical length");
        System.out.println("4\t Go back");
    }



    public void displayHorizontalLength(int horizontalLength) {
        System.out.println("Horizontal Length Island: " + horizontalLength);
    }

    public void displayVerticalLength(int verticalLength) {
        System.out.println("Vertical Length Island: " + verticalLength);
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
