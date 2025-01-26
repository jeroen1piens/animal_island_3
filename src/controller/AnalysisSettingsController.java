package controller;

import analyser.AnalysisSettings;
import simulation.StartSettings;
import viewer.AnalysisSettingsView;
import viewer.CommonMessages;
import viewer.IslandSizeSettingsView;

import java.util.Scanner;

public class AnalysisSettingsController {

    AnalysisSettingsView analysisSettingsView = new AnalysisSettingsView();
    SettingsMenuController settingsMenuController;

    public AnalysisSettingsController(SettingsMenuController settingsMenuController) {
        this.settingsMenuController = settingsMenuController;
    }

    public void chooseOption() {
        analysisSettingsView.displayOptions();
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        switch (choice) {
            case "1" -> {
                analysisSettingsView.displayCurrentSettings(AnalysisSettings.isDeceasedOrganismsAnalysisOn(), AnalysisSettings.isLivingOrganismsAnalysisOn());
                chooseOption();
            }
            case "2" -> {
                AnalysisSettings.setDeceasedOrganismsAnalysisOn(true);
                chooseOption();
            }
            case "3" -> {
                AnalysisSettings.setDeceasedOrganismsAnalysisOn(false);
                chooseOption();
            }
            case "4" -> {
                AnalysisSettings.setLivingOrganismsAnalysisOn(true);
                chooseOption();
            }
            case "5" -> {
                AnalysisSettings.setLivingOrganismsAnalysisOn(false);
                chooseOption();
            }
            case "6" -> {
                settingsMenuController.chooseOption();
            }
            default -> {
                analysisSettingsView.displayNotAMenuOption();
                chooseOption();
            }
        }
    }



}
