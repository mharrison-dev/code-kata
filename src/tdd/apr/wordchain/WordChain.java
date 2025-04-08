package tdd.apr.wordchain;

import java.util.ArrayList;
import java.util.List;

public class WordChain {
    private String[] dictionary;

    public String getChain(String firstWord, String lastWord) {
        List<String> wordChain = getStartOfWordChain(firstWord);
        List<String> eligibleWords = getInitialEligibleWords(firstWord);
        while (!wordChain.isEmpty() && !wordChain.getLast().equals(lastWord)) {
            String nextWord = getNextWord(wordChain.getLast(), eligibleWords);
            if (nextWord == null) {
                break;
            } else {
                wordChain.add(nextWord);
                eligibleWords.remove(nextWord);
            }
        }

        return (wordChain.isEmpty() || wordChain.getLast().equals(lastWord))
                ? String.join(" > ", wordChain)
                : "";
    }

    private List<String> getStartOfWordChain(String firstWord) {
        return (isMissingFromDictionary(firstWord))
                ? new ArrayList<>()
                : new ArrayList<>(List.of(firstWord));
    }

    private List<String> getInitialEligibleWords(String firstWord) {
        List<String> eligibleLinks = new ArrayList<>(List.of(dictionary));
        eligibleLinks.remove(firstWord);
        return eligibleLinks;
    }

    private boolean isMissingFromDictionary(String targetWord) {
        for (String word : dictionary) {
            if (word.equals(targetWord)) {
                return false;
            }
        }

        return true;
    }

    private String getNextWord(String previousWord, List<String> eligibleLinks) {
        String nextWord = null;
        for (String word : eligibleLinks) {
            int hammingDistance = getHammingDistance(previousWord, word);
            if (hammingDistance == 1) {
                nextWord = word;
                break;
            }
        }

        return nextWord;
    }

    private static int getHammingDistance(String word, String otherWord) {
        int hammingDistance = 0;
        String[] lettersOfFirstWord = word.split("");
        String[] lettersOfWord = otherWord.split("");
        for (int i = 0; i < lettersOfWord.length; i++) {
            if (!lettersOfWord[i].equals(lettersOfFirstWord[i])) {
                hammingDistance++;
            }
        }

        return hammingDistance;
    }

    public void setDictionary(String dictionary) {
        this.dictionary = dictionary
                .replaceAll("\\s*", "")
                .split(",");
    }
}
