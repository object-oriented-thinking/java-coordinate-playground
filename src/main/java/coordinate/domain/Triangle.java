package coordinate.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Triangle implements Shapes {
    public static final String REGEX = "-";
    private final List<Coordinate> coordinates;


    public Triangle(String expression) {

        if (!expression.contains(REGEX)) {
            throw new IllegalArgumentException("식이 틀렸습니다.");
        }

        if (expression.split(REGEX).length != 3) {
            throw new IllegalArgumentException("좌표는 세 개만 들어가야 합니다.");
        }

        List<Coordinate> coordinateList = Arrays.asList(
            new Coordinate(expression.split(REGEX)[0]),
            new Coordinate(expression.split(REGEX)[1]),
            new Coordinate(expression.split(REGEX)[2])
        );

        this.coordinates = coordinateList;
    }

    @Override
    public double getResult() {
        return getArea(this.coordinates);
    }

    private double getArea(List<Coordinate> coordinates) {
        double a = getDistance(coordinates.get(0), coordinates.get(1));
        double b = getDistance(coordinates.get(1), coordinates.get(2));
        double c = getDistance(coordinates.get(2), coordinates.get(0));
        double s = (a + b + c) / 2;
        return sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public List<Coordinate> findCoordinates() {
        return new ArrayList<>(this.coordinates);
    }

    private double getDistance(Coordinate coordinate, Coordinate otherCoordinate) {
        return sqrt(
            abs((coordinate.getX() - otherCoordinate.getX()) * (coordinate.getX() - otherCoordinate.getX())
                + (coordinate.getY() - otherCoordinate.getY()) * (coordinate.getY() - otherCoordinate.getY())));
    }
}
