package coordinate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CoordinateTest {

    @Test
    @DisplayName("x, y 값을 입력해 좌표를 생성한다.")
    void test1() {
        //when & then
        assertDoesNotThrow(
            () -> new Coordinate("1", "4")
        );
    }

    @Test
    @DisplayName("좌표는 음수이면 IllegalArgumentException 예외가 발생한다.")
    void test2() {
        // given
        String x = "-1";
        String y = "1";

        //when & then
        Assertions.assertThatThrownBy(
            () -> new Coordinate(x, y)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("좌표는 25이상이면 IllegalArgumentException 예외가 발생한다.")
    void test3() {
        // given
        String x = "25";
        String y = "1";

        //when & then
        Assertions.assertThatThrownBy(
            () -> new Coordinate(x, y)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("좌표에 입력 값에 숫자가 아닌 문자가 들어가면 IllegalArgumentException 예외가 발생한다.")
    void test4() {
        // given
        String x = "test";
        String y = "1";

        //when & then
        Assertions.assertThatThrownBy(
            () -> new Coordinate(x, y)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    private static final String 입력값 = "(10,10)-(14,15)";

    @Test
    @DisplayName("자신의 위치와 입력받는 위치의 직선 상의 거리를 계산한다.")
    void test5() {
        //given
        Coordinate 자신 = new Coordinate("10", "10");
        Coordinate 입력값 = new Coordinate("14", "15");

        //when & then
        assertEquals(3.0, 자신.getDistance(입력값), 0.1);
    }
}
