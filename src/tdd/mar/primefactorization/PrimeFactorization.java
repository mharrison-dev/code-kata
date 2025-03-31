package tdd.mar.primefactorization;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {
    public List<Integer> of(int number) {
        List<Integer> primeFactors = new ArrayList<>();

        int remainder = number;
        int divisor = 2;
        while (divisor <= number) {
            while (remainder % divisor == 0) {
                primeFactors.add(divisor);
                remainder /= divisor;
            }
            divisor++;
        }

        return primeFactors;
    }
}
