package coordinate;

public class CoordinateFactory {
    public void checkStraight(String inputCoordinate) {
        if (inputCoordinate.contains("-")) {
            String[] split = inputCoordinate.replace("-", ",").split(",");
            Coordinate coordinate = new Straight(split);
            coordinate.printSpecialCharacter();
            return;
        }
        String[] split = inputCoordinate.split(",");
        Coordinate coordinate = new NotStraight(split);
        coordinate.printSpecialCharacter();
    }
}
