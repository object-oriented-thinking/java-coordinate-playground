package coordinate.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Rectangle implements Shapes {
    public static final String REGEX = "-";
    private final List<Coordinate> coordinates;

    public Rectangle(String expression) {

        if (!expression.contains(REGEX)) {
            throw new IllegalArgumentException("식이 틀렸습니다.");
        }

        if (expression.split(REGEX).length != 4) {
            throw new IllegalArgumentException("좌표는 두개 만 들어가야 합니다.");
        }

        List<Coordinate> coordinateList = Arrays.asList(
            new Coordinate(expression.split(REGEX)[0]),
            new Coordinate(expression.split(REGEX)[1]),
            new Coordinate(expression.split(REGEX)[2]),
            new Coordinate(expression.split(REGEX)[3])
        );

        if (coordinateList.stream().map(Coordinate::getX).distinct().count() != 2) {
            throw new IllegalArgumentException();
        }

        if (coordinateList.stream().map(Coordinate::getY).distinct().count() != 2) {
            throw new IllegalArgumentException();
        }

        this.coordinates = coordinateList;

    }

    @Override
    public double getResult() {
        return getArea(coordinates);
    }

    private double getArea(List<Coordinate> coordinates) {
        Double rangeX = getRange(coordinates.stream().map(Coordinate::getX));
        Double rangeY = getRange(coordinates.stream().map(Coordinate::getY));
        return rangeX * rangeY;
    }

    private Double getRange(Stream<Double> stream) {
        return stream.distinct().reduce((aDouble, aDouble2) -> Math.abs(aDouble - aDouble2))
            .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<Coordinate> findCoordinates() {
        return new ArrayList<>(coordinates);
    }

}
