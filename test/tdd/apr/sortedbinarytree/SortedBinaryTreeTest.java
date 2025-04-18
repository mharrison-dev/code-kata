package tdd.apr.sortedbinarytree;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SortedBinaryTreeTest {
    @Test
    void shouldPrintValueOfRootNode_forPreOrderTraversal() {
        ByteArrayOutputStream testByteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream testOut = new PrintStream(testByteArrayOutputStream);
        PrintStream productionOut = System.out;
        SortedBinaryTree rootNode = new SortedBinaryTree(1);

        System.setOut(testOut);
        rootNode.printValuesDuringPreOrderTraversal();
        System.setOut(productionOut);

        String expectedPrintOut = "1";
        String actualPrintOut = testByteArrayOutputStream.toString();
        assertEquals(expectedPrintOut, actualPrintOut);
    }
}