package coordinate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CoordinateTest {

    @Test
    @DisplayName("좌표를 입력받아 좌표를 생성합니다.")
    void test() {
        String 좌표 = "(10,10)";
        assertDoesNotThrow(
            () -> new Coordinate(좌표)
        );
    }

    @Test
    @DisplayName("입력되는 식은 정규 표현식에 맞지 않으면 IllegalArgumentException 예외가 발생합니다.")
    void test1() {
        String 좌표 = "(1010)";
        assertThatThrownBy(
            () -> new Coordinate(좌표)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("식 내의 좌표에 숫자가 들어가지 않으면 IllegalArgumentException  예외가 발생합니다.")
    void test2() {
        String 좌표 = "(10,string)";
        assertThatThrownBy(
            () -> new Coordinate(좌표)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("0 미만의 숫자가 들어가면 예외가 발생합니다.")
    @ValueSource(strings = {"(-1,-5)", "(5,-1)"})
    void test3(String 좌표) {
        assertThatThrownBy(
            () -> new Coordinate(좌표)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("24 이상의 숫자가 들어가면 예외가 발생합니다.")
    @ValueSource(strings = {"(5,25)", "(25,3)"})
    void test4(String 좌표) {
        assertThatThrownBy(
            () -> new Coordinate(좌표)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
