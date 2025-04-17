package tdd.apr.hashtable;

import java.util.Optional;

public class HashTable<K, V> {
    private Object[] values = new Object[10];

    public Optional<V> valueOf(K key) {
        return (values[indexOf(key)] == null)
                ? Optional.empty()
                : Optional.of((V) values[indexOf(key)]);
    }

    public void add(K key, V value) {
        values[indexOf(key)] = value;
    }

    public void delete(K key) {
        values[indexOf(key)] = null;
    }

    private int indexOf(K key) {
        return key.hashCode() % values.length;
    }
}
