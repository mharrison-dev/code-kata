package tdd.apr.integerheapsecondtry;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class IntegerHeapTest {
    @Test
    void extract_emptyHeap_returnsEmptyOptional() {
        IntegerHeap integerHeap = new IntegerHeap();

        Optional<Integer> expectedInteger = Optional.empty();
        Optional<Integer> actualInteger = integerHeap.extract();
        assertEquals(expectedInteger, actualInteger);
    }
}