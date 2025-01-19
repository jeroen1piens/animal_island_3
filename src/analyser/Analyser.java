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

public class Analyser {
    protected Set<Organism> allOrganismsSet;
    protected Set<Bear> allBearsSet = new HashSet<>();
    protected Set<Boa> allBoasSet = new HashSet<>();
    protected Set<Boar> allBoarsSet = new HashSet<>();
    protected Set<Buffalo> allBuffalosSet = new HashSet<>();
    protected Set<Caterpillar> allCaterpillarsSet = new HashSet<>();
    protected Set<Deer> allDeerSet = new HashSet<>();
    protected Set<Duck> allDucksSet = new HashSet<>();
    protected Set<Eagle> allEaglesSet = new HashSet<>();
    protected Set<Fox> allFoxesSet = new HashSet<>();
    protected Set<Goat> allGoatsSet = new HashSet<>();
    protected Set<Horse> allHorsesSet = new HashSet<>();
    protected Set<Mouse> allMiceSet = new HashSet<>();
    protected Set<Plant> allPlantsSet = new HashSet<>();
    protected Set<Rabbit> allRabbitsSet = new HashSet<>();
    protected Set<Sheep> allSheepSet = new HashSet<>();
    protected Set<Wolf> allWolfsSet = new HashSet<>();

    protected void updateAllSets() {
        resetSets();
        for (Organism organism : allOrganismsSet) {
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

    protected void resetSets() {
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

    public int getAllOrganismsCount() {
        return allOrganismsSet.size();
    }
    public int getBearCount() {
        return allBearsSet.size();
    }
    public int getBoaCount() {
        return allBoasSet.size();
    }
    public int getBoarCount() {
        return allBoarsSet.size();
    }
    public int getBuffaloCount() {
        return allBuffalosSet.size();
    }
    public int getCaterpillarCount() {
        return allCaterpillarsSet.size();
    }
    public int getDeerCount() {
        return allDeerSet.size();
    }
    public int getDuckCount() {
        return allDucksSet.size();
    }
    public int getEagleCount() {
        return allEaglesSet.size();
    }
    public int getFoxCount() {
        return allFoxesSet.size();
    }
    public int getGoatCount() {
        return allGoatsSet.size();
    }
    public int getHorseCount() {
        return allHorsesSet.size();
    }
    public int getMouseCount() {
        return allMiceSet.size();
    }
    public int getPlantCount() {
        return allPlantsSet.size();
    }
    public int getRabbitCount() {
        return allRabbitsSet.size();
    }
    public int getSheepCount() {
        return  allSheepSet.size();
    }
    public int getWolfCount() {
        return allWolfsSet.size();
    }
}
