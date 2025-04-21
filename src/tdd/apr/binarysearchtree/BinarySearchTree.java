package tdd.apr.binarysearchtree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BinarySearchTree<K, V> {
    private Node root = null;
    private final Comparator<K> keyComparator;

    public BinarySearchTree(Comparator<K> keyComparator) {
        this.keyComparator = keyComparator;
    }

    public Optional<List<V>> getAllValues() {
        return (root == null)
                ? Optional.empty()
                : Optional.of(root.getAllValues());
    }

    public Optional<List<K>> getAllKeys() {
        return (root == null)
                ? Optional.empty()
                : Optional.of(root.getAllKeys());
    }

    public void insert(K key, V value) {
        if (root == null) {
            root = new Node(key, value);
        } else {
            root.insert(key, value);
        }
    }

    public Optional<V> find(K key) {
        return Optional.empty();
    }

    private class Node {
        private final K key;
        private final V value;
        private Node leftChild;
        private Node rightChild;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void insert(K key, V value) {
            switch (keyComparator.compare(key, this.key)) {
                case -1:
                    if (leftChild == null) {
                        leftChild = new Node(key, value);
                    } else {
                        leftChild.insert(key, value);
                    }
                    break;
                case 1:
                    if (rightChild == null) {
                        rightChild = new Node(key, value);
                    } else {
                        rightChild.insert(key, value);
                    }
                    break;
            }
        }

        public List<V> getAllValues() {
            List<V> allValues = new ArrayList<>();
            allValues.add(value);

            if (leftChild != null) {
                allValues.addAll(leftChild.getAllValues());
            }

            if (rightChild != null) {
                allValues.addAll(rightChild.getAllValues());
            }

            return allValues;
        }

        public List<K> getAllKeys() {
            List<K> allKeys = new ArrayList<>();
            allKeys.add(key);

            if (leftChild != null) {
                allKeys.addAll(leftChild.getAllKeys());
            }

            if (rightChild != null) {
                allKeys.addAll(rightChild.getAllKeys());
            }

            return allKeys;
        }
    }
}
