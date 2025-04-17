package tdd.apr.hashtable;

import java.util.LinkedList;
import java.util.Optional;

public class HashTable<K, V> {
    private final LinkedList<KeyValuePair<K, V>>[] buckets = new LinkedList[10];

    public HashTable() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public Optional<V> valueOf(K key) {
        Optional<KeyValuePair<K, V>> keyValuePairOfKey = getKeyValuePairOf(key);
        return keyValuePairOfKey.map(kvKeyValuePair -> kvKeyValuePair.value);
    }

    public void add(K key, V value) {
        KeyValuePair<K, V> keyValuePair = new KeyValuePair<>(key, value);
        LinkedList<KeyValuePair<K, V>> keyValuePairLinkedList = buckets[indexOf(key)];
        keyValuePairLinkedList.add(keyValuePair);
    }

    public void delete(K key) {
        Optional<KeyValuePair<K, V>> keyValuePairOfKey = getKeyValuePairOf(key);
        if (keyValuePairOfKey.isPresent()) {
            LinkedList<KeyValuePair<K, V>> keyValuePairLinkedList = buckets[indexOf(key)];
            keyValuePairLinkedList.remove(keyValuePairOfKey.get());
        }
    }

    private int indexOf(K key) {
        return key.hashCode() % buckets.length;
    }

    private Optional<KeyValuePair<K, V>> getKeyValuePairOf(K key) {
        LinkedList<KeyValuePair<K, V>> keyValuePairLinkedList = buckets[indexOf(key)];
        return keyValuePairLinkedList.stream()
                .filter(keyValuePair -> keyValuePair.value != key)
                .findFirst();
    }

    private record KeyValuePair<K, V>(K key, V value) {

    }
}
