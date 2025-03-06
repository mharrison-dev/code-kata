package tdd.mar.romannumeralcalculator;

public class RomanNumeralCalculator {
    public String add(String numeral, String otherNumeral) {
        String sumWithoutExcessiveLetterDuplicates = removeExcessiveLetterDuplicates(numeral + otherNumeral);
        return removeLetterSandwich(sumWithoutExcessiveLetterDuplicates);
    }

    private String removeExcessiveLetterDuplicates(String numeral) {
        return numeral.replace("IIII", "IV");
    }

    private String removeLetterSandwich(String numeral) {
        return numeral.replace("IVI", "V");
    }
}
