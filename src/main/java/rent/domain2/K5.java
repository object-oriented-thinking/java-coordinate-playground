package rent.domain2;

public class K5 extends Car {
    private static final int distancePerLiter = 13;
    private final int tripDistance;

    public K5(int tripDistance) {
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
        return "K5";
    }
}
