package tdd.apr.tree;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {
    @Test
    void shouldInstantiateTree() {
        assertDoesNotThrow(() -> {
            Tree tree = new Tree();
        }, "Instantiation of a tree should not throw an exception");
    }

    @Test
    void shouldGetEmptyOptional_forChildren_whenTreeIsEmpty() {
        Tree tree = new Tree();

        Optional<Tree[]> expectedChildren = Optional.empty();
        Optional<Tree[]> actualChildren = tree.children();
        assertEquals(expectedChildren, actualChildren);
    }
}