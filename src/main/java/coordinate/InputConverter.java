package coordinate;

import java.util.regex.Pattern;

public class InputConverter {
    private static final Pattern COORDINATE_PATTERN = Pattern.compile("^\\([0-9][0-9]?+,+[0-9][0-9]?\\)+|^\\([0-9][0-9]?+,+[0-9][0-9]?\\)+-+\\([0-9][0-9]?+,[0-9][0-9]?\\)$");
    private final String inputCoordinate;

    public InputConverter(String inputCoordinate) {
        if (isNotMatchPattern(inputCoordinate)) {
            throw new IllegalArgumentException("좌표형식을 확인해주세요");
        }
        this.inputCoordinate = deleteParentheses(inputCoordinate);
        validateCoordinateRange();
    }

    public void something() {
        CoordinateFactory factory = new CoordinateFactory();
        factory.checkStraight(this.inputCoordinate);
    }

    private boolean isNotMatchPattern(String inputCoordinate) {
        return !COORDINATE_PATTERN.matcher(inputCoordinate).matches();
    }

    private void validateCoordinateRange() {
        String[] tempLine;
        if (this.inputCoordinate.contains("-")) {
            tempLine = this.inputCoordinate.replace("-", ",").split(",");
            checkRangeLoop(tempLine);
            return;
        }
        tempLine = this.inputCoordinate.split(",");
        checkRangeLoop(tempLine);
    }

    private void checkRangeLoop(String[] tempLine) {
        for (String input : tempLine) {
            checkMaxRange(input);
        }
    }

    private void checkMaxRange(String input) {
        if (isOverThanMaxRange(input)) {
            throw new IllegalArgumentException("좌표는 24까지만 입력할수있습니다");
        }
    }

    private boolean isOverThanMaxRange(String tempLine) {
        return Integer.parseInt(tempLine) > 24;
    }

    private String deleteParentheses(String inputCoordinate) {
        return inputCoordinate.replaceAll("[^0-9,-]*", "");
    }
}
