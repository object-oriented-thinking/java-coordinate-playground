package coordinate;

public class Line extends AbstractFigure{
    public static final int LINE_POINT_SIZE = 2;

    public Line(Points points) {
        super(points);
    }

    @Override
    public int size() {
        return LINE_POINT_SIZE;
    }

    @Override
    public String getName() {
        return "선";
    }

    @Override
    public double area() {
        return getPoint(0).getDistance(getPoint(1));
    }

    @Override
    public String output(){
        return String.format("두 점 사이의 거리는 %f", area());
    }
}
