package tdd.mar.romannumeralcalculator;

public class RomanNumeralCalculator {
    public String add(String numeral, String otherNumeral) {
        String unformattedSum = combine(numeral, otherNumeral);
        String sumWithoutExcessiveLetterDuplicates = removeExcessiveLetterDuplicates(unformattedSum);
        return removeLetterSandwich(sumWithoutExcessiveLetterDuplicates);
    }

    private String combine(String numeral, String otherNumeral) {
        StringBuilder numeralBuilder = new StringBuilder();
        int numeralIndex = 0;
        int otherNumeralIndex = 0;

        char[] orderedLettersFromGreatestToLeast = {'X', 'V', 'I'};
        for (char letter : orderedLettersFromGreatestToLeast) {
            while (numeralIndex < numeral.length() && numeral.charAt(numeralIndex) == letter) {
                numeralBuilder.append(letter);
                numeralIndex++;
            }

            while (otherNumeralIndex < otherNumeral.length() && otherNumeral.charAt(otherNumeralIndex) == letter) {
                numeralBuilder.append(letter);
                otherNumeralIndex++;
            }
        }

        return numeralBuilder.toString();
    }

    private String removeExcessiveLetterDuplicates(String numeral) {
        return numeral
                .replace("IIII", "IV")
                .replace("VV", "X");
    }

    private String removeLetterSandwich(String numeral) {
        return numeral.replace("IVI", "V");
    }
}
