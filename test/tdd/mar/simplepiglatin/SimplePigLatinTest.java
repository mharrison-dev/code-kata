package tdd.mar.simplepiglatin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SimplePigLatinTest {
    private SimplePigLatin simplePigLatin = null;

    @BeforeEach
    public void setUp() {
        simplePigLatin = new SimplePigLatin();
    }

    @ParameterizedTest
    @ValueSource(strings = {",", ".", "(", ")", ":", "'", ";", "?", "!", "\"", "-", "{", "}", "...", "[", "]", "/"})
    public void shouldIgnorePunctuationMarks(String punctuationMark) {
        String expectedString = punctuationMark;
        String actualString = simplePigLatin.translate(punctuationMark);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldModifyWord() {
        String expectedString = "igpay";
        String actualString = simplePigLatin.translate("pig");
        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldModifyWordAndLeaveAttachedPunctuationInPlace() {
        String expectedString = "igpay!";
        String actualString = simplePigLatin.translate("pig!");
        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldModifySentence() {
        String expectedString = "hisTay siay aay igpay!";
        String actualString = simplePigLatin.translate("This is a pig!");
        assertEquals(expectedString, actualString);
    }
}