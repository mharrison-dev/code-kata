package tdd.apr.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    @Test
    void shouldReturnZero_whenSizeIsCalled_whenStackIsEmpty() {
        Stack stack = new Stack();

        int expectedSize = 0;
        int actualSize = stack.size();
        assertEquals(expectedSize, actualSize);
    }
}