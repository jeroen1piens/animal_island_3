import java.util.*;

public class Analytics {
    private Collection<Organism> allOrganismsCollection;
    private Set<Plant> allPlantsSet = new HashSet<>();
    private Set<Sheep> allSheepSet = new HashSet<>();
    private Set<Wolf> allWolfsSet = new HashSet<>();



    public Analytics() {
    }

    public void updateAllOrganismsCollection(Collection<Organism> allOrganismsCollection) {
        this.allOrganismsCollection = allOrganismsCollection;
        updateAllSets();
    }
    private void updateAllSets() {
        resetSets();
        for (Organism organism : allOrganismsCollection) {
            switch(organism.getClass().getSimpleName()) {
                case "Plant" -> allPlantsSet.add((Plant) organism);
                case "Sheep" -> allSheepSet.add((Sheep) organism);
                case "Wolf" -> allWolfsSet.add((Wolf) organism);
            }
        }
    }

    private void resetSets() {
        allPlantsSet = new HashSet<>();
        allSheepSet = new HashSet<>();
        allWolfsSet = new HashSet<>();
    }

    public Map<String, Integer> getOrganismsCountMap() {
        Map<String, Integer> organismsCountMap = new HashMap<>();
        organismsCountMap.put("Total Organisms", allOrganismsCollection.size());
        organismsCountMap.put("Plants", allPlantsSet.size());
        organismsCountMap.put("Sheep", allSheepSet.size());
        organismsCountMap.put("Wolfs", allWolfsSet.size());
        return organismsCountMap;
    }
}
