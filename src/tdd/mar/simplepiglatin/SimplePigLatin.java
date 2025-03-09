package tdd.mar.simplepiglatin;

public class SimplePigLatin {
    public String translate(String sentence) {
        StringBuilder translatedSentenceBuilder = new StringBuilder();
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String translatedWord = translateWord(words[i]);
            translatedSentenceBuilder.append(translatedWord);
            if (i < words.length - 1) {
                translatedSentenceBuilder.append(" ");
            }
        }

        return translatedSentenceBuilder.toString();
    }

    private String translateWord(String word) {
        if (word.matches("\\p{Punct}") || word.equals("...")) {
            return word;
        }

        String lastLetterOfWord = word.substring(word.length() - 1);
        if (lastLetterOfWord.matches("\\p{Punct}") || lastLetterOfWord.equals("...")) {
            String firstLetterOfWord = word.substring(0, 1);
            String remainingPortionOfWord = word.substring(1, word.length() - 1);
            return remainingPortionOfWord + firstLetterOfWord + "ay" + lastLetterOfWord;
        } else {
            String firstLetterOfWord = word.substring(0, 1);
            String remainingPortionOfWord = word.substring(1);
            return remainingPortionOfWord + firstLetterOfWord + "ay";
        }
    }
}