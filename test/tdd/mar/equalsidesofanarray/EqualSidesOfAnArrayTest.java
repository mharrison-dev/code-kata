package tdd.mar.equalsidesofanarray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EqualSidesOfAnArrayTest {
    private EqualSidesOfAnArray equalSidesOfAnArray = null;

    @BeforeEach
    public void setUp() {
        equalSidesOfAnArray = new EqualSidesOfAnArray();
    }

    @Test
    public void shouldReturnNegativeOneWhenGivenEmptyArray() {
        int expectedIndex = -1;
        int actualIndex = equalSidesOfAnArray.findMiddleIndex(new int[0]);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void shouldReturnZeroWhenGivenArrayWithOneElement() {
        int expectedIndex = 0;
        int actualIndex = equalSidesOfAnArray.findMiddleIndex(new int[]{0});
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void shouldReturnOneWhenGivenArrayWithOneElementSurroundedByTwoIdenticalElements() {
        int expectedIndex = 1;
        int actualIndex = equalSidesOfAnArray.findMiddleIndex(new int[]{1, 0, 1});
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void shouldReturnNegativeOneWhenGivenArrayWithOneElementSurroundedByTwoDifferentElements() {
        int expectedIndex = -1;
        int actualIndex = equalSidesOfAnArray.findMiddleIndex(new int[]{1, 0, 2});
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void shouldReturnTwoWhenMiddleIntegerIsThirdElementOutOfFourElements() {
        int expectedIndex = 2;
        int actualIndex = equalSidesOfAnArray.findMiddleIndex(new int[]{1, 1, 0, 2});
        assertEquals(expectedIndex, actualIndex);
    }
}