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
        Node extractedNode = rootNode;
        rootNode = null;
        return (extractedNode == null)
                ? Optional.empty()
                : Optional.of(extractedNode.value);
    }

    public void insert(int value) {
        rootNode = new Node(value);
    }

    private static class Node {
        private final int value;

        private Node(int value) {
            this.value = value;
        }

        public int getNumberOfNodes() {
            return 1;
        }
    }
}
