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

        wordChain.setDictionary(dictionary);

        String expectedWordChain = "";
        String actualWordChain = wordChain.getChain(firstWord, lastWord);
        assertEquals(expectedWordChain, actualWordChain);
    }

    @Test
    void shouldReturnStringWithThreeWords_whenFirstWordAndLastWordArConnectedByOneWord() {
        String firstWord = "tap";
        String lastWord = "cup";
        String dictionary = "tap, cap, cup";
        WordChain wordChain = new WordChain();

        wordChain.setDictionary(dictionary);

        String expectedWordChain = "tap > cap > cup";
        String actualWordChain = wordChain.getChain(firstWord, lastWord);
        assertEquals(expectedWordChain, actualWordChain);
    }
}