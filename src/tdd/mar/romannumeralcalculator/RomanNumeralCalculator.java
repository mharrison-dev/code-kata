package tdd.mar.romannumeralcalculator;

public class RomanNumeralCalculator {
    private static final char[] orderedLettersFromGreatestToLeast = {'D', 'C', 'L', 'X', 'V', 'I'};
    private static final String[] letterGroupA = {"M", "C", "X", "I"};
    private static final String[] letterGroupB = {"D", "L", "V"};

    public String add(String numeral, String otherNumeral) {
        String unformattedSum = combine(numeral, otherNumeral);
        String sumWithoutExcessiveLetterDuplicates = removeExcessiveLetterDuplicates(unformattedSum);
        return removeLetterSandwich(sumWithoutExcessiveLetterDuplicates);
    }

    private String combine(String numeral, String otherNumeral) {
        StringBuilder numeralBuilder = new StringBuilder();
        int numeralIndex = 0;
        int otherNumeralIndex = 0;

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
        String numeralWithoutLetterGroupARepeats = removeExcessiveLetterDuplicatesForLetterGroupA(numeral);
        String numeralWithoutLetterGroupAAndGroupBRepeats = removeExcessiveLetterDuplicatesForLetterGroupB(numeralWithoutLetterGroupARepeats);
        return numeralWithoutLetterGroupAAndGroupBRepeats;
    }

    private String removeExcessiveLetterDuplicatesForLetterGroupA(String numeral) {
        String editedNumeral = numeral;

        for (int i = 1; i < letterGroupA.length; i++) {
            String currentLetter = letterGroupA[i];
            String precedingLetter = letterGroupB[i - 1];
            String wrongNotation = currentLetter.repeat(4);
            String properNotation = currentLetter + precedingLetter;
            editedNumeral = editedNumeral.replace(wrongNotation, properNotation);
        }

        return editedNumeral;
    }

    private String removeExcessiveLetterDuplicatesForLetterGroupB(String numeral) {
        String editedNumeral = numeral;

        for (int i = 0; i < letterGroupB.length; i++) {
            String currentLetter = letterGroupB[i];
            String precedingLetter = letterGroupA[i];
            String wrongNotation = currentLetter.repeat(2);
            String properNotation = precedingLetter;
            editedNumeral = editedNumeral.replace(wrongNotation, properNotation);
        }

        return editedNumeral;
    }

    private String removeLetterSandwich(String numeral) {
        String editedNumeral = numeral;

        for (int i = 1; i < orderedLettersFromGreatestToLeast.length; i++) {
            String currentLetter = "" + orderedLettersFromGreatestToLeast[i];
            String precedingLetter = "" + orderedLettersFromGreatestToLeast[i - 1];
            String wrongNotation = currentLetter + precedingLetter + currentLetter;
            String properNotation = precedingLetter;
            editedNumeral = editedNumeral.replace(wrongNotation, properNotation);
        }

        return editedNumeral;
    }
}