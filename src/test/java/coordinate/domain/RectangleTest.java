package coordinate.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    @DisplayName("좌표 네 개를 가지고 있습니다.")
    void test1() {
        // given
        String 식 = "(10,10)-(22,10)-(22,18)-(10,18)";

        // when & then
        assertDoesNotThrow(
            () -> new Rectangle(식)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"(10,10)-(22,10)-(22,18)-(10,1)", "(10,10)-(22,10)-(22,18)-(1,18)"})
    @DisplayName("네 점이 뒤틀어진 사다리꼴이나 마름모가 입력이 되면 IllegalArgumentException 예외가 발생합니다.")
    void test2(String 식) {
        // when & then
        assertThatThrownBy(
            () -> new Rectangle(식)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("넓이를 계산합니다.")
    void test5() {
        // given
        String 식 = "(10,10)-(22,10)-(22,18)-(10,18)";
        Rectangle 직사각형 = new Rectangle(식);
        double 넓이 = 직사각형.getResult();

        // when & then
        assertThat(넓이).isEqualTo(96.0);
    }

    @Test
    @DisplayName("좌표를 출력합니다.")
    void test6() {
        // given
        String 식 = "(10,10)-(22,10)-(22,18)-(10,18)";
        Rectangle 직사각형 = new Rectangle(식);

        assertThat(직사각형.findCoordinates()).hasSize(4);
    }
}
