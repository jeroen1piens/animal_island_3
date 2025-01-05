import java.util.Map;

public class Wolf extends Animal {
    //public final int id;
    //public int runCounter = 0;
    //private static int count = 0;
    private double weight = 50;
    private double requiredFoodWeight = 8;
    private Map<String, Integer> catchMap = CatchMaps.WOLFCATCHMAP;


    public Wolf() {
        //id = count;
        //count++;
    }


    @Override
    public void run() {
        move(3);
        /*
        if (id == 0) {
            runCounter++;
            System.out.println(getClass().getSimpleName() + " " + this.hashCode() + ",(X:" + getXCoordinate()+ " , Y:" + getYCoordinate() + ")" + " Run method activation : " + runCounter);
        }
        */
    }

    @Override
    protected double getRequiredFoodWeight() {
        return requiredFoodWeight;
    }

    @Override
    public Map<String, Integer> getCatchMap() {
        return catchMap;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
