package tdd.mar.equalsidesofanarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EqualSidesOfAnArrayTest {
    @Test
    public void shouldReturnNegativeOneWhenGivenEmptyArray() {
        EqualSidesOfAnArray equalSidesOfAnArray = new EqualSidesOfAnArray();

        int expectedIndex = -1;
        int actualIndex = equalSidesOfAnArray.findMiddleIndex(new int[0]);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void shouldReturnZeroWhenGivenArrayWithOneElement() {
        EqualSidesOfAnArray equalSidesOfAnArray = new EqualSidesOfAnArray();

        int expectedIndex = 0;
        int actualIndex = equalSidesOfAnArray.findMiddleIndex(new int[]{0});
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void shouldReturnOneWhenGivenArrayWithOneElementSurroundedByTwoIdenticalElements() {
        EqualSidesOfAnArray equalSidesOfAnArray = new EqualSidesOfAnArray();

        int expectedIndex = 1;
        int actualIndex = equalSidesOfAnArray.findMiddleIndex(new int[]{1, 0, 1});
        assertEquals(expectedIndex, actualIndex);
    }
}