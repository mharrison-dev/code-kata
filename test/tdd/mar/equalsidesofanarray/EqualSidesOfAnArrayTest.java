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
}