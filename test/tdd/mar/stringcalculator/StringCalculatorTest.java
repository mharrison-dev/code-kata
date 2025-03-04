package tdd.mar.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private StringCalculator stringCalculator = null;

    @BeforeEach
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void shouldReturnZeroWhenGivenAnEmptyString() {
        String emptyString = "";

        int expectedSum = 0;
        int actualSum = stringCalculator.add(emptyString);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void shouldReturnGivenNumberWhenGivenStringWithOnlyOneNumber() {
        String numberString = "10";

        int expectedSum = 10;
        int actualSum = stringCalculator.add(numberString);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void shouldReturnSumOfTwoNumbers() {
        String numberString = "5, 2";

        int expectedSum = 5 + 2;
        int actualSum = stringCalculator.add(numberString);
        assertEquals(expectedSum, actualSum);
    }
}