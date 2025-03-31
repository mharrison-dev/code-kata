package tdd.primefactorization;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeFactorizationTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    public void shouldReturnEmptyList_whenGivenNumberLessThanTwo(int number) {
        PrimeFactorization primeFactorization = new PrimeFactorization();

        List<Integer> primeFactors = primeFactorization.of(number);
        assertTrue(primeFactors.isEmpty());
    }

    @Test
    public void shouldReturnListOfTwo_whenGivenTwo() {
        int number = 2;
        PrimeFactorization primeFactorization = new PrimeFactorization();

        List<Integer> expectedPrimeFactors = List.of(2);
        List<Integer> actualPrimeFactors = primeFactorization.of(number);
        assertEquals(expectedPrimeFactors.size(), actualPrimeFactors.size());
        assertTrue(expectedPrimeFactors.containsAll(actualPrimeFactors));
    }
}