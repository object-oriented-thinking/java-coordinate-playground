package coordinate;

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
}
