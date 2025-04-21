package tdd.apr.binarysearchtree;

import java.util.Optional;

public class BinarySearchTree<K, V> {
    private K key = null;
    private V value = null;

    public Optional<V> getAllValues() {
        return (value == null)
                ? Optional.empty()
                : Optional.of(value);
    }

    public Optional<K> getAllKeys() {
        return (key == null)
                ? Optional.empty()
                : Optional.of(key);
    }

    public void insert(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
