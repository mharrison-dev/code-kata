package tdd.apr.baseconversion;

public class BaseConversion {
    private static final char[] LEGAL_CHARACTERS = getAllLegalCharacters();

    private static char[] getAllLegalCharacters() {
        char[] legalCharacters = new char[36];

        int asciiForNumberZero = 48;
        for (int i = 0; i < 10; i++) {
            legalCharacters[i] = (char) (asciiForNumberZero + i);
        }

        int asciiForCapitalA = 65;
        for (int i = 10; i < legalCharacters.length; i++) {
            legalCharacters[i] = (char) (asciiForCapitalA - 10 + i);
        }

        return legalCharacters;
    }

    public String convert(String value, int initialBase, int finalBase) throws RuntimeException {
        if (exceedsRangeOfInitialBase(value, initialBase)) {
            throw new IllegalArgumentException("Cannot convert value(" + value + ") because it exceeds the range of the initial base(" + initialBase + ").");
        }

        if (containsIllegalCharacters(value)) {
            throw new IllegalArgumentException("Values can only have characters from the character sets 0-9 or A-Z.");
        }

        return value;
    }

    private boolean exceedsRangeOfInitialBase(String value, int initialBase) {
        char[] valueCharacters = value.toCharArray();
        char largestCharacterForInitialBase = LEGAL_CHARACTERS[initialBase - 1];
        for (char c : valueCharacters) {
            if (c >= largestCharacterForInitialBase) {
                return true;
            }
        }

        return false;
    }

    private boolean containsIllegalCharacters(String value) {
        return !value.matches("[0-9A-Z]*");
    }
}
