package tdd.apr.binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BinarySearchTree<K, V> {
    private final List<K> keyList = new ArrayList<>();
    private V value = null;

    public Optional<V> getAllValues() {
        return (value == null)
                ? Optional.empty()
                : Optional.of(value);
    }

    public Optional<List<K>> getAllKeys() {
        return (keyList.isEmpty())
                ? Optional.empty()
                : Optional.of(keyList);
    }

    public void insert(K key, V value) {
        keyList.add(key);
        this.value = value;
    }
}
