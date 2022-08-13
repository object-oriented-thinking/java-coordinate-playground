package coordinate;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends AbstractFigure {
    public static final int TRIANGLE_POINT_SIZE = 3;

    public Triangle(Points points) {
        super(points);
    }

    @Override
    public int size() {
        return TRIANGLE_POINT_SIZE;
    }

    @Override
    public String getName() {
        return "삼각형";
    }

    @Override
    public double area() {
        List<Double> distances = new ArrayList<>();
        distances.add(getPoint(0).getDistance(getPoint(1)));
        distances.add(getPoint(1).getDistance(getPoint(2)));
        distances.add(getPoint(2).getDistance(getPoint(0)));

        Double s = distances.stream().mapToDouble(i->i).reduce(Double::sum).getAsDouble() / 2;

        Double result = distances.stream().reduce(s, (a, b) -> a*(s-b));

        return Math.sqrt(result);
    }

    @Override
    public String output() {
        return String.format("삼각형 넓이는 %f", area());
    }
}
