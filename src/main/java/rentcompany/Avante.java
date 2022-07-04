package rentcompany;

import java.util.Objects;

public class Avante extends Car {

    private static final double fuelEfficiency = 15;
    private final double distance;

    public Avante(final double distance) {
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
        return "Avante";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avante avante = (Avante) o;
        return Double.compare(avante.distance, distance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
