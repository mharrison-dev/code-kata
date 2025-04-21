package tdd.apr.binarysearchtree;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    @Test
    void getAllStringValues_emptyTree_returnsEmptyOptional() {
        BinarySearchTree<String, String> binarySearchTree = new BinarySearchTree<>();

        Optional<String> expectedValueList = Optional.empty();
        Optional<String> actualValueList = binarySearchTree.getAllValues();
        assertEquals(expectedValueList, actualValueList);
    }

    @Test
    void getAllIntegerValues_emptyTree_returnsEmptyOptional() {
        BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<>();

        Optional<Integer> expectedValueList = Optional.empty();
        Optional<Integer> actualValueList = binarySearchTree.getAllValues();
        assertEquals(expectedValueList, actualValueList);
    }

    @Test
    void getAllStringKeys_emptyTree_returnsEmptyOptional() {
        BinarySearchTree<String, String> binarySearchTree = new BinarySearchTree<>();

        Optional<String> expectedKeyList = Optional.empty();
        Optional<String> actualKeyList = binarySearchTree.getAllKeys();
        assertEquals(expectedKeyList, actualKeyList);
    }

    @Test
    void getAllIntegerKeys_emptyTree_returnsEmptyOptional() {
        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>();

        Optional<Integer> expectedKeyList = Optional.empty();
        Optional<Integer> actualKeyList = binarySearchTree.getAllKeys();
        assertEquals(expectedKeyList, actualKeyList);
    }

    @Test
    void getAllKeys_afterOneInsertion_returnsKeyOfInsertedEntry() {
        int key = 0;
        String value = "foo";
        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>();

        binarySearchTree.insert(key, value);

        Optional<Integer> expectedKeyList = Optional.of(key);
        Optional<Integer> actualKeyList = binarySearchTree.getAllKeys();
        assertEquals(expectedKeyList, actualKeyList);
    }

    @Test
    void getAllValues_afterOneInsertion_returnsValueOfInsertedEntry() {
        int key = 0;
        String value = "foo";
        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>();

        binarySearchTree.insert(key, value);

        Optional<String> expectedValueList = Optional.of(value);
        Optional<String> actualValueList = binarySearchTree.getAllValues();
        assertEquals(expectedValueList, actualValueList);
    }
}