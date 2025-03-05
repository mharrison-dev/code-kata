package tdd.mar.romannumeralconverter;

public class RomanNumeralConverter {
    private static final int NUMBER_OF_NUMERAL_LETTERS = 7;
    private static final int[] NUMERAL_LETTER_VALUES = {1000, 500, 100, 50, 10, 5, 1};
    private static final String[] NUMERAL_LETTERS = {"M", "D", "C", "L", "X", "V", "I"};

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

            if (i >= 2) {
                String previousLetterSandwich = NUMERAL_LETTERS[i - 1] + NUMERAL_LETTERS[i] + NUMERAL_LETTERS[i - 1];
                int indexOfPreviousLetterSandwich = romanNumeralBuilder.indexOf(previousLetterSandwich);
                if (indexOfPreviousLetterSandwich > -1) {
                    romanNumeralBuilder.delete(indexOfPreviousLetterSandwich, romanNumeralBuilder.length());
                    String correctNumeralRepresentation = NUMERAL_LETTERS[i] + NUMERAL_LETTERS[i - 2];
                    romanNumeralBuilder.append(correctNumeralRepresentation);
                }
            }
        }

        return romanNumeralBuilder.toString();
    }
}
