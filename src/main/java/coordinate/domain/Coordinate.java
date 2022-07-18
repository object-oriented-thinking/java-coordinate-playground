package coordinate.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coordinate {
    private final double x;
    private final double y;

    private static final String X = "x";
    private static final String Y = "y";

    private final static Pattern PATTERN = Pattern
        .compile("\\((?<" + X + ">\\d+),(?<" + Y + ">\\d+)\\)");


    public Coordinate(String expression) {
        Matcher matcher = PATTERN.matcher(expression);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }

        String stringX = matcher.group(X);
        String stringY = matcher.group(Y);

        isNumber(stringX);
        isNumber(stringY);

        if (validationNumber(stringX)) {
            throw new IllegalArgumentException();
        }
        if (validationNumber(stringY)) {
            throw new IllegalArgumentException();
        }

        x = Double.parseDouble(stringX);
        y = Double.parseDouble(stringY);

    }

    private boolean validationNumber(String number) {
        return 1.0 > Double.parseDouble(number) || Double.parseDouble(number) > 24.0;
    }

    private void isNumber(String stringX) {
        try {
            Double.parseDouble(stringX);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
