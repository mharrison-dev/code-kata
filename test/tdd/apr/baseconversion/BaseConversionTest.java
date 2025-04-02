package tdd.apr.baseconversion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BaseConversionTest {
    private BaseConversion baseConversion = null;

    @BeforeEach
    public void setUp() {
        baseConversion = new BaseConversion();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1"})
    public void shouldReturnSameValue_whenConvertingBetweenSameBase(String value) {
        int initialBase = 10;
        int finalBase = 10;

        String expectedValue = value;
        String actualValue = baseConversion.convert(value, initialBase, finalBase);
        assertEquals(expectedValue, actualValue);
    }

    @ParameterizedTest()
    @ValueSource(strings = {"2,2", "B,10"})
    public void shouldThrowException_whenValueExceedsRangeOfInitialBase(String valueAndInitialBase) {
        String value = valueAndInitialBase.split(",")[0];
        int initialBase = Integer.parseInt(valueAndInitialBase.split(",")[1]);
        int finalBase = 10;

        String expectedExceptionMessage = "Cannot convert value(" + value + ") because it exceeds the range of the initial base(" + initialBase + ").";
        Exception actualException = assertThrows(
                IllegalArgumentException.class,
                () -> baseConversion.convert(value, initialBase, finalBase)
        );
        assertEquals(expectedExceptionMessage, actualException.getMessage());
    }

    @ParameterizedTest()
    @ValueSource(strings = {"!", "&"})
    public void shouldThrowException_whenValueContainsIllegalCharacters(String value) {
        int initialBase = 10;
        int finalBase = 10;

        String expectedExceptionMessage = "Values can only have characters from the character sets 0-9 or A-Z.";
        Exception actualException = assertThrows(
                IllegalArgumentException.class,
                () -> baseConversion.convert(value, initialBase, finalBase)
        );
        assertEquals(expectedExceptionMessage, actualException.getMessage());
    }

    @Test
    public void shouldThrowException_whenValueIsNull() {
        String value = null;
        int initialBase = 10;
        int finalBase = 10;

        String expectedExceptionMessage = "Value cannot be null";
        Exception actualException = assertThrows(
                IllegalArgumentException.class,
                () -> baseConversion.convert(value, initialBase, finalBase)
        );
        assertEquals(expectedExceptionMessage, actualException.getMessage());
    }

    @Test
    public void shouldThrowException_whenValueIsEmpty() {
        String value = "";
        int initialBase = 10;
        int finalBase = 10;

        String expectedExceptionMessage = "Value cannot be empty";
        Exception actualException = assertThrows(
                IllegalArgumentException.class,
                () -> baseConversion.convert(value, initialBase, finalBase)
        );
        assertEquals(expectedExceptionMessage, actualException.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    public void shouldThrowException_whenInitialBaseIsSmallerThanTwo(int initialBase) {
        String value = "0";
        int finalBase = 10;

        String expectedExceptionMessage = "Initial base cannot be smaller than two.";
        Exception actualException = assertThrows(
                IllegalArgumentException.class,
                () -> baseConversion.convert(value, initialBase, finalBase)
        );
        assertEquals(expectedExceptionMessage, actualException.getMessage());
    }
}