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

    @Test
    void shouldReturnOne_whenSizeIsCalled_afterItemHasBeenPushed() {
        Integer item = 1;
        Stack stack = new Stack();

        stack.push(item);

        int expectedSize = 1;
        int actualSize = stack.size();
        assertEquals(expectedSize, actualSize);
    }
}