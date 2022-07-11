package rent.domain2;

public abstract class Car implements ICar {
    public double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
