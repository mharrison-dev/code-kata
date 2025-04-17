package tdd.apr.hashtable;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    @Test
    void shouldReturnEmptyOptional_forValueOf_whenKeyDoesNotExist() {
        HashTable<String> hashTable = new HashTable<>();

        Optional<String> expectedValue = Optional.empty();
        Optional<String> actualValue = hashTable.valueOf("foo");
        assertEquals(expectedValue, actualValue);
    }
}