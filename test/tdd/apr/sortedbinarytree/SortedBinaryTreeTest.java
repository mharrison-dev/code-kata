package tdd.apr.sortedbinarytree;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SortedBinaryTreeTest {
    @Test
    void shouldPrintValueOfRootNode_forPreOrderTraversal_forIntValue() {
        ByteArrayOutputStream testByteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream testOut = new PrintStream(testByteArrayOutputStream);
        PrintStream productionOut = System.out;
        SortedBinaryTree<Integer> rootNode = new SortedBinaryTree<>(1);

        System.setOut(testOut);
        rootNode.printValuesDuringPreOrderTraversal();
        System.setOut(productionOut);

        String expectedPrintOut = "1";
        String actualPrintOut = testByteArrayOutputStream.toString();
        assertEquals(expectedPrintOut, actualPrintOut);
    }

    @Test
    void shouldPrintValueOfRootNode_forPreOrderTraversal_forStringValue() {
        ByteArrayOutputStream testByteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream testOut = new PrintStream(testByteArrayOutputStream);
        PrintStream productionOut = System.out;
        SortedBinaryTree<String> rootNode = new SortedBinaryTree<>("foo");

        System.setOut(testOut);
        rootNode.printValuesDuringPreOrderTraversal();
        System.setOut(productionOut);

        String expectedPrintOut = "foo";
        String actualPrintOut = testByteArrayOutputStream.toString();
        assertEquals(expectedPrintOut, actualPrintOut);
    }
}