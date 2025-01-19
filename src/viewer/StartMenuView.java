package viewer;

public class StartMenuView {

    public void displayWelcomeMessage() {
        System.out.println();
        System.out.println(
                "Welcome to the Island Simulator!\n" +
                "A tool for simulating a population of animals on an island.");
        System.out.println();
    }

    public void displayOptions() {
        System.out.println();
        System.out.println("Start Menu - Island Simulator");
        CommonMessages.requestMenuChoice();
        System.out.println();
        System.out.println("1\t Start a simulation with the current settings.");
        System.out.println("2\t Customise the settings of the simulation.");
        System.out.println("3\t Exit the program.");
    }
    public void displayGoodByeMessage() {
        System.out.println("Good Bye!");
    }

    public void displayNotAMenuOption() {
        CommonMessages.displayNotAMenuOption();
    }

}
