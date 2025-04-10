package tdd.apr.multibasestringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MultiBaseStringCalculatorTest {
    private MultiBaseStringCalculator multiBaseStringCalculator = null;

    @BeforeEach
    public void setUp() {
        multiBaseStringCalculator = new MultiBaseStringCalculator();
    }

    @Test
    public void shouldReturnTwo_forOnePlusOne_inBaseHigherThanTwo() {
        int base = 3;
        String addend = "1";
        String otherAddend = "1";

        String expectedSum = "2";
        String actualSum = multiBaseStringCalculator.add(base, addend, otherAddend);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void shouldReturnThree_forOnePlusTwo_inBaseHigherThanThree() {
        int base = 4;
        String addend = "1";
        String otherAddend = "2";

        String expectedSum = "3";
        String actualSum = multiBaseStringCalculator.add(base, addend, otherAddend);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void shouldReturnOneZero_forOnePlusOne_inBaseTwo() {
        int base = 2;
        String addend = "1";
        String otherAddend = "1";

        String expectedSum = "10";
        String actualSum = multiBaseStringCalculator.add(base, addend, otherAddend);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void shouldReturnOneZeroZero_forOneZeroPlusOneZero_inBaseTwo() {
        int base = 2;
        String addend = "10";
        String otherAddend = "10";

        String expectedSum = "100";
        String actualSum = multiBaseStringCalculator.add(base, addend, otherAddend);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void shouldReturnA_forOnePlusNine_inBaseEleven() {
        int base = 11;
        String addend = "1";
        String otherAddend = "9";

        String expectedSum = "A";
        String actualSum = multiBaseStringCalculator.add(base, addend, otherAddend);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void shouldReturnF_forSixPlusNine_inBaseSixTeen() {
        int base = 16;
        String addend = "6";
        String otherAddend = "9";

        String expectedSum = "F";
        String actualSum = multiBaseStringCalculator.add(base, addend, otherAddend);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void shouldReturnB_forOnePlusA_inBaseTwelve() {
        int base = 12;
        String addend = "1";
        String otherAddend = "A";

        String expectedSum = "B";
        String actualSum = multiBaseStringCalculator.add(base, addend, otherAddend);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void shouldReturn9_forAMinusOne_inBaseEleven() {
        int base = 11;
        String minuend = "A";
        String subtrahend = "1";

        String expectedSum = "9";
        String actualSum = multiBaseStringCalculator.subtract(base, minuend, subtrahend);
        assertEquals(expectedSum, actualSum);
    }
}