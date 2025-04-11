package tdd.apr.tree;

import java.util.Objects;
import java.util.Optional;

public class Tree<T> {
    private T value = null;
    private Tree<T> child = null;

    public Tree() {

    }

    public Optional<Tree<T>[]> children() {
        return (child == null)
                ? Optional.empty()
                : Optional.of(new Tree[]{child});
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

    public void addChild(T valueOfChild) {
        child = new Tree<>();
        child.setValue(valueOfChild);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tree<?> tree = (Tree<?>) o;
        return Objects.equals(value, tree.value) && Objects.equals(child, tree.child);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, child);
    }
}
