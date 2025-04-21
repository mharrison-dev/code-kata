package tdd.apr.binarysearchtree;

import java.util.Optional;

public class BinarySearchTree<K, V> {
    private K key = null;

    public Optional<V> getAllValues() {
        return Optional.empty();
    }

    public Optional<K> getAllKeys() {
        return (key == null)
                ? Optional.empty()
                : Optional.of(key);
    }

    public void insert(K key, V value) {
        this.key = key;
    }
}
