package viewer;

public class AnalysisViewer {

    public void displayCurrentTurn(int turn) {
        System.out.println("Current turn: " + turn);
    }

    public void displayCurrentlyLivingOrganisms(String species, int count) {
        System.out.println(species + " (Living):" + "count= " + count);
    }

    public void displayCurrentlyDeceasedOrganisms(String species, int count) {
        System.out.println(species + " (Deceased):" + " count= " + count);
    }

}
