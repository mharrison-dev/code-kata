package tdd.apr.hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    private HashTable<String, Integer> hashTable = null;

    @BeforeEach
    void setUp() {
        hashTable = new HashTable<>();
    }

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

        hashTable.add(key, value);
        hashTable.add(otherKey, otherValue);

        Optional<Integer> expectedValue = Optional.of(600);
        Optional<Integer> actualValue = hashTable.valueOf("foo");
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void shouldReturnEmptyOptional_forValueOf_whenEntryHasBeenDeleted() {
        String key = "foo";
        int value = 600;

        hashTable.add(key, value);
        hashTable.delete(key);

        Optional<Integer> expectedValue = Optional.empty();
        Optional<Integer> actualValue = hashTable.valueOf("foo");
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void shouldReturnUniqueValue_forValueOf_whenHashCollisionsOccur() {
        class HashCollisionKeyStub {
            private final String value;

            public HashCollisionKeyStub(String value) {
                this.value = value;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public boolean equals(Object o) {
                if (o == null || getClass() != o.getClass()) return false;
                HashCollisionKeyStub that = (HashCollisionKeyStub) o;
                return Objects.equals(value, that.value);
            }
        }
        HashCollisionKeyStub key = new HashCollisionKeyStub("foo");
        int value = 600;
        HashCollisionKeyStub otherKey = new HashCollisionKeyStub("goo");
        int otherVale = 700;
        HashTable<HashCollisionKeyStub, Integer> hashTable = new HashTable<>();

        hashTable.add(key, value);
        hashTable.add(otherKey, otherVale);

        Optional<Integer> expectedValue = Optional.of(600);
        Optional<Integer> actualValue = hashTable.valueOf(key);
        assertEquals(expectedValue, actualValue);
    }
}