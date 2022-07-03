public class K5 extends Car{
    private double distance;

    public K5(double distance) {
        this.distance = distance;
    }

    @Override
    double getDistancePerLiter() {
        return 13;
    }

    @Override
    double getTripDistance() {
        return this.distance;
    }

    @Override
    String getName() {
        return null;
    }
}
