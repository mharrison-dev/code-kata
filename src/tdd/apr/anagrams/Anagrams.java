package tdd.apr.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagrams {
    private static final int NUMBER_OF_LETTERS = 26;
    private static final int ASCII_OF_LOWERCASE_A = 97;

    public String findAnagrams(String words) {
        StringBuilder anagrams = new StringBuilder();

        List<String> wordList = Arrays.stream(words.split("\n")).toList();
        while (!wordList.isEmpty()) {
            List<String> anagramList = new ArrayList<>();
            List<String> unusedWordList = new ArrayList<>();
            divideWordListIntoAnagramsAndNonAnagrams(wordList, anagramList, unusedWordList);

            if (anagramList.size() > 1) {
                appendToAnagrams(anagrams, anagramList);
            }

            wordList = unusedWordList;
        }

        return anagrams.toString();
    }

    private static void appendToAnagrams(StringBuilder anagrams, List<String> anagramList) {
        anagrams.append((anagrams.isEmpty())
                ? String.join(" ", anagramList)
                : "\n" + String.join(" ", anagramList));
    }

    private static void divideWordListIntoAnagramsAndNonAnagrams(List<String> wordList, List<String> anagramList, List<String> unusedWordList) {
        String referenceWord = wordList.getFirst();
        for (String word : wordList) {
            if (areAnagrams(word, referenceWord)) {
                anagramList.add(word);
            } else {
                unusedWordList.add(word);
            }
        }
    }

    private static boolean areAnagrams(String word, String referenceWord) {
        int[] letterVectorOfWord = getLetterVector(word);
        int[] letterVectorOfReferenceWord = getLetterVector(referenceWord);
        return Arrays.equals(letterVectorOfWord, letterVectorOfReferenceWord);
    }

    private static int[] getLetterVector(String word) {
        int[] letterVector = new int[NUMBER_OF_LETTERS];
        word.toLowerCase().chars().forEach(letter -> letterVector[letter - ASCII_OF_LOWERCASE_A]++);
        return letterVector;
    }
}
