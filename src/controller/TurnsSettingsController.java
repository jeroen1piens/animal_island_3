package controller;

import simulation.StartSettings;
import viewer.IslandSizeSettingsView;
import viewer.TurnsSettingsView;

import java.util.Scanner;

public class TurnsSettingsController {

    SettingsMenuController settingsMenuController;
    TurnsSettingsView turnsSettingsView = new TurnsSettingsView();

    public TurnsSettingsController(SettingsMenuController settingsMenuController) {
        this.settingsMenuController = settingsMenuController;
    }

    public void chooseOption() {
        turnsSettingsView.displayOptions();
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice) {
            case "1" -> {
                turnsSettingsView.displayNumberTurns(StartSettings.getTurnCount());
                chooseOption();
            }
            case "2" -> {
                turnsSettingsView.askInput();
                String input = scanner.nextLine();
                int inputNumber = InputParser.parseInt(input);
                if (inputNumber > 0) {
                    StartSettings.setTurnCount(inputNumber);
                }
                else {
                    turnsSettingsView.displayNotValidInput();
                }
                chooseOption();
            }
            case "3" -> settingsMenuController.chooseOption();
            default -> {
                turnsSettingsView.displayNotAMenuOption();
                chooseOption();
            }
        }
    }

}
