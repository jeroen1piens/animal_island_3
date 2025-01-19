package controller;
import viewer.SettingsMenuView;

import java.util.Scanner;

public class SettingsMenuController {

    SettingsMenuView settingsMenuView = new SettingsMenuView();
    StartMenuController startMenuController;
    IslandSizeSettingsController islandSizeSettingsController = new IslandSizeSettingsController(this);
    OrganismsSettingsController organismsSettingsController = new OrganismsSettingsController((this));
    TurnsSettingsController turnsSettingsController = new TurnsSettingsController(this);

    public SettingsMenuController(StartMenuController startMenuController) {
        this.startMenuController = startMenuController;
    }

    public void chooseOption() {
        settingsMenuView.displayOptions();
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice) {
            case "1" -> islandSizeSettingsController.chooseOption();
            case "2" -> organismsSettingsController.chooseOption();
            case "3" -> turnsSettingsController.chooseOption();
            case "4" -> startMenuController.chooseOption();
            default -> {
                settingsMenuView.displayNotAMenuOption();
                chooseOption();
            }
        }
    }

}
