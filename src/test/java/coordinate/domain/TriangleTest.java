package coordinate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class TriangleTest {

    @Test
    @DisplayName("삼각형을 그릴 수 있습니다.")
    void test() {
        String 식 = "(10,10)-(14,15)-(20,8)";
        assertDoesNotThrow(
            () -> new Triangle(식)
        );
    }

    @Test
    @DisplayName("식이 틀리면 예외가 발생합니다.")
    void test1() {
        String 식 = "(10,10)(14,15)-(20,8)";
        assertThatThrownBy(
            () -> new Triangle(식)
        ).isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @ValueSource(strings = {"(14,15)-(20,8)", "(14,15)-(20,8)-(20,15)-(14,8)"})
    @DisplayName("좌표가 세개 이외의 값이 들어오면 예외가 발생합니다.")
    void test2(String 식) {
        assertThatThrownBy(
            () -> new Triangle(식)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("답인 삼각형의 넓이를 출력합니다.")
    void test3() {
        String 식 = "(10,10)-(14,15)-(20,8)";
        Triangle 삼각형 = new Triangle(식);
        assertThat(삼각형.getResult()).isEqualTo(29.0, offset(0.00099));
    }

    @Test
    @DisplayName("좌표를 그리기 위해 좌표들을 출력합니다.")
    void test4() {
        String 식 = "(10,10)-(14,15)-(20,8)";
        Triangle 삼각형 = new Triangle(식);
        assertThat(삼각형.findCoordinates()).hasSize(3);
    }
}
