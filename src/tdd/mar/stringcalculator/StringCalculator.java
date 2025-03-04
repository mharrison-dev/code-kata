package tdd.mar.stringcalculator;

public class StringCalculator {
    public int add(String numberString) {
        return (numberString.isEmpty())
                ? 0
                : Integer.parseInt(numberString);
    }
}
