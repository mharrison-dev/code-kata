package tdd.mar.primefactorization;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeFactorizationTest {
    private PrimeFactorization primeFactorization = null;

    @BeforeEach
    public void setUp() {
        primeFactorization = new PrimeFactorization();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    public void shouldReturnEmptyList_whenGivenNumberLessThanTwo(int number) {
        List<Integer> primeFactors = primeFactorization.of(number);
        assertTrue(primeFactors.isEmpty());
    }

    @Test
    public void shouldReturnListOfTwo_whenGivenTwo() {
        int number = 2;

        List<Integer> expectedPrimeFactors = List.of(2);
        List<Integer> actualPrimeFactors = primeFactorization.of(number);
        assertEquals(expectedPrimeFactors.size(), actualPrimeFactors.size());
        assertTrue(expectedPrimeFactors.containsAll(actualPrimeFactors));
    }

    @Test
    public void shouldReturnListOfTwoAndTwo_whenGivenFour() {
        int number = 4;

        List<Integer> expectedPrimeFactors = List.of(2, 2);
        List<Integer> actualPrimeFactors = primeFactorization.of(number);
        assertEquals(expectedPrimeFactors.size(), actualPrimeFactors.size());
        assertTrue(expectedPrimeFactors.containsAll(actualPrimeFactors));
    }

    @Test
    public void shouldReturnListOfFive_whenGivenFive() {
        int number = 5;

        List<Integer> expectedPrimeFactors = List.of(5);
        List<Integer> actualPrimeFactors = primeFactorization.of(number);
        assertEquals(expectedPrimeFactors.size(), actualPrimeFactors.size());
        assertTrue(expectedPrimeFactors.containsAll(actualPrimeFactors));
    }

    @Test
    public void shouldReturnListOfTwoAndThree_whenGivenSix() {
        int number = 6;

        List<Integer> expectedPrimeFactors = List.of(2, 3);
        List<Integer> actualPrimeFactors = primeFactorization.of(number);
        assertEquals(expectedPrimeFactors.size(), actualPrimeFactors.size());
        assertTrue(expectedPrimeFactors.containsAll(actualPrimeFactors));
    }
}