package tdd.apr.alphabetcipher;

public class AlphabetCipher {
    public String encode(String message, String keyword) {
        if (message.isEmpty() || keyword.isEmpty()) {
            return "";
        }

        StringBuilder encodedMessageBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            int alphabetIndexOfMessageLetter = getAlphabetIndexOfChar(message.charAt(i));
            int alphabetIndexOfKeywordLetter = getAlphabetIndexOfChar(keyword.charAt(i % keyword.length()));
            int alphabetIndexOfSubstitutionLetter = getAlphabetIndexOfSubstitutionLetter(alphabetIndexOfMessageLetter, alphabetIndexOfKeywordLetter);
            char substitutionLetter = (char) getAsciiCodeOfAlphabetIndex(alphabetIndexOfSubstitutionLetter);
            encodedMessageBuilder.append(substitutionLetter);
        }

        return encodedMessageBuilder.toString();
    }

    private int getAlphabetIndexOfChar(char c) {
        int startingAsciiCodeOfLowercaseLetters = 97;
        if (c >= startingAsciiCodeOfLowercaseLetters) {
            return c - startingAsciiCodeOfLowercaseLetters;
        }

        int startingAsciiCodeOfUppercaseLetters = 65;
        return c - startingAsciiCodeOfUppercaseLetters;
    }

    private int getAlphabetIndexOfSubstitutionLetter(int alphabetIndexOfMessageLetter, int alphabetIndexOfKeywordLetter) {
        int sizeOfAlphabet = 26;
        return (alphabetIndexOfMessageLetter + alphabetIndexOfKeywordLetter) % sizeOfAlphabet;
    }

    private int getAsciiCodeOfAlphabetIndex(int alphabetIndex) {
        int startingAsciiCodeOfLowercaseLetters = 97;
        return alphabetIndex + startingAsciiCodeOfLowercaseLetters;
    }
}
