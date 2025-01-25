package analyser;

import java.util.HashSet;
import java.util.Set;
import simulation.Organism;
import simulation.Bear;
import simulation.Boa;
import simulation.Boar;
import simulation.Buffalo;
import simulation.Caterpillar;
import simulation.Deer;
import simulation.Duck;
import simulation.Eagle;
import simulation.Fox;
import simulation.Goat;
import simulation.Horse;
import simulation.Mouse;
import simulation.Plant;
import simulation.Rabbit;
import simulation.Sheep;
import simulation.Wolf;

public abstract class CurrentOrganismsAnalyser implements OrganismAnalyser {
    protected Set<Organism> allOrganismsSet;

    protected int turn;

    public void updateCurrentOrganisms(int turn, Set<Organism> organisms) {
        this.turn = turn;
        this.allOrganismsSet = organisms;
    }

    public int getAllOrganismsCount() {
        return allOrganismsSet.size();
    }

    public int getTurn() {
        return turn;
    }

}
