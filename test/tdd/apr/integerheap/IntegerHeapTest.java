package tdd.apr.integerheap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class IntegerHeapTest {
    private IntegerHeap integerHeap = null;

    @BeforeEach
    void setUp() {
        integerHeap = new IntegerHeap();
    }

    @Test
    void shouldGetZero_forSizeOfHeap_whenHeapIsEmpty() {
        int expectedSize = 0;
        int actualSize = integerHeap.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void shouldGetZero_forSizeOfHeap_whenLastIntegerHasBeenRemoved() {
        integerHeap.insert(3);
        integerHeap.extractRootNode();

        int expectedSize = 0;
        int actualSize = integerHeap.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void shouldGetZero_forSizeOfHeap_whenExtractionIsPerformedOnEmptyHeap() {
        integerHeap.extractRootNode();

        int expectedSize = 0;
        int actualSize = integerHeap.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void shouldGetOne_forSizeOfHeap_whenHeapHasOneInteger() {
        integerHeap.insert(3);

        int expectedSize = 1;
        int actualSize = integerHeap.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void shouldGetEmptyOptional_whenExtractingRootNode_whenHeapIsEmpty() {
        Optional<Integer> expectedInteger = Optional.empty();
        Optional<Integer> actualInteger = integerHeap.extractRootNode();
        assertEquals(expectedInteger, actualInteger);
    }

    @Test
    void shouldSetIntegerAsRootNode_whenInsertingInteger_whenHeapIsEmpty() {
        integerHeap.insert(5);

        Optional<Integer> expectedInteger = Optional.of(5);
        Optional<Integer> actualInteger = integerHeap.extractRootNode();
        assertEquals(expectedInteger, actualInteger);
    }

    @Test
    void shouldGetSecondInsertedInteger_whenExtractingTwice_whenSecondIntegerIsLargerThanFirstInteger() {
        integerHeap.insert(5);
        integerHeap.insert(10);
        integerHeap.extractRootNode();

        Optional<Integer> expectedInteger = Optional.of(10);
        Optional<Integer> actualInteger = integerHeap.extractRootNode();
        assertEquals(expectedInteger, actualInteger);
    }

    @Test
    void shouldGetFirstInsertedInteger_whenExtractingTwice_whenSecondIntegerIsLessThanFirstInteger() {
        integerHeap.insert(5);
        integerHeap.insert(2);
        integerHeap.extractRootNode();

        Optional<Integer> expectedInteger = Optional.of(5);
        Optional<Integer> actualInteger = integerHeap.extractRootNode();
        assertEquals(expectedInteger, actualInteger);
    }
}