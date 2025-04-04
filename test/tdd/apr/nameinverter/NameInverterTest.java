package tdd.apr.nameinverter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NameInverterTest {
    @Test
    public void shouldReturnForenameOrSurname_whenOnlyGivenForenameOrSurname() {
        String surname = "Smith";
        NameInverter nameInverter = new NameInverter();

        String expectedInversion = "Smith";
        String actualInversion = nameInverter.invert(surname);
        assertEquals(expectedInversion, actualInversion);
    }

    @Test
    public void shouldReturnNameWithoutWhiteSpace_whenGivenNameWithWhiteSpace() {
        String surname = " Smith ";
        NameInverter nameInverter = new NameInverter();

        String expectedInversion = "Smith";
        String actualInversion = nameInverter.invert(surname);
        assertEquals(expectedInversion, actualInversion);
    }
}