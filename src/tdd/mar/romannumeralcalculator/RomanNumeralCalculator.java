package tdd.mar.romannumeralcalculator;

public class RomanNumeralCalculator {
    public String add(String numeral, String otherNumeral) {
        return removeExcessiveLetterDuplicates(numeral + otherNumeral);
    }

    private String removeExcessiveLetterDuplicates(String numeral) {
        return numeral.replace("IIII", "IV");
    }
}
