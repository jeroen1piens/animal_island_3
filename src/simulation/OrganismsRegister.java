package simulation;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class OrganismsRegister {

    private int turn;
    private Set<Organism> organismSet = new HashSet<>();

    public OrganismsRegister(int turn) {
        this.turn = turn;
    }

    public void registerOrganisms(Set<Organism> organisms) {
        organismSet.addAll(organisms);
    }

    public int getTurn() {
        return turn;
    }

    public Set<Organism> getAliveOrganisms() {
        return organismSet.stream()
                .filter(organism -> organism.isAlive())
                .collect(Collectors.toSet());
    }

    public Set<Organism> getDeceasedAnimals() {
        return organismSet.stream()
                .filter(organism -> !organism.isAlive())
                .collect(Collectors.toSet());
    }

}
