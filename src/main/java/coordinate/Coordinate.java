package coordinate;

import static java.lang.Math.abs;

public class Coordinate {
    private final double x;
    private final double y;

    public Coordinate(String stringX, String stringY) {

        try {
            if (1.0 > Double.parseDouble(stringX) || Double.parseDouble(stringX) > 24.0) {
                throw new IllegalArgumentException();
            }
            if (1.0 > Double.parseDouble(stringY) || Double.parseDouble(stringY) > 24.0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        x = Double.parseDouble(stringX);
        y = Double.parseDouble(stringY);
    }

    public double getDistance(Coordinate secondCoordinate) {
        return Math.sqrt(
            abs(
                (x - secondCoordinate.x) * (x - secondCoordinate.x)
                    - (y - secondCoordinate.y) * (y - secondCoordinate.y))
        );
    }
}
