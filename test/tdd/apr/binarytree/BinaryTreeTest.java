package tdd.apr.binarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    private BinaryTree<String> binaryTree = null;

    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree<>();
    }

    @Test
    void shouldReturnEmptyOptional_forValue_whenValueHasNotBeenSet() {
        Optional<String> expectedValue = Optional.empty();
        Optional<String> actualValue = binaryTree.value();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void shouldReturnFoo_forValue_whenValueHasBeenSetToFoo() {
        binaryTree.setValue("foo");

        Optional<String> expectedValue = Optional.of("foo");
        Optional<String> actualValue = binaryTree.value();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void shouldReturnEmptyOptional_forLeftChild_whenLeftChildHasNotBeenSet() {
        Optional<BinaryTree<String>> expectedLeftChild = Optional.empty();
        Optional<BinaryTree<String>> actualLeftChild = binaryTree.leftChild();
        assertEquals(expectedLeftChild, actualLeftChild);
    }

    @Test
    void shouldReturnBinaryTree_forLeftChild_whenLeftChildHasBeenSet() {
        BinaryTree<String> leftChild = new BinaryTree<>();

        binaryTree.setLeftChild(leftChild);

        Optional<BinaryTree<String>> expectedLeftChild = Optional.of(leftChild);
        Optional<BinaryTree<String>> actualLeftChild = binaryTree.leftChild();
        assertEquals(expectedLeftChild, actualLeftChild);
    }
}