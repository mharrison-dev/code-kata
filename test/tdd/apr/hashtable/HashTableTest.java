package tdd.apr.hashtable;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    @Test
    void shouldReturnEmptyOptional_forValueOf_whenKeyDoesNotExist() {
        HashTable<String, String> hashTable = new HashTable<>();

        Optional<String> expectedValue = Optional.empty();
        Optional<String> actualValue = hashTable.valueOf("foo");
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void shouldReturnValue_forValueOf_whenKeyDoesExist() {
        String key = "foo";
        int value = 600;
        HashTable<String, Integer> hashTable = new HashTable<>();

        hashTable.add(key, value);

        Optional<Integer> expectedValue = Optional.of(600);
        Optional<Integer> actualValue = hashTable.valueOf("foo");
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void shouldReturnUniqueValue_forValueOf_whenHashTableHasMultipleEntries() {
        String key = "foo";
        int value = 600;
        String otherKey = "goo";
        int otherValue = 700;
        HashTable<String, Integer> hashTable = new HashTable<>();

        hashTable.add(key, value);
        hashTable.add(otherKey, otherValue);

        Optional<Integer> expectedValue = Optional.of(600);
        Optional<Integer> actualValue = hashTable.valueOf("foo");
        assertEquals(expectedValue, actualValue);
    }
}