package tdd.apr.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Tree<T> {
    private T value = null;
    private final List<Tree<T>> children = new ArrayList<>();

    public Optional<Tree<T>[]> children() {
        return (children.isEmpty())
                ? Optional.empty()
                : Optional.of(children.toArray(new Tree[0]));
    }

    public int depth() {
        return 0;
    }

    public int height() {
        int height = 0;
        Tree<T> currentNode = this;
        while (!currentNode.children.isEmpty()) {
            height++;
            currentNode = currentNode.children.getFirst();
        }

        return height;
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
        Tree<T> child = new Tree<>();
        children.add(child);
    }

    public void addChild(T valueOfChild) {
        Tree<T> child = new Tree<>();
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
