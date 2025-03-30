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
}