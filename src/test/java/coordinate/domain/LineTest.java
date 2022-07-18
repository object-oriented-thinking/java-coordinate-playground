package coordinate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @Test
    @DisplayName("좌표 두 개를 가지고 있습니다.")
    void test1() {
        // given
        String 좌표_두개 = "(10,10)-(14,15)";
        Line 선 = new Line(좌표_두개);

        // when & then
        assertThat(선.findCoordinates()).hasSize(2);
    }

    @Test
    @DisplayName("답을 출력합니다.")
    void test2() {
        // given
        String 좌표_두개 = "(10,10)-(14,15)";
        Line 선 = new Line(좌표_두개);

        // when & then
        assertThat(선.getResult()).isExactlyInstanceOf(Double.class);
    }

    @Test
    @DisplayName("답은 길이입니다.")
    void test3() {
        // given
        String 좌표_두개 = "(10,10)-(10,15)";
        double 길이 = 5.0;
        Line 선 = new Line(좌표_두개);

        // when & then
        assertThat(선.getResult()).isEqualTo(길이);
    }

    @Test
    @DisplayName("- 로 나눠지는 좌표가 없으면 예외가 발생합니다.")
    void test4() {
        String 이상한_식 = "(10,10)(14,15)";
        assertThatThrownBy(
            () -> new Line(이상한_식)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("- 로 나눠지는 좌표가 세개 이상이면 예외가 발생합니다.")
    void test5() {
        String 이상한_식 = "(10,10)-(14,15)-(13,15)";
        assertThatThrownBy(
            () -> new Line(이상한_식)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
