package tdd.mar.simplepiglatin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SimplePigLatinTest {
    @ParameterizedTest
    @ValueSource(strings = {",", ".", "(", ")", ":", "'", ";", "?", "!", "\"", "-", "{", "}", "...", "[", "]", "/"})
    public void shouldIgnorePunctuationMarks(String punctuationMark) {
        SimplePigLatin simplePigLatin = new SimplePigLatin();

        String expectedString = punctuationMark;
        String actualString = simplePigLatin.translate(punctuationMark);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldModifyWord() {
        SimplePigLatin simplePigLatin = new SimplePigLatin();

        String expectedString = "igpay";
        String actualString = simplePigLatin.translate("pig");
        assertEquals(expectedString, actualString);
    }
}