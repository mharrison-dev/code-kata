package tdd.apr.alphabetcipher;

public class AlphabetCipher {
    public String encode(String message, String keyword) {
        if (message.isEmpty() || keyword.isEmpty()) {
            return "";
        }

        StringBuilder encodedMessageBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            int alphabetIndexOfMessageLetter = getAlphabetIndexOfChar(message.charAt(i));
            int alphabetIndexOfKeywordLetter = getAlphabetIndexOfChar(keyword.charAt(i));
            char substitutionLetter = getSubstitutionLetter(alphabetIndexOfMessageLetter, alphabetIndexOfKeywordLetter);
            encodedMessageBuilder.append(substitutionLetter);
        }

        return encodedMessageBuilder.toString();
    }

    private int getAlphabetIndexOfChar(char c) {
        int startingAsciiCodeOfLowercaseLetters = 97;
        return c - startingAsciiCodeOfLowercaseLetters;
    }

    private char getSubstitutionLetter(int index, int otherIndex) {
        int sizeOfAlphabet = 26;
        int alphabetIndexOfEncodedMessageLetter = (index + otherIndex) % sizeOfAlphabet;

        int startingAsciiCodeOfLowercaseLetters = 97;
        return (char) (alphabetIndexOfEncodedMessageLetter + startingAsciiCodeOfLowercaseLetters);
    }
}
