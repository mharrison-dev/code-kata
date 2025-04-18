package tdd.apr.sortedbinarytree;

import java.util.Comparator;

public class SortedBinaryTree<T> {
    private final T value;
    private final Comparator<T> comparator;
    private SortedBinaryTree<T> leftChild = null;
    private SortedBinaryTree<T> rightChild = null;
    
    public SortedBinaryTree(T value, Comparator<T> comparator) {
        this.value = value;
        this.comparator = comparator;
    }

    public void printValuesDuringPreOrderTraversal() {
        StringBuilder printStringBuilder = new StringBuilder();

        printStringBuilder.append(value);

        if (leftChild != null) {
            printStringBuilder.append(", ");
            printStringBuilder.append(leftChild.value);
        }

        if (rightChild != null) {
            printStringBuilder.append(", ");
            printStringBuilder.append(rightChild.value);
        }

        System.out.print(printStringBuilder);
    }

    public void insert(T value) {
        switch (comparator.compare(value, this.value)) {
            case -1:
                leftChild = new SortedBinaryTree<>(value, comparator);
                break;
            case 1:
                rightChild = new SortedBinaryTree<>(value, comparator);
                break;
        }
    }
}
