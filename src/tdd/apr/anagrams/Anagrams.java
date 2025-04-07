package tdd.apr.anagrams;

import java.util.Arrays;
import java.util.List;

public class Anagrams {
    public String findAnagrams(String words) {
        List<String> wordList = Arrays.stream(words.split("\n")).toList();
        return String.join(" ", wordList);
    }
}
