package tdd.apr.nameinverter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NameInverterTest {
    private NameInverter nameInverter = null;

    @BeforeEach
    public void setUp() {
        nameInverter = new NameInverter();
    }

    @Test
    public void shouldReturnForenameOrSurname_whenOnlyGivenForenameOrSurname() {
        String surname = "Smith";

        String expectedInversion = "Smith";
        String actualInversion = nameInverter.invert(surname);
        assertEquals(expectedInversion, actualInversion);
    }

    @Test
    public void shouldReturnNameWithoutWhiteSpace_whenGivenNameWithWhiteSpace() {
        String surname = " Smith ";

        String expectedInversion = "Smith";
        String actualInversion = nameInverter.invert(surname);
        assertEquals(expectedInversion, actualInversion);
    }

    @Test
    public void shouldReturnInvertedName_whenGivenForenameAndSurname() {
        String name = "John Smith";

        String expectedInversion = "Smith, John";
        String actualInversion = nameInverter.invert(name);
        assertEquals(expectedInversion, actualInversion);
    }

    @Test
    public void shouldReturnInvertedName_whenGivenForenameAndSurnameHasExtraWhitespaceBetweenThem() {
        String name = "John  Smith";

        String expectedInversion = "Smith, John";
        String actualInversion = nameInverter.invert(name);
        assertEquals(expectedInversion, actualInversion);
    }

    @Test
    public void shouldReturnInvertedNameWithoutHonorific_whenGivenNameWithHonorific() {
        String name = "Mr. John Smith";

        String expectedInversion = "Smith, John";
        String actualInversion = nameInverter.invert(name);
        assertEquals(expectedInversion, actualInversion);
    }

    @Test
    public void shouldReturnInvertedName_whenGivenNameWithPostnominal() {
        String name = "John Smith PhD.";

        String expectedInversion = "Smith, John PhD.";
        String actualInversion = nameInverter.invert(name);
        assertEquals(expectedInversion, actualInversion);
    }

    @Test
    public void shouldReturnInvertedName_whenGivenNameWithPostnominals() {
        String name = "John Smith Sr. PhD.";

        String expectedInversion = "Smith, John Sr. PhD.";
        String actualInversion = nameInverter.invert(name);
        assertEquals(expectedInversion, actualInversion);
    }
}