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

    @Test
    public void shouldReturnInvertedName_whenGivenForenameAndSurname() {
        String name = "John Smith";
        NameInverter nameInverter = new NameInverter();

        String expectedInversion = "Smith, John";
        String actualInversion = nameInverter.invert(name);
        assertEquals(expectedInversion, actualInversion);
    }

    @Test
    public void shouldReturnInvertedName_whenGivenForenameAndSurnameHasExtraWhitespaceBetweenThem() {
        String name = "John  Smith";
        NameInverter nameInverter = new NameInverter();

        String expectedInversion = "Smith, John";
        String actualInversion = nameInverter.invert(name);
        assertEquals(expectedInversion, actualInversion);
    }

    @Test
    public void shouldReturnInvertedNameWithoutHonorific_whenGivenNameWithHonorific() {
        String name = "Mr. John Smith";
        NameInverter nameInverter = new NameInverter();

        String expectedInversion = "Smith, John";
        String actualInversion = nameInverter.invert(name);
        assertEquals(expectedInversion, actualInversion);
    }
}