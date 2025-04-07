package tdd.apr.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagrams {
    private static final int NUMBER_OF_LETTERS = 26;
    private static final int ASCII_OF_LOWERCASE_A = 97;

    public String findAnagrams(String words) {
        List<String> anagramList = new ArrayList<>();

        List<String> wordList = Arrays.stream(words.split("\n")).toList();
        String referenceWord = wordList.getFirst();
        for (String word : wordList) {
            if (areAnagrams(word, referenceWord)) {
                anagramList.add(word);
            }
        }

        return String.join(" ", anagramList);
    }

    private static boolean areAnagrams(String word, String referenceWord) {
        int[] letterVectorOfWord = getLetterVector(word);
        int[] letterVectorOfReferenceWord = getLetterVector(referenceWord);
        for (int i = 0; i < NUMBER_OF_LETTERS; i++) {
            if (letterVectorOfWord[i] != letterVectorOfReferenceWord[i]) {
                return false;
            }
        }

        return true;
    }

    private static int[] getLetterVector(String word) {
        int[] letterVector = new int[NUMBER_OF_LETTERS];
        word.chars().forEach(letter -> letterVector[letter - ASCII_OF_LOWERCASE_A]++);
        return letterVector;
    }
}
