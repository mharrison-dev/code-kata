package tdd.apr.binarysearchtree;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    @Test
    void getAllValues_emptyTree_returnsEmptyOptional() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        Optional<String> expectedValueList = Optional.empty();
        Optional<String> actualValueList = binarySearchTree.getAllValues();
        assertEquals(expectedValueList, actualValueList);
    }
}