package coordinate;

public class Straight implements Coordinate {
    private final double x1;
    private final double x2;
    private final double y1;
    private final double y2;
    private final double sqrt;

    public Straight(String[] split) {
        this.x1 = Double.parseDouble(split[0]);
        this.y1 = Double.parseDouble(split[1]);
        this.x2 = Double.parseDouble(split[2]);
        this.y2 = Double.parseDouble(split[3]);
        this.sqrt = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public double getSqrt() {
        return this.sqrt;
    }

    @Override
    public void printSpecialCharacter() {
        System.out.println("좌표는(" + this.x1 +"," + this.y1 + ")-(" + this.x2 + "," + this.y2 + ")입니다." );
        System.out.println("두점 사이의 거리는" + this.sqrt);
    }
}
