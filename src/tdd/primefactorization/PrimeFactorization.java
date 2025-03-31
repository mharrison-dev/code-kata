package tdd.primefactorization;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {
    public List<Integer> of(int number) {
        List<Integer> primeFactors = new ArrayList<>();
        if (number < 2) {
            return primeFactors;
        }

        primeFactors.add(number);
        return primeFactors;
    }
}
