package tdd.apr.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    @Test
    void shouldNotThrowException_whenInitializingLinkedList() {
        assertDoesNotThrow(() -> {
            LinkedList linkedList = new LinkedList();
        }, "Should not throw an exception when initializing a linked list");
    }

    @Test
    void shouldReturnEmptyOptional_forValue_whenValueHasNotBeenSet() {
        LinkedList<String> linkedList = new LinkedList<>();

        Optional<String> expectedValue = Optional.empty();
        Optional<String> actualValue = linkedList.value();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void shouldReturnEmptyOptional_forNextNode_whenNextNodeHasNotBeenSet() {
        LinkedList<String> linkedList = new LinkedList<>();

        Optional<String> expectedValue = Optional.empty();
        Optional<String> actualValue = linkedList.next();
        assertEquals(expectedValue, actualValue);
    }
}