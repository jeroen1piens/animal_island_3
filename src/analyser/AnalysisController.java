package analyser;

import simulation.IslandSimulator;

import java.util.ArrayList;
import java.util.List;

public class AnalysisController {

    private DeceasedOrganismsAnalyser deceasedOrganismsAnalyser;
    private LivingOrganismsAnalyser livingOrganismsAnalyser;
    private NewOrganismsAnalyser newOrganismsAnalyser;
    private List<Analyser> analysers;
    private IslandSimulator islandSimulator;

    public AnalysisController(IslandSimulator islandSimulator) {
        this.islandSimulator = islandSimulator;
        analysers = new ArrayList<>();
        if(AnalysisSettings.isDeceasedOrganismsAnalysisOn()) {
            deceasedOrganismsAnalyser = new DeceasedOrganismsAnalyser(islandSimulator.getAllOrganismsRegister());
            analysers.add(deceasedOrganismsAnalyser);
        }
        if(AnalysisSettings.isLivingOrganismsAnalysisOn()) {
            livingOrganismsAnalyser = new LivingOrganismsAnalyser(islandSimulator.getAllOrganismsRegister());
            analysers.add(livingOrganismsAnalyser);
        }
        if(AnalysisSettings.isNewBornOrganismsAnalysisOn()) {
            newOrganismsAnalyser = new NewOrganismsAnalyser(islandSimulator.getAllOrganismsRegister());
            analysers.add(newOrganismsAnalyser);
        }
    }

}
