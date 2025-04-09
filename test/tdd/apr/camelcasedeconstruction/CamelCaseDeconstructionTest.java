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
}