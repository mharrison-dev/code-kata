package tdd.apr.binarytree;

import java.util.Optional;

public class BinaryTree<T> {
    private T value = null;
    private BinaryTree<T> leftChild = null;

    public Optional<T> value() {
        return (value == null)
                ? Optional.empty()
                : Optional.of(value);
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Optional<BinaryTree<T>> leftChild() {
        return (leftChild == null)
                ? Optional.empty()
                : Optional.of(leftChild);
    }

    public void setLeftChild(BinaryTree<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Optional<BinaryTree<T>> rightChild() {
        return Optional.empty();
    }
}
