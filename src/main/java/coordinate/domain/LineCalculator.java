package coordinate.domain;

public class LineCalculator {

    private final CoordinateGraphClient coordinateGraphClient;
    private final CoordinateInputClient coordinateInputClient;

    public LineCalculator(CoordinateGraphClient coordinateGraphClient, CoordinateInputClient coordinateInputClient) {
        this.coordinateGraphClient = coordinateGraphClient;
        this.coordinateInputClient = coordinateInputClient;
    }

    public StringExpression input() {
        String stringExpression = coordinateInputClient.inputString();
        return new StringExpression(stringExpression);
    }

    public double calculate(StringExpression expression) {
        return expression.getDistance();
    }

    public boolean display(StringExpression expression) {
        return coordinateGraphClient.displayGraph(expression.getFirstCoordinate(), expression.getSecondCoordinate());
    }
}
