package tdd.mar.oddevenstringsort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OddEvenStringSortTest {
    @Test
    public void shouldReturnEmptyString_whenGivenEmptyString() {
        String emptyString = "";
        OddEvenStringSort oddEvenStringSort = new OddEvenStringSort();

        String expectedString = "";
        String actualString = oddEvenStringSort.sort(emptyString);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldReturnStringOfLengthOne_whenGivenStringOfLengthOne() {
        String string = "a";
        OddEvenStringSort oddEvenStringSort = new OddEvenStringSort();

        String expectedString = "a";
        String actualString = oddEvenStringSort.sort(string);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldReturnStringWithSpaceSplittingTwoCharacters_whenGivenStringOfLengthTwo() {
        String string = "ab";
        OddEvenStringSort oddEvenStringSort = new OddEvenStringSort();

        String expectedString = "a b";
        String actualString = oddEvenStringSort.sort(string);
        assertEquals(expectedString, actualString);
    }
}