public class LivingAnimalsAnalyser extends Analyser implements OrganismRegisterObserver {

    OrganismsRegister organismsRegister;

    public LivingAnimalsAnalyser(OrganismsRegister organismsRegister) {
        this.organismsRegister = organismsRegister;
    }

    @Override
    public void update() {
        allOrganismsSet = organismsRegister.getAliveOrganisms();
    }
}
