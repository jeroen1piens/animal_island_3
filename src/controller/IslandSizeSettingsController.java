package controller;

import viewer.IslandSizeSettingsView;

import java.util.Scanner;
import simulation.StartSettings;

public class IslandSizeSettingsController {

    IslandSizeSettingsView islandSizeSettingsView = new IslandSizeSettingsView();
    SettingsMenuController settingsMenuController;

    public IslandSizeSettingsController(SettingsMenuController settingsMenuController) {
        this.settingsMenuController = settingsMenuController;
    }

    public void chooseOption() {
        islandSizeSettingsView.displayOptions();
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice) {
            case "1" -> {
                islandSizeSettingsView.displayIslandHorizontalLength(StartSettings.getHorizontalLengthIsland());
                islandSizeSettingsView.displayIslandVerticalLength(StartSettings.getVerticallengthIsland());
                chooseOption();
            }
            case "2" -> {
                islandSizeSettingsView.askInput();
                String input = scanner.nextLine();
                int inputNumber = InputParser.parseInt(input);
                if (inputNumber > 0) {
                    StartSettings.setHorizontalLengthIsland(inputNumber);
                }
                else {
                    islandSizeSettingsView.displayNotValidInput();
                }
                chooseOption();
            }
            case "3" -> {
                islandSizeSettingsView.askInput();
                String input = scanner.nextLine();
                int inputNumber = InputParser.parseInt(input);
                if (inputNumber > 0) {
                    StartSettings.setVerticallengthIsland(inputNumber);
                }
                else {
                    islandSizeSettingsView.displayNotValidInput();
                }
                chooseOption();
            }
            case "4" -> settingsMenuController.chooseOption();
            default -> {
                islandSizeSettingsView.displayNotAMenuOption();
                chooseOption();
            }
        }
    }



}
