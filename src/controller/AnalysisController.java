package controller;

import analyser.AnalysisSettings;
import analyser.CurrentDeceasedOrganismsAnalyser;
import analyser.CurrentLivingOrganismsAnalyser;
import analyser.CurrentOrganismsAnalyser;
import simulation.IslandSimulator;
import simulation.Organism;
import viewer.AnalysisViewer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AnalysisController {

    private CurrentDeceasedOrganismsAnalyser deceasedOrganismsAnalyser;
    private CurrentLivingOrganismsAnalyser livingOrganismsAnalyser;
    private AnalysisViewer analysisViewer = new AnalysisViewer();
    private List<CurrentOrganismsAnalyser> currentOrganismsAnalysers;
    private IslandSimulator islandSimulator;

    public AnalysisController(IslandSimulator islandSimulator) {
        this.islandSimulator = islandSimulator;
        currentOrganismsAnalysers = new ArrayList<>();
        if(AnalysisSettings.isDeceasedOrganismsAnalysisOn()) {
            deceasedOrganismsAnalyser = new CurrentDeceasedOrganismsAnalyser();
            currentOrganismsAnalysers.add(deceasedOrganismsAnalyser);
        }
        if(AnalysisSettings.isLivingOrganismsAnalysisOn()) {
            livingOrganismsAnalyser = new CurrentLivingOrganismsAnalyser();
            currentOrganismsAnalysers.add(livingOrganismsAnalyser);
        }
    }

    public void updateCurrentOrganisms(int turn, Set<Organism> organisms) {
        for (CurrentOrganismsAnalyser currentOrganismsAnalyser : currentOrganismsAnalysers) {
            currentOrganismsAnalyser.updateCurrentOrganisms(turn, organisms);
            if(currentOrganismsAnalyser instanceof CurrentDeceasedOrganismsAnalyser) {
                analysisViewer.displayCurrentTurn(turn);
                analysisViewer.displayCurrentlyDeceasedOrganisms("Bear", deceasedOrganismsAnalyser.getBearCount());
                analysisViewer.displayCurrentlyDeceasedOrganisms("Boa", deceasedOrganismsAnalyser.getBoaCount());
                analysisViewer.displayCurrentlyDeceasedOrganisms("Boar", deceasedOrganismsAnalyser.getBoarCount());
                analysisViewer.displayCurrentlyDeceasedOrganisms("Buffalo", deceasedOrganismsAnalyser.getBuffaloCount());
                analysisViewer.displayCurrentlyDeceasedOrganisms("Caterpillar", deceasedOrganismsAnalyser.getCaterpillarCount());
                analysisViewer.displayCurrentlyDeceasedOrganisms("Deer", deceasedOrganismsAnalyser.getDeerCount());
                analysisViewer.displayCurrentlyDeceasedOrganisms("Duck", deceasedOrganismsAnalyser.getDuckCount());
                analysisViewer.displayCurrentlyDeceasedOrganisms("Eagle", deceasedOrganismsAnalyser.getEagleCount());
                analysisViewer.displayCurrentlyDeceasedOrganisms("Fox", deceasedOrganismsAnalyser.getFoxCount());
                analysisViewer.displayCurrentlyDeceasedOrganisms("Goat", deceasedOrganismsAnalyser.getGoatCount());
                analysisViewer.displayCurrentlyDeceasedOrganisms("Horse", deceasedOrganismsAnalyser.getHorseCount());
                analysisViewer.displayCurrentlyDeceasedOrganisms("Mouse", deceasedOrganismsAnalyser.getMouseCount());
                analysisViewer.displayCurrentlyDeceasedOrganisms("Plant", deceasedOrganismsAnalyser.getPlantCount());
                analysisViewer.displayCurrentlyDeceasedOrganisms("Rabbit", deceasedOrganismsAnalyser.getRabbitCount());
                analysisViewer.displayCurrentlyDeceasedOrganisms("Sheep", deceasedOrganismsAnalyser.getSheepCount());
                analysisViewer.displayCurrentlyDeceasedOrganisms("Wolf", deceasedOrganismsAnalyser.getWolfCount());

            }
            if(currentOrganismsAnalyser instanceof  CurrentLivingOrganismsAnalyser) {
                analysisViewer.displayCurrentTurn(turn);
                analysisViewer.displayCurrentlyLivingOrganisms("Bear", livingOrganismsAnalyser.getBearCount());
                analysisViewer.displayCurrentlyLivingOrganisms("Boa", livingOrganismsAnalyser.getBoaCount());
                analysisViewer.displayCurrentlyLivingOrganisms("Boar", livingOrganismsAnalyser.getBoarCount());
                analysisViewer.displayCurrentlyLivingOrganisms("Buffalo", livingOrganismsAnalyser.getBuffaloCount());
                analysisViewer.displayCurrentlyLivingOrganisms("Caterpillar", livingOrganismsAnalyser.getCaterpillarCount());
                analysisViewer.displayCurrentlyLivingOrganisms("Deer", livingOrganismsAnalyser.getDeerCount());
                analysisViewer.displayCurrentlyLivingOrganisms("Duck", livingOrganismsAnalyser.getDuckCount());
                analysisViewer.displayCurrentlyLivingOrganisms("Eagle", livingOrganismsAnalyser.getEagleCount());
                analysisViewer.displayCurrentlyLivingOrganisms("Fox", livingOrganismsAnalyser.getFoxCount());
                analysisViewer.displayCurrentlyLivingOrganisms("Goat", livingOrganismsAnalyser.getGoatCount());
                analysisViewer.displayCurrentlyLivingOrganisms("Horse", livingOrganismsAnalyser.getHorseCount());
                analysisViewer.displayCurrentlyLivingOrganisms("Mouse", livingOrganismsAnalyser.getMouseCount());
                analysisViewer.displayCurrentlyLivingOrganisms("Plant", livingOrganismsAnalyser.getPlantCount());
                analysisViewer.displayCurrentlyLivingOrganisms("Rabbit", livingOrganismsAnalyser.getRabbitCount());
                analysisViewer.displayCurrentlyLivingOrganisms("Sheep", livingOrganismsAnalyser.getSheepCount());
                analysisViewer.displayCurrentlyLivingOrganisms("Wolf", livingOrganismsAnalyser.getWolfCount());
            }
        }
    }

}
