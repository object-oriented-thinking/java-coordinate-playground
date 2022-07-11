package coordinate;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringExpression {
    private static final String X_1 = "x1";
    private static final String Y_1 = "y1";
    private static final String X_2 = "x2";
    private static final String Y_2 = "y2";
    private final static Pattern PATTERN = Pattern
        .compile("\\((?<" + X_1 + ">\\d+),(?<" + Y_1 + ">\\d+)\\)-\\((?<" + X_2 + ">\\d+),(?<" + Y_2 + ">\\d+)\\)");
    private final Coordinate firstCoordinate;
    private final Coordinate secondCoordinate;

    public StringExpression(String expression) {
        Matcher matcher = PATTERN.matcher(expression);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
        firstCoordinate = getCoordinate(matcher, X_1, Y_1);
        secondCoordinate = getCoordinate(matcher, X_2, Y_2);
    }

    public Coordinate getFirstCoordinate() {
        return firstCoordinate;
    }

    public Coordinate getSecondCoordinate() {
        return secondCoordinate;
    }

    @NotNull
    private Coordinate getCoordinate(Matcher matcher, String x1, String y1) {
        return new Coordinate(matcher.group(x1), matcher.group(y1));
    }
}
