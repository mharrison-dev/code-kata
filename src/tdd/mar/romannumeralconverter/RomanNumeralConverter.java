package tdd.mar.romannumeralconverter;

public class RomanNumeralConverter {
    private static final int NUMBER_OF_NUMERAL_LETTERS = 3;
    private static final int[] NUMERAL_LETTER_VALUES = {10, 5, 1};
    private static final String[] NUMERAL_LETTERS = {"X", "V", "I"};

    public String convertToRomanNumeral(int number) {
        StringBuilder romanNumeralBuilder = new StringBuilder();
        int difference = number;
        while (difference > 0) {
            for (int i = 0; i < NUMBER_OF_NUMERAL_LETTERS; i++) {
                int currentNumeralLetterValue = NUMERAL_LETTER_VALUES[i];
                if (difference >= currentNumeralLetterValue) {
                    difference -= currentNumeralLetterValue;
                    String currentNumeralLetter = NUMERAL_LETTERS[i];
                    romanNumeralBuilder.append(currentNumeralLetter);
                }
            }

            int indexOfMalformedNumeral = romanNumeralBuilder.indexOf("IIII");
            if (indexOfMalformedNumeral > -1) {
                romanNumeralBuilder.delete(indexOfMalformedNumeral, romanNumeralBuilder.length());
                romanNumeralBuilder.append("IV");
            }

            int indexOfOtherMalformedNumeral = romanNumeralBuilder.indexOf("VIV");
            if (indexOfOtherMalformedNumeral > -1) {
                romanNumeralBuilder.delete(indexOfOtherMalformedNumeral, romanNumeralBuilder.length());
                romanNumeralBuilder.append("IX");
            }
        }

        return romanNumeralBuilder.toString();
    }
}
