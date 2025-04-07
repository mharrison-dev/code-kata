package tdd.apr.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagrams {
    public String findAnagrams(String words) {
        List<String> anagramList = new ArrayList<>();
        List<String> wordList = Arrays.stream(words.split("\n")).toList();
        String referenceWord = wordList.getFirst();
        for (String word : wordList) {
            if (word.length() == referenceWord.length()) {
                anagramList.add(word);
            }
        }

        return String.join(" ", anagramList);
    }
}
