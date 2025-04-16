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
}