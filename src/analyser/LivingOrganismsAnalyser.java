package analyser;

import simulation.OrganismRegisterObserver;
import simulation.OrganismsRegister;

public class LivingOrganismsAnalyser extends Analyser implements OrganismRegisterObserver {

    OrganismsRegister organismsRegister;

    public LivingOrganismsAnalyser(OrganismsRegister organismsRegister) {
        this.organismsRegister = organismsRegister;
        organismsRegister.registerObserver(this);
    }

    @Override
    public void update() {
        allOrganismsSet = organismsRegister.getAliveOrganisms();
    }
}
