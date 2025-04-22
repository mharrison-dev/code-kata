package tdd.apr.alphabetcipher;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class AlphabetCipherTest {
    private final AlphabetCipher alphabetCipher = new AlphabetCipher();

    @Test
    void encode_emptyMessageWithKeyword_returnsEmptyString() {
        String message = "";
        String keyword = "a";

        String expectedString = "";
        String actualString = alphabetCipher.encode(message, keyword);
        assertEquals(expectedString, actualString);
    }

    @Test
    void encode_messageWithEmptyKeyword_returnsEmptyString() {
        String message = "a";
        String keyword = "";

        String expectedString = "";
        String actualString = alphabetCipher.encode(message, keyword);
        assertEquals(expectedString, actualString);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b", "l,m", "x,y", "z,a"})
    void encode_singleLetterMessageWithSingleLetterKeyword_returnsCorrespondingLetter(String messageAndEncodedMessage) {
        String[] messageAndEncodedMessageArray = messageAndEncodedMessage.split(",");
        String message = messageAndEncodedMessageArray[0];
        String encodedMessage = messageAndEncodedMessageArray[1];
        String keyword = "b";

        String expectedString = encodedMessage;
        String actualString = alphabetCipher.encode(message, keyword);
        assertEquals(expectedString, actualString);
    }

    @Test
    void encode_twoLetterMessageWithTwoLetterKeyword_returnsEncodedMessage() {
        String message = "to";
        String keyword = "az";

        String expectedString = "tn";
        String actualString = alphabetCipher.encode(message, keyword);
        assertEquals(expectedString, actualString);
    }
}