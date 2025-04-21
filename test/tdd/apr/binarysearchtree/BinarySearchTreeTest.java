package tdd.apr.binarysearchtree;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    @Test
    void getAllStringValues_emptyTree_returnsEmptyOptional() {
        BinarySearchTree<String, String> binarySearchTree = new BinarySearchTree<>(getStringComparator());

        Optional<List<String>> expectedValueList = Optional.empty();
        Optional<List<String>> actualValueList = binarySearchTree.getAllValues();
        assertEquals(expectedValueList, actualValueList);
    }

    @Test
    void getAllIntegerValues_emptyTree_returnsEmptyOptional() {
        BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<>(getIntegerComparator());

        Optional<List<Integer>> expectedValueList = Optional.empty();
        Optional<List<Integer>> actualValueList = binarySearchTree.getAllValues();
        assertEquals(expectedValueList, actualValueList);
    }

    @Test
    void getAllStringKeys_emptyTree_returnsEmptyOptional() {
        BinarySearchTree<String, String> binarySearchTree = new BinarySearchTree<>(getStringComparator());

        Optional<List<String>> expectedKeyList = Optional.empty();
        Optional<List<String>> actualKeyList = binarySearchTree.getAllKeys();
        assertEquals(expectedKeyList, actualKeyList);
    }

    @Test
    void getAllIntegerKeys_emptyTree_returnsEmptyOptional() {
        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>(getIntegerComparator());

        Optional<List<Integer>> expectedKeyList = Optional.empty();
        Optional<List<Integer>> actualKeyList = binarySearchTree.getAllKeys();
        assertEquals(expectedKeyList, actualKeyList);
    }

    @Test
    void getAllKeys_afterOneInsertion_returnsKeyOfInsertedEntry() {
        int key = 0;
        String value = "foo";
        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>(getIntegerComparator());

        binarySearchTree.insert(key, value);

        Optional<List<Integer>> expectedKeyList = Optional.of(List.of(key));
        Optional<List<Integer>> actualKeyList = binarySearchTree.getAllKeys();
        assertEquals(expectedKeyList, actualKeyList);
    }

    @Test
    void getAllValues_afterOneInsertion_returnsValueOfInsertedEntry() {
        int key = 0;
        String value = "foo";
        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>(getIntegerComparator());

        binarySearchTree.insert(key, value);

        Optional<List<String>> expectedValueList = Optional.of(List.of(value));
        Optional<List<String>> actualValueList = binarySearchTree.getAllValues();
        assertEquals(expectedValueList, actualValueList);
    }

    @Test
    void getAllKeys_afterTwoInsertion_returnsKeysOfInsertedEntriesInPreOrder() {
        int key = 0;
        String value = "foo";
        int otherKey = 1;
        String otherValue = "goo";
        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>(getIntegerComparator());

        binarySearchTree.insert(key, value);
        binarySearchTree.insert(otherKey, otherValue);

        Optional<List<Integer>> expectedKeyList = Optional.of(List.of(key, otherKey));
        Optional<List<Integer>> actualKeyList = binarySearchTree.getAllKeys();
        assertEquals(expectedKeyList, actualKeyList);
    }

    @Test
    void getAllValues_afterTwoInsertion_returnsValuesOfInsertedEntriesInPreOrder() {
        int key = 0;
        String value = "foo";
        int otherKey = 1;
        String otherValue = "goo";
        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>(getIntegerComparator());

        binarySearchTree.insert(key, value);
        binarySearchTree.insert(otherKey, otherValue);

        Optional<List<String>> expectedKeyList = Optional.of(List.of(value, otherValue));
        Optional<List<String>> actualKeyList = binarySearchTree.getAllValues();
        assertEquals(expectedKeyList, actualKeyList);
    }

    @Test
    void getAllKeys_afterThreeInsertion_returnsKeysOfInsertedEntriesInPreOrder() {
        int rootKey = 0;
        String rootValue = "foo";
        int leftKey = -1;
        String leftValue = "boo";
        int rightKey = 1;
        String rightValue = "goo";
        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>(getIntegerComparator());

        binarySearchTree.insert(rootKey, rootValue);
        binarySearchTree.insert(rightKey, rightValue);
        binarySearchTree.insert(leftKey, leftValue);

        Optional<List<Integer>> expectedKeyList = Optional.of(List.of(rootKey, leftKey, rightKey));
        Optional<List<Integer>> actualKeyList = binarySearchTree.getAllKeys();
        assertEquals(expectedKeyList, actualKeyList);
    }

    @Test
    void getAllKeys_degenerateTree_returnsKeysOfInsertedEntriesInPreOrder() {
        int rootKey = 0;
        String rootValue = "foo";
        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>(getIntegerComparator());

        binarySearchTree.insert(rootKey, rootValue);
        binarySearchTree.insert(-1, "goo");
        binarySearchTree.insert(-2, "boo");
        binarySearchTree.insert(1, "goo");
        binarySearchTree.insert(2, "boo");

        Optional<List<Integer>> expectedKeyList = Optional.of(List.of(rootKey, -1, -2, 1, 2));
        Optional<List<Integer>> actualKeyList = binarySearchTree.getAllKeys();
        assertEquals(expectedKeyList, actualKeyList);
    }

    @Test
    void find_treeWithoutKeyValue_returnsEmptyOptional() {
        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>(getIntegerComparator());

        binarySearchTree.insert(0, "foo");
        binarySearchTree.insert(-1, "boo");
        binarySearchTree.insert(1, "goo");

        Optional<String> expectedKeyList = Optional.empty();
        Optional<String> actualKeyList = binarySearchTree.find(2);
        assertEquals(expectedKeyList, actualKeyList);
    }

    @Test
    void find_treeWithKeyValue_returnsEmptyOptional() {
        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>(getIntegerComparator());

        binarySearchTree.insert(0, "foo");
        binarySearchTree.insert(-1, "boo");
        binarySearchTree.insert(1, "goo");

        Optional<String> expectedKeyList = Optional.of("goo");
        Optional<String> actualKeyList = binarySearchTree.find(1);
        assertEquals(expectedKeyList, actualKeyList);
    }

    private Comparator<Integer> getIntegerComparator() {
        return new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
    }

    private Comparator<String> getStringComparator() {
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.equals(o2)) {
                    return 0;
                }

                String[] strings = {o1, o2};
                Arrays.sort(strings);
                return (strings[0].equals(o1))
                        ? 1
                        : -1;
            }
        };
    }
}