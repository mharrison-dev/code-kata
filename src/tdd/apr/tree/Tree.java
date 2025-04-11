package tdd.apr.tree;

import java.util.Optional;

public class Tree {
    public Tree() {

    }

    public Optional<Tree[]> children() {
        return Optional.empty();
    }

    public int depth() {
        return 0;
    }

    public int height() {
        return 0;
    }
}
