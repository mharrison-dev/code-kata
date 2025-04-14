package tdd.apr.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    @Test
    void shouldNotThrowException_whenInitializingLinkedList() {
        assertDoesNotThrow(() -> {
            LinkedList linkedList = new LinkedList();
        }, "Should not throw an exception when initializing a linked list");
    }
}