package controller;

import simulation.StartSettings;
import viewer.IslandSizeSettingsView;
import viewer.OrganismsSettingsView;

import java.util.Scanner;

public class OrganismsSettingsController {

    OrganismsSettingsView organismsSettingsView = new OrganismsSettingsView();
    SettingsMenuController settingsMenuController;

    public OrganismsSettingsController(SettingsMenuController settingsMenuController) {
        this.settingsMenuController = settingsMenuController;
    }

    public void chooseOption() {
        organismsSettingsView.displayOptions();
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice) {
            case "1" -> {
                organismsSettingsView.displayTitleInitialOrganisms();
                organismsSettingsView.displayInitialBears(StartSettings.getBearCount());
                organismsSettingsView.displayInitialBoas(StartSettings.getBoaCount());
                organismsSettingsView.displayInitialBoars(StartSettings.getBoarCount());
                organismsSettingsView.displayInitialBuffalos(StartSettings.getBuffaloCount());
                organismsSettingsView.displayInitialCaterpillars(StartSettings.getCaterpillarCount());
                organismsSettingsView.displayInitialDeer(StartSettings.getDeerCount());
                organismsSettingsView.displayInitialDucks(StartSettings.getDuckCount());
                organismsSettingsView.displayInitialEagles(StartSettings.getEagleCount());
                organismsSettingsView.displayInitialFoxes(StartSettings.getFoxCount());
                organismsSettingsView.displayInitialGoats(StartSettings.getGoatCount());
                organismsSettingsView.displayInitialHorses(StartSettings.getHorseCount());
                organismsSettingsView.displayInitialMice(StartSettings.getMouseCount());
                organismsSettingsView.displayInitialPlants(StartSettings.getPlantCount());
                organismsSettingsView.displayInitialRabbits(StartSettings.getRabbitCount());
                organismsSettingsView.displayInitialSheep(StartSettings.getSheepCount());
                organismsSettingsView.displayInitialWolfs(StartSettings.getWolfCount());
                chooseOption();
            }
            case "2" -> {
                organismsSettingsView.askInput();
                String input = scanner.nextLine();
                int inputNumber = InputParser.parseInt(input);
                if (inputNumber > 0) {
                    StartSettings.setBearCount(inputNumber);
                }
                else {
                    organismsSettingsView.displayNotValidInput();
                }
                chooseOption();
            }
            case "3" -> {
                organismsSettingsView.askInput();
                String input = scanner.nextLine();
                int inputNumber = InputParser.parseInt(input);
                if (inputNumber > 0) {
                    StartSettings.setBoaCount(inputNumber);
                }
                else {
                    organismsSettingsView.displayNotValidInput();
                }
                chooseOption();
            }
            case "4" -> {
                organismsSettingsView.askInput();
                String input = scanner.nextLine();
                int inputNumber = InputParser.parseInt(input);
                if (inputNumber > 0) {
                    StartSettings.setBoarCount(inputNumber);
                }
                else {
                    organismsSettingsView.displayNotValidInput();
                }
                chooseOption();
            }
            case "5" -> {
                organismsSettingsView.askInput();
                String input = scanner.nextLine();
                int inputNumber = InputParser.parseInt(input);
                if (inputNumber > 0) {
                    StartSettings.setBuffaloCount(inputNumber);
                }
                else {
                    organismsSettingsView.displayNotValidInput();
                }
                chooseOption();
            }
            case "6" -> {
                organismsSettingsView.askInput();
                String input = scanner.nextLine();
                int inputNumber = InputParser.parseInt(input);
                if (inputNumber > 0) {
                    StartSettings.setCaterpillarCount(inputNumber);
                }
                else {
                    organismsSettingsView.displayNotValidInput();
                }
                chooseOption();
            }
            case "7" -> {
                organismsSettingsView.askInput();
                String input = scanner.nextLine();
                int inputNumber = InputParser.parseInt(input);
                if (inputNumber > 0) {
                    StartSettings.setDeerCount(inputNumber);
                }
                else {
                    organismsSettingsView.displayNotValidInput();
                }
                chooseOption();
            }
            case "8" -> {
                organismsSettingsView.askInput();
                String input = scanner.nextLine();
                int inputNumber = InputParser.parseInt(input);
                if (inputNumber > 0) {
                    StartSettings.setDuckCount(inputNumber);
                }
                else {
                    organismsSettingsView.displayNotValidInput();
                }
                chooseOption();
            }
            case "9" -> {
                organismsSettingsView.askInput();
                String input = scanner.nextLine();
                int inputNumber = InputParser.parseInt(input);
                if (inputNumber > 0) {
                    StartSettings.setEagleCount(inputNumber);
                }
                else {
                    organismsSettingsView.displayNotValidInput();
                }
                chooseOption();
            }
            case "10" -> {
                organismsSettingsView.askInput();
                String input = scanner.nextLine();
                int inputNumber = InputParser.parseInt(input);
                if (inputNumber > 0) {
                    StartSettings.setFoxCount(inputNumber);
                }
                else {
                    organismsSettingsView.displayNotValidInput();
                }
                chooseOption();
            }
            case "11" -> {
                organismsSettingsView.askInput();
                String input = scanner.nextLine();
                int inputNumber = InputParser.parseInt(input);
                if (inputNumber > 0) {
                    StartSettings.setGoatCount(inputNumber);
                }
                else {
                    organismsSettingsView.displayNotValidInput();
                }
                chooseOption();
            }
            case "12" -> {
                organismsSettingsView.askInput();
                String input = scanner.nextLine();
                int inputNumber = InputParser.parseInt(input);
                if (inputNumber > 0) {
                    StartSettings.setHorseCount(inputNumber);
                }
                else {
                    organismsSettingsView.displayNotValidInput();
                }
                chooseOption();
            }
            case "13" -> {
                organismsSettingsView.askInput();
                String input = scanner.nextLine();
                int inputNumber = InputParser.parseInt(input);
                if (inputNumber > 0) {
                    StartSettings.setMouseCount(inputNumber);
                }
                else {
                    organismsSettingsView.displayNotValidInput();
                }
                chooseOption();
            }
            case "14" -> {
                organismsSettingsView.askInput();
                String input = scanner.nextLine();
                int inputNumber = InputParser.parseInt(input);
                if (inputNumber > 0) {
                    StartSettings.setPlantCount(inputNumber);
                }
                else {
                    organismsSettingsView.displayNotValidInput();
                }
                chooseOption();
            }
            case "15" -> {
                organismsSettingsView.askInput();
                String input = scanner.nextLine();
                int inputNumber = InputParser.parseInt(input);
                if (inputNumber > 0) {
                    StartSettings.setRabbitCount(inputNumber);
                }
                else {
                    organismsSettingsView.displayNotValidInput();
                }
                chooseOption();
            }
            case "16" -> {
                organismsSettingsView.askInput();
                String input = scanner.nextLine();
                int inputNumber = InputParser.parseInt(input);
                if (inputNumber > 0) {
                    StartSettings.setSheepCount(inputNumber);
                }
                else {
                    organismsSettingsView.displayNotValidInput();
                }
                chooseOption();
            }
            case "17" -> {
                organismsSettingsView.askInput();
                String input = scanner.nextLine();
                int inputNumber = InputParser.parseInt(input);
                if (inputNumber > 0) {
                    StartSettings.setWolfCount(inputNumber);
                }
                else {
                    organismsSettingsView.displayNotValidInput();
                }
                chooseOption();
            }
            case "18" -> settingsMenuController.chooseOption();
            default -> {
                organismsSettingsView.displayNotAMenuOption();
                chooseOption();
            }
        }
    }

}
