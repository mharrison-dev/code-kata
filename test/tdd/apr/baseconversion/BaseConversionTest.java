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
}