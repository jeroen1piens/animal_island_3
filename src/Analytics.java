import java.util.*;

public class Analytics {
    private Collection<Organism> allOrganismsCollection;


    private Set<Bear> allBearsSet = new HashSet<>();
    private Set<Boa> allBoasSet = new HashSet<>();
    private Set<Boar> allBoarsSet = new HashSet<>();
    private Set<Buffalo> allBuffalosSet = new HashSet<>();
    private Set<Caterpillar> allCaterpillarsSet = new HashSet<>();
    private Set<Deer> allDeerSet = new HashSet<>();
    private Set<Duck> allDucksSet = new HashSet<>();
    private Set<Eagle> allEaglesSet = new HashSet<>();
    private Set<Fox> allFoxesSet = new HashSet<>();
    private Set<Goat> allGoatsSet = new HashSet<>();
    private Set<Horse> allHorsesSet = new HashSet<>();
    private Set<Mouse> allMiceSet = new HashSet<>();
    private Set<Plant> allPlantsSet = new HashSet<>();
    private Set<Rabbit> allRabbitsSet = new HashSet<>();
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
                case "Bear" -> allBearsSet.add((Bear) organism);
                case "Boa" -> allBoasSet.add((Boa) organism);
                case "Boar" -> allBoarsSet.add((Boar) organism);
                case "Buffalo" -> allBuffalosSet.add((Buffalo) organism);
                case "Caterpillar" -> allCaterpillarsSet.add((Caterpillar) organism);
                case "Deer" -> allDeerSet.add((Deer) organism);
                case "Duck" -> allDucksSet.add((Duck) organism);
                case "Eagle" -> allEaglesSet.add((Eagle) organism);
                case "Fox" -> allFoxesSet.add((Fox) organism);
                case "Goat" -> allGoatsSet.add((Goat) organism);
                case "Horse" -> allHorsesSet.add((Horse) organism);
                case "Mouse" -> allMiceSet.add((Mouse) organism);
                case "Plant" -> allPlantsSet.add((Plant) organism);
                case "Rabbit" -> allRabbitsSet.add((Rabbit) organism);
                case "Sheep" -> allSheepSet.add((Sheep) organism);
                case "Wolf" -> allWolfsSet.add((Wolf) organism);
            }
        }
    }

    private void resetSets() {
        allBearsSet = new HashSet<>();
        allBoasSet = new HashSet<>();
        allBoarsSet = new HashSet<>();
        allBuffalosSet = new HashSet<>();
        allCaterpillarsSet = new HashSet<>();
        allDeerSet = new HashSet<>();
        allDucksSet = new HashSet<>();
        allEaglesSet = new HashSet<>();
        allFoxesSet = new HashSet<>();
        allGoatsSet = new HashSet<>();
        allHorsesSet = new HashSet<>();
        allMiceSet = new HashSet<>();
        allPlantsSet = new HashSet<>();
        allRabbitsSet = new HashSet<>();
        allSheepSet = new HashSet<>();
        allWolfsSet = new HashSet<>();
    }

    public Map<String, Integer> getOrganismsCountMap() {
        Map<String, Integer> organismsCountMap = new HashMap<>();
        organismsCountMap.put("Bear", allBearsSet.size());
        organismsCountMap.put("Boa", allBoasSet.size());
        organismsCountMap.put("Boar", allBoarsSet.size());
        organismsCountMap.put("Buffalo", allBuffalosSet.size());
        organismsCountMap.put("Caterpillar", allCaterpillarsSet.size());
        organismsCountMap.put("Deer", allDeerSet.size());
        organismsCountMap.put("Duck", allDucksSet.size());
        organismsCountMap.put("Eagle", allEaglesSet.size());
        organismsCountMap.put("Fox", allEaglesSet.size());
        organismsCountMap.put("Goat", allGoatsSet.size());
        organismsCountMap.put("Horse", allHorsesSet.size());
        organismsCountMap.put("Mouse", allMiceSet.size());
        organismsCountMap.put("Plant", allPlantsSet.size());
        organismsCountMap.put("Rabbit", allRabbitsSet.size());
        organismsCountMap.put("Sheep", allSheepSet.size());
        organismsCountMap.put("Wolf", allWolfsSet.size());
        return organismsCountMap;
    }
}
