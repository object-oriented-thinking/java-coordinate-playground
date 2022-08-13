package coordinate;

import java.util.ArrayList;
import java.util.List;

public class Points {
    private static final List<Point> points = new ArrayList<>();

    public void addPoint(Point point) {
        points.add(point);
    }

    public Point get(int index) {
        return points.get(index);
    }

    public int size(){
        return points.size();
    }
}
