package tdd.apr.wordchain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordChainTest {
    private WordChain wordChain = null;

    @BeforeEach
    void setUp() {
        wordChain = new WordChain();
    }

    @Test
    void shouldReturnEmptyString_whenFirstWordAndLastWordAreNotConnected() {
        String firstWord = "egg";
        String lastWord = "jar";
        String dictionary = "egg, jar, cup";

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

        wordChain.setDictionary(dictionary);

        String expectedWordChain = "tap > cap > cup";
        String actualWordChain = wordChain.getChain(firstWord, lastWord);
        assertEquals(expectedWordChain, actualWordChain);
    }

    @Test
    void shouldReturnEmptyString_whenLastWordIsNotInDictionary() {
        String firstWord = "tap";
        String lastWord = "cup";
        String dictionary = "tap, cap";

        wordChain.setDictionary(dictionary);

        String expectedWordChain = "";
        String actualWordChain = wordChain.getChain(firstWord, lastWord);
        assertEquals(expectedWordChain, actualWordChain);
    }

    @Test
    void shouldReturnEmptyString_whenFirstWordIsNotInDictionary() {
        String firstWord = "tap";
        String lastWord = "cup";
        String dictionary = "cap, cup";

        wordChain.setDictionary(dictionary);

        String expectedWordChain = "";
        String actualWordChain = wordChain.getChain(firstWord, lastWord);
        assertEquals(expectedWordChain, actualWordChain);
    }

    @Test
    void shouldReturnEmptyString_whenEachWordInChainIsNotOneHammingDistanceFromItsNeighbours() {
        String firstWord = "tap";
        String lastWord = "dog";
        String dictionary = "tap, cap, dog";

        wordChain.setDictionary(dictionary);

        String expectedWordChain = "";
        String actualWordChain = wordChain.getChain(firstWord, lastWord);
        assertEquals(expectedWordChain, actualWordChain);
    }

    @Test
    void shouldReturnStringWithFourWords_whenFirstWordAndLastWordArConnectedByTwoWords() {
        String firstWord = "tip";
        String lastWord = "cup";
        String dictionary = "tip, tap, cap, cup";

        wordChain.setDictionary(dictionary);

        String expectedWordChain = "tip > tap > cap > cup";
        String actualWordChain = wordChain.getChain(firstWord, lastWord);
        assertEquals(expectedWordChain, actualWordChain);
    }
}