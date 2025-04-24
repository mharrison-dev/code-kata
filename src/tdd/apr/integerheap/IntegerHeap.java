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
        private int value;
        private final Node parent;
        private Node leftChild = null;

        private Node(int value) {
            this.value = value;
            parent = null;
        }

        private Node(int value, Node parent) {
            this.value = value;
            this.parent = parent;
            siftUp();
        }

        public void insert(int value) {
            leftChild = new Node(value, this);
        }

        private void siftUp() {
            if (parent == null) {
                return;
            }

            if (parent.value < this.value) {
                return;
            }

            int temp = parent.value;
            parent.value = this.value;
            this.value = temp;
            parent.siftUp();
        }

        public Node getNextRootNode() {
            return leftChild;
        }

        public int getNumberOfNodes() {
            return 1;
        }
    }
}
