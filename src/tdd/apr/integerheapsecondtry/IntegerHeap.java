package tdd.apr.integerheapsecondtry;

import java.util.Optional;

public class IntegerHeap {
    private Node root;

    public Optional<Integer> extract() {
        if (root == null) {
            return Optional.empty();
        }

        int extractedInteger = root.integer;
        if (!root.hasChildren()) {
            root = null;
        } else {
            Node lastAddedNode = root.getLastAddedNode();
            lastAddedNode.replace(root);
        }

        return Optional.of(extractedInteger);
    }

    public void insert(int integer) {
        if (root == null) {
            root = new Node(integer);
        } else {
            root.insert(integer);
        }
    }

    private static class Node {
        private int integer;
        private Node parent;
        private Node leftChild;
        private Node rightChild;

        public Node(int integer) {
            this.integer = integer;
        }

        public Node(int integer, Node parent) {
            this.integer = integer;
            this.parent = parent;
        }

        public void insert(int integer) {
            if (leftChild == null) {
                leftChild = new Node(integer, this);
                leftChild.siftUp();
            } else {
                rightChild = new Node(integer, this);
                rightChild.siftUp();
            }
        }

        private void siftUp() {
            if (parent.integer > integer) {
                swapIntegers(parent, this);
            }

            if (!parent.isRoot()) {
                parent.siftUp();
            }
        }

        public Node getLastAddedNode() {
            return (rightChild == null)
                    ? leftChild
                    : rightChild;
        }

        public boolean hasChildren() {
            return leftChild != null || rightChild != null;
        }

        public void replace(Node otherNode) {
            if (parent.leftChild.equals(this)) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }

            otherNode.integer = integer;
            otherNode.siftDown();
        }

        private void siftDown() {
            if (!hasChildren()) {
                return;
            }

            Node smallestChild = getSmallestChild();
            if (smallestChild.integer < integer) {
                swapIntegers(smallestChild, this);
                smallestChild.siftDown();
            }
        }

        private Node getSmallestChild() {
            if (leftChild != null && rightChild != null) {
                return (leftChild.integer < rightChild.integer)
                        ? leftChild
                        : rightChild;
            }

            if (leftChild != null) {
                return leftChild;
            }

            return rightChild;
        }

        private void swapIntegers(Node node, Node otherNode) {
            int temp = node.integer;
            node.integer = otherNode.integer;
            otherNode.integer = temp;
        }

        private boolean isRoot() {
            return parent == null;
        }
    }
}
