package tdd.apr.sortedbinarytree;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    void tearDown(){
        System.setOut(productionOut);
    }

    @Test
    void shouldPrintValueOfRootNode_forPreOrderTraversal_forIntValue() {
        SortedBinaryTree<Integer> rootNode = new SortedBinaryTree<>(1);

        rootNode.printValuesDuringPreOrderTraversal();

        String expectedPrintOut = "1";
        String actualPrintOut = testByteArrayOutputStream.toString();
        assertEquals(expectedPrintOut, actualPrintOut);
    }

    @Test
    void shouldPrintValueOfRootNode_forPreOrderTraversal_forStringValue() {
        SortedBinaryTree<String> rootNode = new SortedBinaryTree<>("foo");

        rootNode.printValuesDuringPreOrderTraversal();

        String expectedPrintOut = "foo";
        String actualPrintOut = testByteArrayOutputStream.toString();
        assertEquals(expectedPrintOut, actualPrintOut);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2})
    void shouldPrintValueOfRootNodeAndThenValueOfChildNode_forPreOrderTraversal_forIntValue(int valueOfChild) {
        SortedBinaryTree<Integer> rootNode = new SortedBinaryTree<>(1);

        rootNode.insert(valueOfChild);
        rootNode.printValuesDuringPreOrderTraversal();

        String expectedPrintOut = String.join(", ", "1", String.valueOf(valueOfChild));
        String actualPrintOut = testByteArrayOutputStream.toString();
        assertEquals(expectedPrintOut, actualPrintOut);
    }
}