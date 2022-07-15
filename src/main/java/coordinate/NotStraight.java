package coordinate;

public class NotStraight implements Coordinate {
    private final double x1;
    private final double y1;

    public NotStraight(String[] split) {
        this.x1 = Double.parseDouble(split[0]);
        this.y1 = Double.parseDouble(split[1]);
    }

    @Override
    public void printSpecialCharacter() {
        System.out.println("좌표는(" + this.x1 +"," + this.y1 + ")입니다");
    }
}
