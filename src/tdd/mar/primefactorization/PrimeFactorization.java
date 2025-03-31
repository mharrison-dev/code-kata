package tdd.mar.primefactorization;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {
    public List<Integer> of(int number) {
        List<Integer> primeFactors = new ArrayList<>();
        if (number < 2) {
            return primeFactors;
        }

        int remainder = number;
        while (remainder % 2 == 0) {
            primeFactors.add(2);
            remainder /= 2;
        }

        return (primeFactors.isEmpty())
                ? List.of(number)
                : primeFactors;
    }
}
