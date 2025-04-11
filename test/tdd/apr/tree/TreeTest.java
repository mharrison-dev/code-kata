package tdd.apr.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {
    private Tree tree = null;

    @BeforeEach
    void setUp() {
        tree = new Tree();
    }

    @Test
    void shouldInstantiateTree() {
        assertDoesNotThrow(() -> {
            tree = new Tree();
        }, "Instantiation of a tree should not throw an exception");
    }

    @Test
    void shouldGetEmptyOptional_forChildren_whenTreeIsEmpty() {
        Optional<Tree[]> expectedChildren = Optional.empty();
        Optional<Tree[]> actualChildren = tree.children();
        assertEquals(expectedChildren, actualChildren);
    }

    @Test
    void shouldGetZero_forDepthOfRoot_whenTreeIsEmpty() {
        int expectedDepth = 0;
        int actualDepth = tree.depth();
        assertEquals(expectedDepth, actualDepth);
    }

    @Test
    void shouldGetZero_forHeightOfRoot_whenTreeIsEmpty() {
        int expectedHeight = 0;
        int actualHeight = tree.height();
        assertEquals(expectedHeight, actualHeight);
    }

    @Test
    void shouldInstantiateTree_forStrings() {
        assertDoesNotThrow(() -> {
            tree = new Tree<String>();
        }, "Instantiation of a tree for strings should not throw an exception");
    }
}