package tdd.apr.binarytree;

import java.util.Optional;

public class BinaryTree<T> {
    private T value = null;

    public Optional<T> value() {
        return (value == null)
                ? Optional.empty()
                : Optional.of(value);
    }

    public void setValue(T value) {
        this.value = value;
    }
}
