package coordinate;

import coordinate.domain.Coordinate;
import coordinate.domain.CoordinateGraphClient;
import coordinate.domain.CoordinateInputClient;
import coordinate.domain.CoordinatesCalculator;

import java.util.List;

public class CoordinateMain {

    public static void main(String[] args) {
        coordinate.domain.CoordinateInputClient coordinateInputClient = new CoordinateInputClient() {
            @Override
            public String inputString() {
                return "(10,10)-(14,15)";
            }
        };
        coordinate.domain.CoordinateGraphClient coordinateGraphClient = new CoordinateGraphClient() {
            @Override
            public boolean displayGraph(List<Coordinate> coordinates) {
                return true;
            }
        };

        CoordinatesCalculator calculator = new CoordinatesCalculator(coordinateInputClient.inputString());

        // display
        coordinateGraphClient.displayGraph(calculator.findCoordinates());

        // print result
        System.out.println("답은 " + calculator.getResult() + "입니다.");
    }
}
