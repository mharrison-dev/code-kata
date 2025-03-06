package tdd.mar.romannumeralcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralCalculatorTest {
    private RomanNumeralCalculator romanNumeralCalculator = null;

    @BeforeEach
    public void setUp() {
        romanNumeralCalculator = new RomanNumeralCalculator();
    }

    @Test
    public void addIAndIToGetII() {
        String expectedSum = "II";
        String actualSum = romanNumeralCalculator.add("I", "I");
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void addIAndIIToGetIII() {
        String expectedSum = "III";
        String actualSum = romanNumeralCalculator.add("I", "II");
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void addIIAndIIToGetIV() {
        String expectedSum = "IV";
        String actualSum = romanNumeralCalculator.add("II", "II");
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void addIIAndIIIToGetV() {
        String expectedSum = "V";
        String actualSum = romanNumeralCalculator.add("II", "III");
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void addVAndVToGetX() {
        String expectedSum = "X";
        String actualSum = romanNumeralCalculator.add("V", "V");
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void addVIAndVIToGetXII() {
        String expectedSum = "XII";
        String actualSum = romanNumeralCalculator.add("VI", "VI");
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void addXAndXToGetXX() {
        String expectedSum = "XX";
        String actualSum = romanNumeralCalculator.add("X", "X");
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void addXXAndXXToGetXL() {
        String expectedSum = "XL";
        String actualSum = romanNumeralCalculator.add("XX", "XX");
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void addXXAndXXXToGetL() {
        String expectedSum = "L";
        String actualSum = romanNumeralCalculator.add("XX", "XXX");
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void addLAndLToGetC() {
        String expectedSum = "C";
        String actualSum = romanNumeralCalculator.add("L", "L");
        assertEquals(expectedSum, actualSum);
    }
}