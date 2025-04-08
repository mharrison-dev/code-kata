package tdd.apr.wordchain;

public class WordChain {
    private String[] dictionary;

    public String getChain(String firstWord, String lastWord) {
        if (!foundInDictionary(lastWord)) {
            return "";
        }

        String middleWord = getMiddleWord(firstWord);
        if (middleWord == null) {
            return "";
        } else {
            return firstWord + " > " + middleWord + " > " + lastWord;
        }
    }

    private boolean foundInDictionary(String targetWord) {
        for (String word : dictionary) {
            if (word.equals(targetWord)) {
                return true;
            }
        }

        return false;
    }

    private String getMiddleWord(String firstWord) {
        String middleWord = null;
        for (String word : dictionary) {
            int hammingDistance = getHammingDistance(firstWord, word);
            if (hammingDistance == 1) {
                middleWord = word;
                break;
            }
        }

        return middleWord;
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
