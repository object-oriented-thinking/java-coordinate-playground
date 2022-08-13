package coordinate;

public abstract class AbstractFigure implements Figure {
    private final Points points;

    protected final Point getPoint(int idx){
        return points.get(idx);
    }

    public AbstractFigure(Points points) {
        if (points.size() != size()) {
            throw new IllegalArgumentException(getName() + "의 길이는 " + size() + "이어야 합니다.");
        }

        this.points = points;
    }
}
