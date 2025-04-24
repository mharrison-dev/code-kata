package tdd.apr.integerheap;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class IntegerHeapTest {
    @Test
    void shouldGetZero_forSizeOfHeap_whenHeapIsEmpty() {
        IntegerHeap integerHeap = new IntegerHeap();

        int expectedSize = 0;
        int actualSize = integerHeap.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void shouldGetEmptyOptional_whenExtractingRootNode_whenHeapIsEmpty() {
        IntegerHeap integerHeap = new IntegerHeap();

        Optional<Integer> expectedInteger = Optional.empty();
        Optional<Integer> actualInteger = integerHeap.extractRootNode();
        assertEquals(expectedInteger, actualInteger);
    }
}