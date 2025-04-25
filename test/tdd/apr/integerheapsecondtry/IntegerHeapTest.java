package tdd.apr.integerheapsecondtry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class IntegerHeapTest {
    private IntegerHeap integerHeap;

    @BeforeEach
    void setUp() {
        integerHeap = new IntegerHeap();
    }

    @Test
    void extract_emptyHeap_returnsEmptyOptional() {
        Optional<Integer> expectedInteger = Optional.empty();
        Optional<Integer> actualInteger = integerHeap.extract();
        assertEquals(expectedInteger, actualInteger);
    }

    @Test
    void insert_emptyHeap() {
        int firstInteger = 1;

        integerHeap.insert(firstInteger);

        Optional<Integer> expectedInteger = Optional.of(firstInteger);
        Optional<Integer> actualInteger = integerHeap.extract();
        assertEquals(expectedInteger, actualInteger);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2", "2,1"})
    void extract_heapWithTwoIntegers_returnsSmallestInteger(String integers) {
        int[] integerArray = Arrays.stream(integers.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int firstInteger = integerArray[0];
        int secondInteger = integerArray[1];
        int smallestInteger = Math.min(firstInteger, secondInteger);

        integerHeap.insert(firstInteger);
        integerHeap.insert(secondInteger);

        Optional<Integer> expectedInteger = Optional.of(smallestInteger);
        Optional<Integer> actualInteger = integerHeap.extract();
        assertEquals(expectedInteger, actualInteger);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2", "2,1"})
    void extract_heapWithTwoIntegers_returnsLargestIntegerForSecondExtraction(String integers) {
        int[] integerArray = Arrays.stream(integers.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int firstInteger = integerArray[0];
        int secondInteger = integerArray[1];
        int largestInteger = Math.max(firstInteger, secondInteger);

        integerHeap.insert(firstInteger);
        integerHeap.insert(secondInteger);
        integerHeap.extract();

        Optional<Integer> expectedInteger = Optional.of(largestInteger);
        Optional<Integer> actualInteger = integerHeap.extract();
        assertEquals(expectedInteger, actualInteger);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2,3,1", "3,2,1"})
    void extract_heapWithThreeIntegers_returnsSmallestInteger(String integers) {
        int[] integerArray = Arrays.stream(integers.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int firstInteger = integerArray[0];
        int secondInteger = integerArray[1];
        int thirdInteger = integerArray[2];
        int smallestInteger = Math.min(firstInteger, Math.min(secondInteger, thirdInteger));

        integerHeap.insert(firstInteger);
        integerHeap.insert(secondInteger);
        integerHeap.insert(thirdInteger);

        Optional<Integer> expectedInteger = Optional.of(smallestInteger);
        Optional<Integer> actualInteger = integerHeap.extract();
        assertEquals(expectedInteger, actualInteger);
    }

    @Test
    void extract_heapWithThreeIntegers_returnsSecondSmallestIntegerForSecondExtraction() {
        int firstInteger = 1;
        int secondInteger = 3;
        int thirdInteger = 2;

        integerHeap.insert(firstInteger);
        integerHeap.insert(secondInteger);
        integerHeap.insert(thirdInteger);
        integerHeap.extract();

        Optional<Integer> expectedInteger = Optional.of(thirdInteger);
        Optional<Integer> actualInteger = integerHeap.extract();
        assertEquals(expectedInteger, actualInteger);
    }
}