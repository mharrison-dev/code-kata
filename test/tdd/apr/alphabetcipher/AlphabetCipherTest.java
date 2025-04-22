package tdd.apr.alphabetcipher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlphabetCipherTest {
    @Test
    void encode_emptyString_returnsEmptyString() {
        AlphabetCipher alphabetCipher = new AlphabetCipher();

        String expectedString = "";
        String actualString = alphabetCipher.encode("");
        assertEquals(expectedString, actualString);
    }
}