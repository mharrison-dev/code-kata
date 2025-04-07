package tdd.apr.anagrams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnagramsTest {
    @Test
    public void shouldReturnEmptyString_whenGivenEmptyWordList() {
        Anagrams anagrams = new Anagrams();
        String words = "";

        String expectedAnagrams = "";
        String actualAnagrams = anagrams.findAnagrams(words);
        assertEquals(expectedAnagrams, actualAnagrams);
    }
}