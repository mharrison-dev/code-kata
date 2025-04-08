package tdd.apr.wordchain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordChainTest {
    @Test
    void shouldReturnEmptyString_whenFirstWordAndLastWordAreNotConnected() {
        String firstWord = "egg";
        String lastWord = "jar";
        String dictionary = "egg, jar, cup";
        WordChain wordChain = new WordChain();

        String expectedWordChain = "";
        String actualWordChain = wordChain.getChain(firstWord, lastWord);
        assertEquals(expectedWordChain, actualWordChain);
    }
}