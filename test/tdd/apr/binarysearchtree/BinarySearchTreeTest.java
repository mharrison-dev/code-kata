package tdd.apr.binarysearchtree;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    @Test
    void getAllStringValues_emptyTree_returnsEmptyOptional() {
        BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();

        Optional<String> expectedValueList = Optional.empty();
        Optional<String> actualValueList = binarySearchTree.getAllValues();
        assertEquals(expectedValueList, actualValueList);
    }

    @Test
    void getAllIntegerValues_emptyTree_returnsEmptyOptional() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        Optional<Integer> expectedValueList = Optional.empty();
        Optional<Integer> actualValueList = binarySearchTree.getAllValues();
        assertEquals(expectedValueList, actualValueList);
    }

    @Test
    void getAllKeys_emptyTree_returnsEmptyOptional() {
        BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();

        Optional<String> expectedKeyList = Optional.empty();
        Optional<String> actualKeyList = binarySearchTree.getAllKeys();
        assertEquals(expectedKeyList, actualKeyList);
    }
}