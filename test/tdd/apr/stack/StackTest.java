package tdd.apr.stack;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    @Test
    void shouldReturnZero_afterSizeIsCalled_whenStackIsEmpty() {
        Stack stack = new Stack();

        int expectedSize = 0;
        int actualSize = stack.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void shouldReturnOne_afterSizeIsCalled_afterItemHasBeenPushed() {
        Integer item = 1;
        Stack<Integer> stack = new Stack<>();

        stack.push(item);

        int expectedSize = 1;
        int actualSize = stack.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void shouldReturnOne_afterSizeIsCalled_afterDifferentTypeOfItemHasBeenPushed() {
        String item = "";
        Stack<String> stack = new Stack<>();

        stack.push(item);

        int expectedSize = 1;
        int actualSize = stack.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void shouldReturnEmptyOptional_afterPopIsCalled_whenStackIsEmpty() {
        Stack<String> stack = new Stack<>();

        Optional<String> expectedOptional = Optional.empty();
        Optional<String> actualOptional = stack.pop();
        assertEquals(expectedOptional, actualOptional);
    }
}