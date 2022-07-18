package coordinate.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class Rectangle implements Shapes {
    public static final String REGEX = "-";
    private final List<Coordinate> coordinates;

    public Rectangle(String expression) {

        if (!expression.contains(REGEX)) {
            throw new IllegalArgumentException("식이 틀렸습니다.");
        }

        if (expression.split(REGEX).length != 4) {
            throw new IllegalArgumentException("좌표는 네 개 만 들어가야 합니다.");
        }

        List<Coordinate> coordinateList = Arrays.asList(
            new Coordinate(expression.split(REGEX)[0]),
            new Coordinate(expression.split(REGEX)[1]),
            new Coordinate(expression.split(REGEX)[2]),
            new Coordinate(expression.split(REGEX)[3])
        );

        List<Double> distanceList = Arrays.asList(
            getDistance(coordinateList.get(0), coordinateList.get(1)),
            getDistance(coordinateList.get(1), coordinateList.get(2)),
            getDistance(coordinateList.get(2), coordinateList.get(3)),
            getDistance(coordinateList.get(3), coordinateList.get(0))
        );

        if (distanceList.stream().distinct().count() != 2) {
            throw new IllegalArgumentException();
        }

        this.coordinates = coordinateList;
    }

    @Override
    public double getResult() {
        return getArea(coordinates);
    }

    private double getArea(List<Coordinate> coordinates) {
        List<Double> distanceList = Arrays.asList(
            getDistance(coordinates.get(0), coordinates.get(1)),
            getDistance(coordinates.get(1), coordinates.get(2)),
            getDistance(coordinates.get(2), coordinates.get(3)),
            getDistance(coordinates.get(3), coordinates.get(0))
        );
        return distanceList.stream().distinct()
            .reduce((double1, double2) -> double1 * double2)
            .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<Coordinate> findCoordinates() {
        return new ArrayList<>(coordinates);
    }

    private double getDistance(Coordinate coordinate, Coordinate otherCoordinate) {
        return Math.sqrt(
            abs((coordinate.getX() - otherCoordinate.getX()) * (coordinate.getX() - otherCoordinate.getX())
                + (coordinate.getY() - otherCoordinate.getY()) * (coordinate.getY() - otherCoordinate.getY())));
    }

}
