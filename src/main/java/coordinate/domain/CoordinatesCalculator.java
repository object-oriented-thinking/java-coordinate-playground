package coordinate.domain;

import java.util.List;

public class CoordinatesCalculator {
    private static final String REGEX = "-";
    private final Shapes shapes;

    public CoordinatesCalculator(String expression) {
        if (expression.split(REGEX).length == 2) {
            shapes = new Line(expression);
            return;
        }

        if (expression.split(REGEX).length == 3) {
            shapes = new Triangle(expression);
            return;
        }

        if (expression.split(REGEX).length == 4) {
            shapes = new Rectangle(expression);
            return;
        }

        throw new IllegalArgumentException();
    }

    public Shapes getShapes() {
        return shapes;
    }

    public Double getResult() {
        return shapes.getResult();
    }

    public List<Coordinate> findCoordinates() {
        return shapes.findCoordinates();
    }
}
