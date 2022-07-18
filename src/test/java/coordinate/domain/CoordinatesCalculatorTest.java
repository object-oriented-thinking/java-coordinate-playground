package coordinate.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CoordinatesCalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"(10,10)-(14,15)", "(10,10)-(22,10)-(22,18)-(10,18)"})
    @DisplayName("입력을 받습니다.")
    void test1(String 식) {
        Assertions.assertDoesNotThrow(
            () -> new CoordinatesCalculator(식)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"(10,10)-(14,15)", "(10,10)-(22,10)-(22,18)-(10,18)"})
    @DisplayName("입력이 선 인지 직사각형인지 판단합니다.")
    void test2(String 식) {
        CoordinatesCalculator calculator = new CoordinatesCalculator(식);

        if (식.equals("(10,10)-(14,15)")) {
            assertThat(calculator.getShapes()).isInstanceOf(Line.class);
        }

        if (식.equals("(10,10)-(22,10)-(22,18)-(10,18)")) {
            assertThat(calculator.getShapes()).isInstanceOf(Rectangle.class);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"(10,10)-(10,15)", "(10,10)-(22,10)-(22,18)-(10,18)"})
    @DisplayName("답을 출력합니다.")
    void test3(String 식) {
        CoordinatesCalculator calculator = new CoordinatesCalculator(식);

        if (식.equals("(10,10)-(10,15)")) {
            assertThat(calculator.getResult()).isEqualTo(5.0);
        }

        if (식.equals("(10,10)-(22,10)-(22,18)-(10,18)")) {
            assertThat(calculator.getResult()).isEqualTo(96.0);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"(10,10)-(10,15)", "(10,10)-(22,10)-(22,18)-(10,18)"})
    @DisplayName("좌표를 출력합니다.")
    void test4(String 식) {
        CoordinatesCalculator calculator = new CoordinatesCalculator(식);

        if (식.equals("(10,10)-(14,15)")) {
            assertThat(calculator.findCoordinates()).hasSize(2);
        }

        if (식.equals("(10,10)-(22,10)-(22,18)-(10,18)")) {
            assertThat(calculator.findCoordinates()).hasSize(4);
        }
    }
}
