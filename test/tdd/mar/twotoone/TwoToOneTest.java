package tdd.mar.twotoone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoToOneTest {
    private TwoToOne twoToOne = null;

    @BeforeEach
    public void setUp() {
        twoToOne = new TwoToOne();
    }

    @Test
    public void shouldReturnSortedString() {
        String expectedString = "ab";
        String actualString = twoToOne.combine("a", "b");
        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldReturnSortedStringWhenArgumentsAreFlipped() {
        String expectedString = "ab";
        String actualString = twoToOne.combine("b", "a");
        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldReturnSortedStringWhenArgumentsContainsMoreThanOneLetter() {
        String expectedString = "abcd";
        String actualString = twoToOne.combine("bd", "ac");
        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldReturnSortedStringWithDistinctLetters() {
        String expectedString = "abcd";
        String actualString = twoToOne.combine("bdd", "aac");
        assertEquals(expectedString, actualString);
    }
}