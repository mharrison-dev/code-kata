package tdd.apr.camelcasedeconstruction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CamelCaseDeconstructionTest {
    @Test
    void shouldReturnEmptyString_whenGivenEmptyString() {
        String emptyString = "";
        CamelCaseDeconstruction camelCaseDeconstruction = new CamelCaseDeconstruction();

        String expectedString = "";
        String actualString = camelCaseDeconstruction.deconstruct(emptyString);
        assertEquals(expectedString, actualString);
    }

    @Test
    void shouldReturnSameString_whenGivenLowercasedString() {
        String lowercasedString = "butter";
        CamelCaseDeconstruction camelCaseDeconstruction = new CamelCaseDeconstruction();

        String expectedString = "butter";
        String actualString = camelCaseDeconstruction.deconstruct(lowercasedString);
        assertEquals(expectedString, actualString);
    }

    @Test
    void shouldReturnStringWithTwoWordsThatAreSeparatedByOneSpace_whenGivenCamelCasedString() {
        String camelCasedString = "saltedButter";
        CamelCaseDeconstruction camelCaseDeconstruction = new CamelCaseDeconstruction();

        String actualString = camelCaseDeconstruction.deconstruct(camelCasedString);
        assertTrue(actualString.matches("^\\w+ \\w+$"), "Expected '" + actualString + "' to have a space between each word");
    }
}