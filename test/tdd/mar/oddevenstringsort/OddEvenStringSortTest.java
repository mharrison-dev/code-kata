package tdd.mar.oddevenstringsort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OddEvenStringSortTest {
    private OddEvenStringSort oddEvenStringSort = null;

    @BeforeEach
    public void setUp() {
        oddEvenStringSort = new OddEvenStringSort();
    }

    @Test
    public void shouldReturnEmptyString_whenGivenEmptyString() {
        String emptyString = "";

        String expectedString = "";
        String actualString = oddEvenStringSort.sort(emptyString);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldReturnStringOfLengthOne_whenGivenStringOfLengthOne() {
        String string = "a";

        String expectedString = "a";
        String actualString = oddEvenStringSort.sort(string);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldReturnStringWithSpaceSplittingTwoCharacters_whenGivenStringOfLengthTwo() {
        String string = "ab";

        String expectedString = "a b";
        String actualString = oddEvenStringSort.sort(string);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldReturnStringWithEvenCharactersSeparatedFromOddCharacters_whenGivenStringThatIsLongerThanTwoCharacters() {
        String string = "abc";

        String expectedString = "ac b";
        String actualString = oddEvenStringSort.sort(string);
        assertEquals(expectedString, actualString);
    }
}