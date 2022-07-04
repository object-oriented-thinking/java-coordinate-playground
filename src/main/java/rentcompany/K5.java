package rentcompany;

public class K5 extends Car {

    private static final double fuelEfficiency = 13;
    private static String name = "K5";
    private final double distance;

    public K5(int distance) {
        this.distance = distance;

    }

    @Override
    double getDistancePerLiter() {
        return fuelEfficiency;
    }

    @Override
    double getTripDistance() {
        return distance;
    }

    @Override
    String getName() {
        return name;
    }
}
