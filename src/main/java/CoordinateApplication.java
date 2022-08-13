import coordinate.Figure;
import coordinate.FigureFactory;
import coordinate.Points;
import view.InputView;
import view.OutputView;

public class CoordinateApplication {
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();
    private final static FigureFactory figureFactory = new FigureFactory();

    public static void main(String[] args) {
        Points points = inputView.inputPoint();
        Figure figure = figureFactory.getInstance(points);
        outputView.output(figure);
    }
}
