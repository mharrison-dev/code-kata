package tdd.apr.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Tree<T> {
    private T value = null;
    private final int depth;
    private final List<Tree<T>> children = new ArrayList<>();

    public Tree() {
        depth = 0;
    }

    private Tree(int depth) {
        this.depth = depth;
    }

    public Optional<List<Tree<T>>> children() {
        return (children.isEmpty())
                ? Optional.empty()
                : Optional.of(new ArrayList<>(children));
    }

    public int depth() {
        return depth;
    }

    public int height() {
        if (children.isEmpty()) {
            return 0;
        }

        int largestChildHeight = 0;
        for (Tree<T> child : children) {
            if (child.height() > largestChildHeight) {
                largestChildHeight = child.height();
            }
        }

        return largestChildHeight + 1;
    }

    public Optional<T> getValue() {
        return (value == null)
                ? Optional.empty()
                : Optional.of(value);
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void addChild() {
        Tree<T> child = new Tree<>(depth + 1);
        children.add(child);
    }

    public void addChild(T valueOfChild) {
        Tree<T> child = new Tree<>(depth + 1);
        child.setValue(valueOfChild);
        children.add(child);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tree<?> tree = (Tree<?>) o;
        return Objects.equals(value, tree.value) && Objects.equals(children, tree.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, children);
    }
}
