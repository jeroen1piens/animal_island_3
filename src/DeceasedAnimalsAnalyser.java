import java.util.Set;

public class DeceasedAnimalsAnalyser extends Analyser implements OrganismRegisterObserver {

    OrganismsRegister organismsRegister;


    public DeceasedAnimalsAnalyser(OrganismsRegister organismsRegister) {
        this.organismsRegister = organismsRegister;
    }

    @Override
    public void update() {
        allOrganismsSet = organismsRegister.getDeceasedAnimals();
    }
}
