package tdd.apr.hashtable;

import java.util.Optional;

public class HashTable<K, V> {
    private V value = null;

    public Optional<V> valueOf(String key) {
        return (value == null)
                ? Optional.empty()
                : Optional.of(value);
    }

    public void add(K key, V value) {
        this.value = value;
    }
}
