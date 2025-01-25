package controller;
import viewer.StartMenuView;
import simulation.IslandSimulator;

import java.util.Scanner;


public class StartMenuController {

    StartMenuView startMenuView = new StartMenuView();
    SettingsMenuController settingsMenuController = new SettingsMenuController(this);
    IslandSimulator islandSimulator = new IslandSimulator();

    public void startProgram() {
        startMenuView.displayWelcomeMessage();
        chooseOption();
    }

    public void chooseOption() {
        startMenuView.displayOptions();
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice) {
            case "1" -> startSimulation();
            case "2" -> settingsMenuController.chooseOption();
            case "3" -> exitProgram();
            default -> {
                startMenuView.displayNotAMenuOption();
                chooseOption();
            }
        }
    }

    public static void main(String[] args) {
        StartMenuController startMenuController = new StartMenuController();
        startMenuController.startProgram();
    }

    public void startSimulation() {
        AnalysisController analysisController = new AnalysisController(islandSimulator);
        islandSimulator.setAnalysisController(analysisController);
        islandSimulator.simulate();
        chooseOption();
    }

    public void exitProgram() {
        startMenuView.displayGoodByeMessage();
        System.exit(0);
    }
}
