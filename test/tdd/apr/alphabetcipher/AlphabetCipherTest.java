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

        String expectedEncodedMessage = "";
        String actualEncodedMessage = alphabetCipher.encode(message, keyword);
        assertEquals(expectedEncodedMessage, actualEncodedMessage);
    }

    @Test
    void encode_messageWithEmptyKeyword_returnsEmptyString() {
        String message = "a";
        String keyword = "";

        String expectedEncodedMessage = "";
        String actualEncodedMessage = alphabetCipher.encode(message, keyword);
        assertEquals(expectedEncodedMessage, actualEncodedMessage);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b", "l,m", "x,y", "z,a"})
    void encode_singleLetterMessageWithSingleLetterKeyword_returnsCorrespondingLetter(String messageAndEncodedMessage) {
        String[] messageAndEncodedMessageArray = messageAndEncodedMessage.split(",");
        String message = messageAndEncodedMessageArray[0];
        String keyword = "b";

        String expectedEncodedMessage = messageAndEncodedMessageArray[1];
        String actualEncodedMessage = alphabetCipher.encode(message, keyword);
        assertEquals(expectedEncodedMessage, actualEncodedMessage);
    }

    @Test
    void encode_twoLetterMessageWithTwoLetterKeyword_returnsEncodedMessage() {
        String message = "to";
        String keyword = "az";

        String expectedEncodedMessage = "tn";
        String actualEncodedMessage = alphabetCipher.encode(message, keyword);
        assertEquals(expectedEncodedMessage, actualEncodedMessage);
    }

    @Test
    void encode_threeLetterMessageWithTwoLetterKeyword_returnsEncodedMessage() {
        String message = "tar";
        String keyword = "az";

        String expectedEncodedMessage = "tzr";
        String actualEncodedMessage = alphabetCipher.encode(message, keyword);
        assertEquals(expectedEncodedMessage, actualEncodedMessage);
    }

    @Test
    void encode_messageWithUppercaseLetters_returnsLowercasedEncodedMessage() {
        String message = "TAR";
        String keyword = "az";

        String expectedEncodedMessage = "tzr";
        String actualEncodedMessage = alphabetCipher.encode(message, keyword);
        assertEquals(expectedEncodedMessage, actualEncodedMessage);
    }
}