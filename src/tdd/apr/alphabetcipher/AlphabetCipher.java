package tdd.apr.alphabetcipher;

public class AlphabetCipher {
    public String encode(String message, String keyword) {
        if (message.isEmpty() || keyword.isEmpty()) {
            return "";
        }

        int startingAsciiCodeOfLowercaseLetters = 97;
        int sizeOfAlphabet = 26;

        int alphabetIndexOfMessageLetter = message.charAt(0) - startingAsciiCodeOfLowercaseLetters;
        int alphabetIndexOfKeywordLetter = keyword.charAt(0) - startingAsciiCodeOfLowercaseLetters;
        int alphabetIndexOfEncodedMessageLetter = (alphabetIndexOfMessageLetter + alphabetIndexOfKeywordLetter) % sizeOfAlphabet;
        char encodedMessageLetter = (char) (alphabetIndexOfEncodedMessageLetter + startingAsciiCodeOfLowercaseLetters);
        return String.valueOf(encodedMessageLetter);
    }
}
