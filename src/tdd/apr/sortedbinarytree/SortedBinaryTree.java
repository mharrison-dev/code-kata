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
        System.out.print(value);

        if (leftChild != null) {
            System.out.print(", ");
            leftChild.printValuesDuringPreOrderTraversal();
        }

        if (rightChild != null) {
            System.out.print(", ");
            rightChild.printValuesDuringPreOrderTraversal();
        }
    }

    public void printValuesDuringInOrderTraversal() {
        if (leftChild != null) {
            leftChild.printValuesDuringInOrderTraversal();
            System.out.print(", ");
        }

        System.out.print(value);

        if (rightChild != null) {
            System.out.print(", ");
            rightChild.printValuesDuringInOrderTraversal();
        }
    }

    public void printValuesDuringPostOrderTraversal() {
        if (leftChild != null) {
            leftChild.printValuesDuringPostOrderTraversal();
        }

        if (rightChild != null) {
            System.out.print(", ");
            rightChild.printValuesDuringPostOrderTraversal();
            System.out.print(", ");
        }

        System.out.print(value);
    }

    public void insert(T value) {
        switch (comparator.compare(value, this.value)) {
            case -1:
                if (leftChild == null) {
                    leftChild = new SortedBinaryTree<>(value, comparator);
                } else {
                    leftChild.insert(value);
                }
                break;
            case 1:
                if (rightChild == null) {
                    rightChild = new SortedBinaryTree<>(value, comparator);
                } else {
                    rightChild.insert(value);
                }
                break;
        }
    }
}
