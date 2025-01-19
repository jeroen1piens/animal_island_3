public class NewBornAnimalsAnalyser extends Analyser implements OrganismRegisterObserver {

    OrganismsRegister organismsRegister;


    public NewBornAnimalsAnalyser(OrganismsRegister organismsRegister) {
        this.organismsRegister = organismsRegister;
    }

    @Override
    public void update() {
        allOrganismsSet = organismsRegister.getNewBornOrganisms();
    }

}
