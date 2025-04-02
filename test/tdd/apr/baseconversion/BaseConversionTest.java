package tdd.apr.baseconversion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BaseConversionTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "1"})
    public void shouldReturnSameValue_whenConvertingBetweenSameBase(String value) {
        BaseConversion baseConversion = new BaseConversion();
        int initialBase = 10;
        int finalBase = 10;

        String expectedValue = value;
        String actualValue = baseConversion.convert(value, initialBase, finalBase);
        assertEquals(expectedValue, actualValue);
    }

    @ParameterizedTest()
    @ValueSource(strings = {"2,2", "B,10"})
    public void shouldThrowException_whenValueExceedsRangeOfInitialBase(String valueAndInitialBase) {
        BaseConversion baseConversion = new BaseConversion();
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
}