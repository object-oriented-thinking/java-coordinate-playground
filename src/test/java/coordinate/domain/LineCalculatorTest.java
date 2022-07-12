package coordinate.domain;

import coordinate.fake.FakeCoordinateGraphClient;
import coordinate.fake.FakeCoordinateInputClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LineCalculatorTest {

    private FakeCoordinateGraphClient fakeCoordinateGraphClient = new FakeCoordinateGraphClient();
    private FakeCoordinateInputClient fakeCoordinateInputClient = new FakeCoordinateInputClient();
    private LineCalculator lineCalculator;

    @BeforeEach
    void setUp() {
        lineCalculator = new LineCalculator(fakeCoordinateGraphClient, fakeCoordinateInputClient);
    }

    @Test
    @DisplayName("좌표 두 개를 표에 찍는다.")
    void test6() {
        //given
        StringExpression expression = lineCalculator.input();
        
        //when
        boolean isDisplayed = lineCalculator.display(expression);

        //then
        assertTrue(isDisplayed);
    }

    @Test
    @DisplayName("좌 표 두 개의 직선상의 거리를 계산한다.")
    void test8() {
        //given
        StringExpression expression = lineCalculator.input();
        double expected = 3.0;

        //when
        double actual = lineCalculator.calculate(expression);

        //then
        assertEquals(expected, actual, 0.1);
    }

}
