package coordinate.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.abs;

public class Line implements Shapes {
    public static final String REGEX = "-";
    private final List<Coordinate> coordinates;

    public Line(String expression) {

        if (!expression.contains(REGEX)) {
            throw new IllegalArgumentException("식이 틀렸습니다.");
        }

        if (expression.split(REGEX).length != 2) {
            throw new IllegalArgumentException("좌표는 두개 만 들어가야 합니다.");
        }

        List<Coordinate> coordinateList = Arrays.asList(
            new Coordinate(expression.split(REGEX)[0]),
            new Coordinate(expression.split(REGEX)[1])
        );

        this.coordinates = coordinateList;
    }

    @Override
    public double getResult() {
        return getDistance(coordinates);
    }

    @Override
    public List<Coordinate> findCoordinates() {
        return new ArrayList<>(coordinates);
    }

    public double getDistance(List<Coordinate> coordinates) {
        Coordinate coordinate = coordinates.get(0);
        Coordinate otherCoordinate = coordinates.get(1);

        return Math.sqrt(
            abs((coordinate.getX() - otherCoordinate.getX()) * (coordinate.getX() - otherCoordinate.getX())
                + (coordinate.getY() - otherCoordinate.getY()) * (coordinate.getY() - otherCoordinate.getY())));
    }
}
