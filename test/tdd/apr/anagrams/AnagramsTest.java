package tdd.apr.anagrams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramsTest {
    private Anagrams anagrams = null;

    @BeforeEach
    public void setUp() {
        anagrams = new Anagrams();
    }

    @Test
    public void shouldReturnEmptyString_whenGivenEmptyWordList() {
        String words = "";

        String expectedAnagrams = "";
        String actualAnagrams = anagrams.findAnagrams(words);
        assertEquals(expectedAnagrams, actualAnagrams);
    }

    @Test
    public void shouldReturnStringWithTwoWords_whenGivenWordListWithTwoAnagrams() {
        String words = """
                ab
                ba""";

        String expectedAnagrams = "ab ba";
        String actualAnagrams = anagrams.findAnagrams(words);
        assertEquals(expectedAnagrams, actualAnagrams);
    }

    @Test
    public void shouldReturnStringWithTwoWords_whenGivenWordListWithTwoAnagramsAndAnotherWord() {
        String words = """
                ab
                ba
                c""";

        String expectedAnagrams = "ab ba";
        String actualAnagrams = anagrams.findAnagrams(words);
        assertEquals(expectedAnagrams, actualAnagrams);
    }
}