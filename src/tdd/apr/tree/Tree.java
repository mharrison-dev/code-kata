package tdd.apr.tree;

import java.util.Optional;

public class Tree<T> {
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
}
