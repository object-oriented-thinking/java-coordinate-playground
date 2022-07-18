package coordinate;

import coordinate.domain.Coordinate;
import coordinate.domain.CoordinateGraphClient;
import coordinate.domain.CoordinateInputClient;

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

//        LineCalculator lineCalculator = new LineCalculator(coordinateGraphClient, coordinateInputClient);

        //input
//        Line expression = lineCalculator.input();

        //display
//        lineCalculator.display(expression);

        //calculate
//        double value = lineCalculator.calculate(expression);
//        System.out.println(value);
    }
}
