package tdd.apr.integerheap;

import java.util.Optional;

public class IntegerHeap {
    private Node rootNode = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public Optional<Integer> extractRootNode() {
        size--;
        return (rootNode == null)
                ? Optional.empty()
                : Optional.of(rootNode.value);
    }

    public void insert(int value) {
        rootNode = new Node(value);
        size++;
    }

    private static class Node {
        private final int value;

        private Node(int value) {
            this.value = value;
        }
    }
}
