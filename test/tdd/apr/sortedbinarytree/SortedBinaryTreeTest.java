package tdd.apr.sortedbinarytree;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class SortedBinaryTreeTest {
    private ByteArrayOutputStream testByteArrayOutputStream = null;
    private final PrintStream productionOut = System.out;

    @BeforeEach
    void setUp() {
        testByteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream testOut = new PrintStream(testByteArrayOutputStream);
        System.setOut(testOut);
    }

    @AfterEach
    void tearDown() {
        System.setOut(productionOut);
    }

    @Test
    void shouldPrintValueOfRootNode_forPreOrderTraversal_forIntValue() {
        SortedBinaryTree<Integer> rootNode = new SortedBinaryTree<>(1, new IntegerComparator());

        rootNode.printValuesDuringPreOrderTraversal();

        String expectedPrintOut = "1";
        String actualPrintOut = testByteArrayOutputStream.toString();
        assertEquals(expectedPrintOut, actualPrintOut);
    }

    @Test
    void shouldPrintValueOfRootNode_forPreOrderTraversal_forStringValue() {
        SortedBinaryTree<String> rootNode = new SortedBinaryTree<>("foo", new StringComparator());

        rootNode.printValuesDuringPreOrderTraversal();

        String expectedPrintOut = "foo";
        String actualPrintOut = testByteArrayOutputStream.toString();
        assertEquals(expectedPrintOut, actualPrintOut);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2})
    void shouldPrintValueOfRootNodeAndThenValueOfChildNode_forPreOrderTraversal_forIntValue(int valueOfChild) {
        SortedBinaryTree<Integer> rootNode = new SortedBinaryTree<>(1, new IntegerComparator());

        rootNode.insert(valueOfChild);
        rootNode.printValuesDuringPreOrderTraversal();

        String expectedPrintOut = String.join(", ", "1", String.valueOf(valueOfChild));
        String actualPrintOut = testByteArrayOutputStream.toString();
        assertEquals(expectedPrintOut, actualPrintOut);
    }

    @Test
    void shouldPrintValuesOfTreeInPreOrder_forPreOrderTraversal_forIntValue() {
        SortedBinaryTree<Integer> rootNode = new SortedBinaryTree<>(1, new IntegerComparator());

        rootNode.insert(2);
        rootNode.insert(0);
        rootNode.printValuesDuringPreOrderTraversal();

        String expectedPrintOut = "1, 0, 2";
        String actualPrintOut = testByteArrayOutputStream.toString();
        assertEquals(expectedPrintOut, actualPrintOut);
    }

    @Test
    void shouldPrintValuesOfTreeInPreOrder_forPreOrderTraversal_forTreeOfDepthTwo() {
        SortedBinaryTree<Integer> rootNode = new SortedBinaryTree<>(5, new IntegerComparator());

        rootNode.insert(2);
        rootNode.insert(7);
        rootNode.insert(-1);
        rootNode.insert(3);
        rootNode.insert(6);
        rootNode.insert(8);
        rootNode.printValuesDuringPreOrderTraversal();

        String expectedPrintOut = "5, 2, -1, 3, 7, 6, 8";
        String actualPrintOut = testByteArrayOutputStream.toString();
        assertEquals(expectedPrintOut, actualPrintOut);
    }

    @Test
    void shouldPrintValuesOfTreeInInOrder_forInOrderTraversal_forTreeOfDepthTwo() {
        SortedBinaryTree<Integer> rootNode = new SortedBinaryTree<>(5, new IntegerComparator());

        rootNode.insert(2);
        rootNode.insert(7);
        rootNode.insert(-1);
        rootNode.insert(3);
        rootNode.insert(6);
        rootNode.insert(8);
        rootNode.printValuesDuringInOrderTraversal();

        String expectedPrintOut = "-1, 2, 3, 5, 6, 7, 8";
        String actualPrintOut = testByteArrayOutputStream.toString();
        assertEquals(expectedPrintOut, actualPrintOut);
    }

    @Test
    void shouldPrintValuesOfTreeInPostOrder_forPostOrderTraversal_forTreeOfDepthTwo() {
        SortedBinaryTree<Integer> rootNode = new SortedBinaryTree<>(5, new IntegerComparator());

        rootNode.insert(2);
        rootNode.insert(7);
        rootNode.insert(-1);
        rootNode.insert(3);
        rootNode.insert(6);
        rootNode.insert(8);
        rootNode.printValuesDuringPostOrderTraversal();

        String expectedPrintOut = "-1, 3, 2, 6, 8, 7, 5";
        String actualPrintOut = testByteArrayOutputStream.toString();
        assertEquals(expectedPrintOut, actualPrintOut);
    }

    @Test
    void shouldPrintValuesOfTreeInPostOrder_forPostOrderTraversal_forTreeThatHasRightNodeAsFirstLeaf() {
        SortedBinaryTree<Integer> rootNode = new SortedBinaryTree<>(5, new IntegerComparator());

        rootNode.insert(2);
        rootNode.insert(7);
        rootNode.insert(3);
        rootNode.insert(6);
        rootNode.insert(8);
        rootNode.printValuesDuringPostOrderTraversal();

        String expectedPrintOut = "3, 2, 6, 8, 7, 5";
        String actualPrintOut = testByteArrayOutputStream.toString();
        assertEquals(expectedPrintOut, actualPrintOut);
    }

    private static class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1, o2);
        }
    }

    private static class StringComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o1.hashCode(), o2.hashCode());
        }
    }
}