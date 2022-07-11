package coordinate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StringExpressionTest {

    private static final String 입력값 = "(10,10)-(14,15)";

    @Test
    @DisplayName("식을 입력받는다.")
    void test1() {
        //when & then
        assertDoesNotThrow(
            () -> new StringExpression(입력값)
        );
    }

    @Test
    @DisplayName("식은 괄호\"(\", \")\"로 둘러쌓여 있으며 쉼표(,)로 좌표를 구분한다.")
    void test2() {
        //given
        String stringExpression = 입력값;

        //when & then
        assertDoesNotThrow(
            () -> new StringExpression(stringExpression)
        );
    }

    @Test
    @DisplayName("식이 포멧에 맞지 않으면 예외가 발생한다.")
    void test3() {
        //given
        String 실패되는_입력_값 = "10, 12";

        //when & then
        assertThatThrownBy(
            () -> new StringExpression(실패되는_입력_값)
        ).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("식에서 좌표 두 개를 추출한다.")
    void test4() {
        // given
        String stringExpression = 입력값;

        // when
        StringExpression expression = new StringExpression(stringExpression);

        // then
        assertThat(expression.getFirstCoordinate()).isNotNull();
        assertThat(expression.getSecondCoordinate()).isNotNull();
    }
}
