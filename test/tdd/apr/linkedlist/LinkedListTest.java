package tdd.apr.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList<String> linkedList = null;

    @BeforeEach
    void setUp(){
        linkedList = new LinkedList<>();
    }

    @Test
    void shouldNotThrowException_whenInitializingLinkedList() {
        assertDoesNotThrow(() -> {
            LinkedList linkedList = new LinkedList();
        }, "Should not throw an exception when initializing a linked list");
    }

    @Test
    void shouldReturnEmptyOptional_forValue_whenValueHasNotBeenSet() {
        Optional<String> expectedValue = Optional.empty();
        Optional<String> actualValue = linkedList.value();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void shouldReturnEmptyOptional_forNext_whenNextNodeHasNotBeenSet() {
        Optional<LinkedList<String>> expectedNextNode = Optional.empty();
        Optional<LinkedList<String>> actualNextNode = linkedList.next();
        assertEquals(expectedNextNode, actualNextNode);
    }

    @Test
    void shouldReturnValue_forValue_whenValueHasBeenSet() {
        linkedList.setValue("foo");

        Optional<String> expectedValue = Optional.of("foo");
        Optional<String> actualValue = linkedList.value();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void shouldReturnNextNode_forNext_whenNextNodeHasBeenSet() {
        LinkedList<String> nextLinkedList = new LinkedList<>();

        linkedList.setNext(nextLinkedList);
        nextLinkedList.setValue("foo");

        Optional<LinkedList<String>> expectedNextNode = Optional.of(nextLinkedList);
        Optional<LinkedList<String>> actualNextNode = linkedList.next();
        assertEquals(expectedNextNode, actualNextNode);
    }
}