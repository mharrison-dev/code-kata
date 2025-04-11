package tdd.apr.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {
    @Test
    void shouldInstantiateTree() {
        assertDoesNotThrow(() -> {
            Tree tree = new Tree();
        }, "Instantiation of a tree should not throw an exception");
    }
}