package tdd.apr.multibasestringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MultiBaseStringCalculatorTest {
    @Test
    public void shouldReturnTwo_forOnePlusOne_inBaseHigherThanTwo() {
        MultiBaseStringCalculator multiBaseStringCalculator = new MultiBaseStringCalculator();
        int base = 3;
        String addend = "1";
        String otherAddend = "1";

        String expectedSum = "2";
        String actualSum = multiBaseStringCalculator.add(base, addend, otherAddend);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void shouldReturnThree_forOnePlusTwo_inBaseHigherThanThree() {
        MultiBaseStringCalculator multiBaseStringCalculator = new MultiBaseStringCalculator();
        int base = 4;
        String addend = "1";
        String otherAddend = "2";

        String expectedSum = "3";
        String actualSum = multiBaseStringCalculator.add(base, addend, otherAddend);
        assertEquals(expectedSum, actualSum);
    }
}