package tdd.apr.alphabetcipher;

public class AlphabetCipher {
    public String encode(String message, String keyword) {
        if (keyword.isEmpty()) {
            return "";
        }

        StringBuilder encodedMessageBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            int alphabetIndexOfMessageLetter = getAlphabetIndexOfChar(message.charAt(i));
            int alphabetIndexOfKeywordLetter = getAlphabetIndexOfChar(keyword.charAt(i % keyword.length()));
            int alphabetIndexOfEncodedLetter = getAlphabetIndexOfEncodedLetter(alphabetIndexOfMessageLetter, alphabetIndexOfKeywordLetter);
            char encodedLetter = (char) getAsciiCodeOfAlphabetIndex(alphabetIndexOfEncodedLetter);
            encodedMessageBuilder.append(encodedLetter);
        }

        return encodedMessageBuilder.toString();
    }

    public String decode(String message, String keyword) {
        if (keyword.isEmpty()) {
            return "";
        }

        StringBuilder decodedMessageBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            int alphabetIndexOfMessageLetter = getAlphabetIndexOfChar(message.charAt(i));
            int alphabetIndexOfKeywordLetter = getAlphabetIndexOfChar(keyword.charAt(i % keyword.length()));
            int alphabetIndexOfDecodedLetter = getAlphabetIndexOfDecodedLetter(alphabetIndexOfMessageLetter, alphabetIndexOfKeywordLetter);
            char decodedLetter = (char) getAsciiCodeOfAlphabetIndex(alphabetIndexOfDecodedLetter);
            decodedMessageBuilder.append(decodedLetter);
        }

        return decodedMessageBuilder.toString();
    }

    private int getAlphabetIndexOfChar(char c) {
        int startingAsciiCodeOfLowercaseLetters = 97;
        if (c >= startingAsciiCodeOfLowercaseLetters) {
            return c - startingAsciiCodeOfLowercaseLetters;
        }

        int startingAsciiCodeOfUppercaseLetters = 65;
        return c - startingAsciiCodeOfUppercaseLetters;
    }

    private int getAlphabetIndexOfEncodedLetter(int alphabetIndexOfMessageLetter, int alphabetIndexOfKeywordLetter) {
        int sizeOfAlphabet = 26;
        return (alphabetIndexOfMessageLetter + alphabetIndexOfKeywordLetter) % sizeOfAlphabet;
    }

    private int getAlphabetIndexOfDecodedLetter(int alphabetIndexOfMessageLetter, int alphabetIndexOfKeywordLetter) {
        int sizeOfAlphabet = 26;
        return Math.floorMod(alphabetIndexOfMessageLetter - alphabetIndexOfKeywordLetter, sizeOfAlphabet);
    }

    private int getAsciiCodeOfAlphabetIndex(int alphabetIndex) {
        int startingAsciiCodeOfLowercaseLetters = 97;
        return alphabetIndex + startingAsciiCodeOfLowercaseLetters;
    }
}
