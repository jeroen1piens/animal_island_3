package controller;

import simulation.StartSettings;
import viewer.AnalysisSettingsView;
import viewer.IslandSizeSettingsView;

import java.util.Scanner;

public class AnalysisSettingsController {

    AnalysisSettingsView analysisSettingsView = new AnalysisSettingsView();
    SettingsMenuController settingsMenuController;

    public AnalysisSettingsController(SettingsMenuController settingsMenuController) {
        this.settingsMenuController = settingsMenuController;
    }
}
