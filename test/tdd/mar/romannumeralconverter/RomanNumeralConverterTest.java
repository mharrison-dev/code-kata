package tdd.mar.romannumeralconverter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralConverterTest {
    @Test
    public void shouldReturnIWhenGivenOne() {
        RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter();

        String expectedRomanNumeral = "I";
        String actualRomanNumeral = romanNumeralConverter.convertToRomanNumeral(1);
        assertEquals(expectedRomanNumeral, actualRomanNumeral);
    }

    @Test
    public void shouldReturnIIIWhenGivenThree() {
        RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter();

        String expectedRomanNumeral = "III";
        String actualRomanNumeral = romanNumeralConverter.convertToRomanNumeral(3);
        assertEquals(expectedRomanNumeral, actualRomanNumeral);
    }
}