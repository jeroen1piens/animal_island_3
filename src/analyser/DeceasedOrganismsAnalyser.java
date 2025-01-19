package analyser;

import simulation.OrganismRegisterObserver;
import simulation.OrganismsRegister;

public class DeceasedOrganismsAnalyser extends Analyser implements OrganismRegisterObserver {

    OrganismsRegister organismsRegister;


    public DeceasedOrganismsAnalyser(OrganismsRegister organismsRegister) {
        this.organismsRegister = organismsRegister;
        organismsRegister.registerObserver(this);
    }

    @Override
    public void update() {
        allOrganismsSet = organismsRegister.getDeceasedAnimals();
    }
}
