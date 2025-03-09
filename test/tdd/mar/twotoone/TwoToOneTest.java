package tdd.mar.twotoone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoToOneTest {
    @Test
    public void shouldReturnSortedString() {
        TwoToOne twoToOne = new TwoToOne();

        String expectedString = "ab";
        String actualString = twoToOne.combine("a", "b");
        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldReturnSortedStringWhenArgumentsAreFlipped() {
        TwoToOne twoToOne = new TwoToOne();

        String expectedString = "ab";
        String actualString = twoToOne.combine("b", "a");
        assertEquals(expectedString, actualString);
    }
}