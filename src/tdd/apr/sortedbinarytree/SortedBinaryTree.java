package tdd.apr.sortedbinarytree;

public class SortedBinaryTree<T> {
    private final T value;

    public SortedBinaryTree(T value) {
        this.value = value;
    }

    public void printValuesDuringPreOrderTraversal() {
        System.out.print(value);
    }
}
