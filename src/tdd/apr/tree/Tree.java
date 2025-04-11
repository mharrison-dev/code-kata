package tdd.apr.tree;

import java.util.Optional;

public class Tree<T> {
    private T value = null;

    public Tree() {

    }

    public Optional<Tree<T>[]> children() {
        return Optional.empty();
    }

    public int depth() {
        return 0;
    }

    public int height() {
        return 0;
    }

    public Optional<T> getValue() {
        return (value == null)
                ? Optional.empty()
                : Optional.of(value);
    }

    public void setValue(T value) {
        this.value = value;
    }
}
