package analyser;

import simulation.OrganismRegisterObserver;
import simulation.OrganismsRegister;

public class NewOrganismsAnalyser extends Analyser implements OrganismRegisterObserver {

    OrganismsRegister organismsRegister;


    public NewOrganismsAnalyser(OrganismsRegister organismsRegister) {
        this.organismsRegister = organismsRegister;
        organismsRegister.registerObserver(this);
    }

    @Override
    public void update() {
        allOrganismsSet = organismsRegister.getNewBornOrganisms();
    }

}
