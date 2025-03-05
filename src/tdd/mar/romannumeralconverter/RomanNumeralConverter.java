package tdd.mar.romannumeralconverter;

public class RomanNumeralConverter {
    private static final int NUMBER_OF_NUMERAL_LETTERS = 4;
    private static final int[] NUMERAL_LETTER_VALUES = {50, 10, 5, 1};
    private static final String[] NUMERAL_LETTERS = {"L", "X", "V", "I"};

    public String convertToRomanNumeral(int number) {
        StringBuilder romanNumeralBuilder = new StringBuilder();
        int difference = number;
        for (int i = 0; i < NUMBER_OF_NUMERAL_LETTERS; i++) {
            int currentNumeralLetterValue = NUMERAL_LETTER_VALUES[i];
            while (difference >= currentNumeralLetterValue) {
                difference -= currentNumeralLetterValue;
                String currentNumeralLetter = NUMERAL_LETTERS[i];
                romanNumeralBuilder.append(currentNumeralLetter);
            }

            String fourOccurrencesOfCurrentLetter = new StringBuilder().repeat(NUMERAL_LETTERS[i], 4).toString();
            int indexOfFourOccurrencesOfCurrentLetter = romanNumeralBuilder.indexOf(fourOccurrencesOfCurrentLetter);
            if (indexOfFourOccurrencesOfCurrentLetter > -1) {
                romanNumeralBuilder.delete(indexOfFourOccurrencesOfCurrentLetter, romanNumeralBuilder.length());
                String correctNumeralRepresentation = NUMERAL_LETTERS[i] + NUMERAL_LETTERS[i - 1];
                romanNumeralBuilder.append(correctNumeralRepresentation);
            }
        }

        int indexOfOtherMalformedNumeral = romanNumeralBuilder.indexOf("VIV");
        if (indexOfOtherMalformedNumeral > -1) {
            romanNumeralBuilder.delete(indexOfOtherMalformedNumeral, romanNumeralBuilder.length());
            romanNumeralBuilder.append("IX");
        }

        return romanNumeralBuilder.toString();
    }
}
