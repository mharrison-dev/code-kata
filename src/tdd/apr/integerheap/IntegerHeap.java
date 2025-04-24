package tdd.apr.integerheap;

import java.util.Optional;

public class IntegerHeap {
    private Node rootNode = null;

    public int size() {
        return (rootNode == null)
                ? 0
                : rootNode.getNumberOfNodes();
    }

    public Optional<Integer> extractRootNode() {
        if (rootNode == null) {
            return Optional.empty();
        } else {
            Node extractedNode = rootNode;
            rootNode = rootNode.getNextRootNode();
            return Optional.of(extractedNode.value);
        }
    }

    public void insert(int value) {
        if (rootNode == null) {
            rootNode = new Node(value);
        } else {
            rootNode.insert(value);
        }
    }

    private static class Node {
        private Node leftChild = null;
        private final int value;

        private Node(int value) {
            this.value = value;
        }

        public void insert(int value) {
            leftChild = new Node(value);
        }

        public Node getNextRootNode() {
            return leftChild;
        }

        public int getNumberOfNodes() {
            return 1;
        }
    }
}
