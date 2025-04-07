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

    @Test
    public void shouldReturnStringWithTwoWords_whenGivenWordListWithTwoAnagramsAndAnotherWordOfSameLength() {
        String words = """
                ab
                ba
                ca""";

        String expectedAnagrams = "ab ba";
        String actualAnagrams = anagrams.findAnagrams(words);
        assertEquals(expectedAnagrams, actualAnagrams);
    }

    @Test
    public void shouldReturnStringWithTwoWords_whenGivenWordListWithTwoAnagramsAndAnotherWordThatContainsSameLetters() {
        String words = """
                ab
                ba
                baa""";

        String expectedAnagrams = "ab ba";
        String actualAnagrams = anagrams.findAnagrams(words);
        assertEquals(expectedAnagrams, actualAnagrams);
    }

    @Test
    public void shouldReturnStringWithTwoWords_whenGivenWordListWithTwoAnagramsAndAnotherWordThatHasSameLengthButDifferentConcentrationOfLetters() {
        String words = """
                aab
                baa
                bba""";

        String expectedAnagrams = "aab baa";
        String actualAnagrams = anagrams.findAnagrams(words);
        assertEquals(expectedAnagrams, actualAnagrams);
    }

    @Test
    public void shouldReturnStringWithTwoWords_whenGivenWordListWithTwoAnagramsWithOneUppercasedWord() {
        String words = """
                Aab
                baa""";

        String expectedAnagrams = "Aab baa";
        String actualAnagrams = anagrams.findAnagrams(words);
        assertEquals(expectedAnagrams, actualAnagrams);
    }
}