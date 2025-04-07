package tdd.apr.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Anagrams {
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
        if (word.length() != referenceWord.length()) {
            return false;
        }

        HashSet<String> lettersOfReferenceWord = new HashSet<>(Arrays.stream(referenceWord.split("")).toList());
        List<String> lettersOfWord = Arrays.stream(word.split("")).toList();
        return lettersOfReferenceWord.containsAll(lettersOfWord);
    }
}
