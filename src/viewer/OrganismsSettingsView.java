package viewer;

public class OrganismsSettingsView {

    public void displayOptions() {
        System.out.println();
        System.out.println("Organism Settings - Island Simulator");
        CommonMessages.requestMenuChoice();
        System.out.println();
        System.out.println("1\t Display the current settings for initial organism count");
        System.out.println();
        System.out.println("The options below are for changing the count of a species");
        System.out.println();
        System.out.println("2\t Bear");
        System.out.println("3\t Boa");
        System.out.println("4\t Boar");
        System.out.println("5\t Buffalo");
        System.out.println("6\t Caterpillar");
        System.out.println("7\t Deer");
        System.out.println("8\t Duck");
        System.out.println("9\t Eagle");
        System.out.println("10\t Fox");
        System.out.println("11\t Goat");
        System.out.println("12\t Horse");
        System.out.println("13\t Mouse");
        System.out.println("14\t Plant");
        System.out.println("15\t Rabbit");
        System.out.println("16\t Sheep");
        System.out.println("17\t Wolf");
        System.out.println();
        System.out.println("18\t Go Back");
    }

    public void displayTitleInitialOrganisms() {
        System.out.println("Initial Organisms Count");
    }

    public void displayInitialBears(int bearCount) {
        System.out.println("Bears: " + bearCount);
    }

    public void displayInitialBoas(int boaCount) {
        System.out.println("Boas: " + boaCount);
    }
    public void displayInitialBoars(int boarCount) {
        System.out.println("Boars: " + boarCount);
    }

    public void displayInitialBuffalos(int buffaloCount) {
        System.out.println("Buffalos: " + buffaloCount);
    }

    public void displayInitialCaterpillars(int caterpillarCount) {
        System.out.println("Caterpillars: " + caterpillarCount);
    }

    public void displayInitialDeer(int deerCount) {
        System.out.println("Deer: " + deerCount);
    }

    public void displayInitialDucks(int duckCount) {
        System.out.println("Ducks: " + duckCount);
    }

    public void displayInitialEagles(int eagleCount) {
        System.out.println("Eagles: " + eagleCount);
    }

    public void displayInitialFoxes(int foxCount) {
        System.out.println("Foxes: " + foxCount);
    }

    public void displayInitialGoats(int goatCount) {
        System.out.println("Goats: " + goatCount);
    }

    public void displayInitialHorses(int horseCount) {
        System.out.println("Horses: " + horseCount);
    }

    public void displayInitialMice(int mouseCount) {
        System.out.println("Mice: " + mouseCount);
    }

    public void displayInitialPlants(int plantCount) {
        System.out.println("Plants: " + plantCount);
    }

    public void displayInitialRabbits(int rabbitCount) {
        System.out.println("Rabbits: " + rabbitCount);
    }

    public void displayInitialSheep(int sheepCount) {
        System.out.println("Sheep: " + sheepCount);
    }

    public void displayInitialWolfs(int wolfCount) {
        System.out.println("Wolfs: " + wolfCount);
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
