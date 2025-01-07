import java.util.ArrayList;
import java.util.List;

public class OrganismFactory {


    public Wolf createWolf(double fedLevel) {
        return new Wolf(fedLevel);
    }
    public Boa createBoa(double fedLevel) {return new Boa(fedLevel);}
    public Fox createFox(double fedLevel) {return new Fox(fedLevel);}
    public Bear createBear(double fedLevel) {return new Bear(fedLevel);}
    public Eagle createEagle(double fedLevel) {return new Eagle(fedLevel);}
    public Horse createHorse(double fedLevel) {return new Horse(fedLevel);}
    public Deer createDeer(double fedLevel) {return new Deer(fedLevel);}
    public Rabbit createRabbit(double fedLevel) {return new Rabbit(fedLevel);}
    public Mouse createMouse(double fedLevel) {return new Mouse(fedLevel);}
    public Goat createGoat(double fedLevel) {return new Goat(fedLevel);}
    public Sheep createSheep(double fedLevel) {
        return new Sheep(fedLevel);
    }
    public Boar createBoar(double fedLevel) {return new Boar(fedLevel);}
    public Buffalo createBuffalo(double fedLevel) {return new Buffalo(fedLevel);}
    public Duck createDuck(double fedLevel) {return new Duck(fedLevel);}
    public Caterpillar createCaterpillar(double fedLevel) {return new Caterpillar(fedLevel);}
    public Plant createPlant() {
        return new Plant();
    }

    public Animal createAnimal(Class<? extends Animal> clazz, double fedLevel) {
        switch(clazz.getSimpleName()) {
            case "Wolf" -> {return createWolf(fedLevel);}
            case "Boa" -> {return createBoa(fedLevel);}
            case "Fox" -> {return createFox(fedLevel);}
            case "Bear" -> {return createBear(fedLevel);}
            case "Eagle" -> {return createEagle(fedLevel);}
            case "Horse" -> {return createHorse(fedLevel);}
            case "Deer" -> {return createDeer(fedLevel);}
            case "Rabbit" -> {return createRabbit(fedLevel);}
            case "Mouse" -> {return createMouse(fedLevel);}
            case "Goat" -> {return createGoat(fedLevel);}
            case "Sheep" -> {return createSheep(fedLevel);}
            case "Boar" -> {return createBoar(fedLevel);}
            case "Buffalo" -> {return createBuffalo(fedLevel);}
            case "Duck" -> {return createDuck(fedLevel);}
            case "Caterpillar" -> {return createCaterpillar(fedLevel);}
            default -> {return null;}
        }
    }
}
