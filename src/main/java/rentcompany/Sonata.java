package rentcompany;

public class Sonata extends Car {

    private static final double fuelEfficiency = 10;
    private final double distance;

    public Sonata(final double distance) {
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
        return "Sonata";
    }
}
