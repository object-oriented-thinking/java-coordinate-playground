package coordinate;

import coordinate.domain.LineCalculator;
import coordinate.domain.StringExpression;
import coordinate.infra.CoordinateGraphClient;
import coordinate.infra.CoordinateInputClient;

public class CoordinateMain {

    public static void main(String[] args) {
        coordinate.domain.CoordinateInputClient coordinateInputClient = new CoordinateInputClient();
        coordinate.domain.CoordinateGraphClient coordinateGraphClient = new CoordinateGraphClient();

        LineCalculator lineCalculator = new LineCalculator(coordinateGraphClient, coordinateInputClient);

        //input
        StringExpression expression = lineCalculator.input();

        //display
        lineCalculator.display(expression);

        //calculate
        double value = lineCalculator.calculate(expression);
        System.out.println(value);
    }
}
