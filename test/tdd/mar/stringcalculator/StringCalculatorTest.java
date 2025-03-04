package tdd.mar.stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    @Test
    public void shouldReturnZeroWhenGivenAnEmptyString() {
        String emptyString = "";
        StringCalculator stringCalculator = new StringCalculator();

        int expectedSum = 0;
        int actualSum = stringCalculator.add(emptyString);
        assertEquals(expectedSum, actualSum);
    }
}