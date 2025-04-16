package tdd.apr.binarytree;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    @Test
    void shouldReturnEmptyOptional_forValue_whenValueHasNotBeenSet() {
        BinaryTree<String> binaryTree = new BinaryTree<>();

        Optional<String> expectedValue = Optional.empty();
        Optional<String> actualValue = binaryTree.value();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void shouldReturnFoo_forValue_whenValueHasBeenSetToFoo() {
        BinaryTree<String> binaryTree = new BinaryTree<>();

        binaryTree.setValue("foo");

        Optional<String> expectedValue = Optional.of("foo");
        Optional<String> actualValue = binaryTree.value();
        assertEquals(expectedValue, actualValue);
    }
}