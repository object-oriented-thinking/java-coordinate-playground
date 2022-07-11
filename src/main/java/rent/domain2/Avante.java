package rent.domain2;

public class Avante extends Car {
    private static final int distancePerLiter = 15;
    private final int tripDistance;

    public Avante(int tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    public double getDistancePerLiter() {
        return distancePerLiter;
    }

    @Override
    public double getTripDistance() {
        return tripDistance;
    }

    @Override
    public String getName() {
        return "Avante";
    }
}
