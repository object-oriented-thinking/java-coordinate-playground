package coordinate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    @ParameterizedTest
    @ValueSource(strings = {"(a,b)-(c,d)", "", " ", "가나다라", "가,나,다,라", "a", "10,10-20,40", "(10,30)-", "!@#$", "!,@,#,$", "(ㄱ,ㄴ)-(ㄷ,ㄹ)"})
    @DisplayName("좌표입력 패턴 실패테스트")
    void testCoordinatePattern_False(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            new InputConverter(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"(1,2)-(3,4)", "(10,20)", "(1,2)"})
    @DisplayName("좌표입력 패턴 성공테스트")
    void testCoordinatePattern_Success(String input) {
        assertDoesNotThrow(() -> new InputConverter(input));
    }


    @ParameterizedTest
    @ValueSource(strings = {"(-1,-2)","(25,26)", "(100,200)-(300,400)"})
    @DisplayName("좌표 범위 실패테스트")
    void test(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            new InputConverter(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"(10,20)", "(24,24)-(1,2)"})
    @DisplayName("좌표 범위 성공테스트")
    void test2(String input) {
        assertDoesNotThrow(() -> new InputConverter(input));
    }

    @Test
    @DisplayName("제곱근 값 테스트")
    void test3() {
        String[] split = "10,20-3,9".replace("-", ",").split(",");
        Straight straight = new Straight(split);
        assertThat(straight.getSqrt()).isEqualTo(13.0384, offset(0.0001));
    }
}