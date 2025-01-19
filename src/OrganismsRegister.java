import java.util.Set;

public interface OrganismsRegister {
    public void registerOrganism(Organism organism);
    public void registerObserver(OrganismRegisterObserver observer);
    public void removeObserver(OrganismRegisterObserver observer);
    public void notifyObservers();

    public int getCurrentTurn();
    public Set<Organism> getAliveOrganisms(int turn);
    public Set<Organism> getAliveOrganisms();

    public Set<Organism> getNewBornOrganisms(int turn);
    public Set<Organism> getNewBornOrganisms();
    public Set<Organism> getDeceasedAnimals(int turn);
    public Set<Organism> getDeceasedAnimals();



}
