package tdd.apr.integerheapsecondtry;

import java.util.Optional;

public class IntegerHeap {
    private Node root;

    public Optional<Integer> extract() {
        return (root == null)
                ? Optional.empty()
                : Optional.of(root.integer);
    }

    public void insert(int integer) {
        root = new Node(integer);
    }

    private static class Node {
        private final int integer;

        public Node(int integer) {
            this.integer = integer;
        }
    }
}
