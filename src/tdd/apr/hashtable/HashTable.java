package tdd.apr.hashtable;

import java.util.Optional;

public class HashTable<K, V> {
    private Object[] values = new Object[10];

    public Optional<V> valueOf(String key) {
        int valueIndex = key.hashCode() % values.length;
        return (values[valueIndex] == null)
                ? Optional.empty()
                : Optional.of((V) values[valueIndex]);
    }

    public void add(K key, V value) {
        int valueIndex = key.hashCode() % values.length;
        values[valueIndex] = value;
    }
}
