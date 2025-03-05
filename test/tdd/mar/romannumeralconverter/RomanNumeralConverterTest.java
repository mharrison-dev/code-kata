package tdd.mar.romannumeralconverter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralConverterTest {
    private RomanNumeralConverter romanNumeralConverter = null;

    @BeforeEach
    public void setUp() {
        romanNumeralConverter = new RomanNumeralConverter();
    }

    @Test
    public void shouldReturnIWhenGivenOne() {
        String expectedRomanNumeral = "I";
        String actualRomanNumeral = romanNumeralConverter.convertToRomanNumeral(1);
        assertEquals(expectedRomanNumeral, actualRomanNumeral);
    }

    @Test
    public void shouldReturnIIIWhenGivenThree() {
        String expectedRomanNumeral = "III";
        String actualRomanNumeral = romanNumeralConverter.convertToRomanNumeral(3);
        assertEquals(expectedRomanNumeral, actualRomanNumeral);
    }

    @Test
    public void shouldReturnIVWhenGivenFour() {
        String expectedRomanNumeral = "IV";
        String actualRomanNumeral = romanNumeralConverter.convertToRomanNumeral(4);
        assertEquals(expectedRomanNumeral, actualRomanNumeral);
    }

    @Test
    public void shouldReturnVWhenGivenFive() {
        String expectedRomanNumeral = "V";
        String actualRomanNumeral = romanNumeralConverter.convertToRomanNumeral(5);
        assertEquals(expectedRomanNumeral, actualRomanNumeral);
    }

    @Test
    public void shouldReturnVIWhenGivenSix() {
        String expectedRomanNumeral = "VI";
        String actualRomanNumeral = romanNumeralConverter.convertToRomanNumeral(6);
        assertEquals(expectedRomanNumeral, actualRomanNumeral);
    }

    @Test
    public void shouldReturnIXWhenGivenNine() {
        String expectedRomanNumeral = "IX";
        String actualRomanNumeral = romanNumeralConverter.convertToRomanNumeral(9);
        assertEquals(expectedRomanNumeral, actualRomanNumeral);
    }

    @Test
    public void shouldReturnXWhenGivenTen() {
        String expectedRomanNumeral = "X";
        String actualRomanNumeral = romanNumeralConverter.convertToRomanNumeral(10);
        assertEquals(expectedRomanNumeral, actualRomanNumeral);
    }
}