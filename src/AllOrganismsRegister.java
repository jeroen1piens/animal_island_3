import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AllOrganismsRegister implements TurnObserver, OrganismsRegister {

    private int currentTurn = 0;
    private Set<Organism> currentTurnOrganismSet = new HashSet<>();
    private Map<Integer, Set<Organism>> turnRecordsMap = new HashMap<>();
    private Set<OrganismRegisterObserver> observers = new HashSet<>();

    public void registerOrganism(Organism organism) {
        currentTurnOrganismSet.add(organism);
    }

    public void registerObserver(OrganismRegisterObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(OrganismRegisterObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (OrganismRegisterObserver observer : observers) {
            observer.update();
        }
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public Set<Organism> getAliveOrganisms(int turn) {
        return turnRecordsMap.get(turn).stream()
                .filter(organism -> organism.isAlive())
                .collect(Collectors.toSet());
    }

    public Set<Organism> getAliveOrganisms() {
        return getAliveOrganisms(currentTurn);
    }

    public Set<Organism> getNewBornOrganisms(int turn) {
        return turnRecordsMap.get(turn).stream()
                .filter(organism -> organism.isAlive())
                .collect(Collectors.toSet());
    }

    public Set<Organism> getNewBornOrganisms() {
        return getNewBornOrganisms(currentTurn);
    }

    public Set<Organism> getDeceasedAnimals(int turn) {
        return turnRecordsMap.get(turn).stream()
                .filter(organism -> !organism.isAlive())
                .collect(Collectors.toSet());
    }

    public Set<Organism> getDeceasedAnimals() {
        return getDeceasedAnimals(currentTurn);
    }

    @Override
    public void updateForNextTurn() {
        currentTurn++;
        currentTurnOrganismSet = new HashSet<>();
        turnRecordsMap.put(currentTurn, currentTurnOrganismSet);
        if(currentTurn > 1) {
            Set<Organism> aliveOrganismsSet = turnRecordsMap.get(currentTurn-1)
                    .stream()
                    .filter(organism -> organism.isAlive())
                    .collect(Collectors.toSet());
            currentTurnOrganismSet.addAll(aliveOrganismsSet);
        }
    }
}
