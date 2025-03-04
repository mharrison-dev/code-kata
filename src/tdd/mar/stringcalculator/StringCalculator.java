package tdd.mar.stringcalculator;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numberString) {
        return (numberString.isEmpty())
                ? 0
                : Arrays.stream(numberString.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
