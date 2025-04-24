package tdd.apr.integerheap;

import java.util.Optional;

public class IntegerHeap {
    private Node rootNode = null;

    public int size() {
        return 0;
    }

    public Optional<Integer> extractRootNode() {
        return (rootNode == null)
                ? Optional.empty()
                : Optional.of(rootNode.value);
    }

    public void insert(int value) {
        rootNode = new Node(value);
    }

    private static class Node {
        private final int value;

        private Node(int value) {
            this.value = value;
        }
    }
}
