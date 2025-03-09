package tdd.mar.simplepiglatin;

public class SimplePigLatin {
    public String translate(String sentence) {
        if (sentence.matches("\\p{Punct}") || sentence.equals("...")) {
            return sentence;
        }

        String lastLetterOfWord = sentence.substring(sentence.length() - 1);
        if (lastLetterOfWord.matches("\\p{Punct}") || lastLetterOfWord.equals("...")) {
            String firstLetterOfWord = sentence.substring(0, 1);
            String remainingPortionOfWord = sentence.substring(1, sentence.length() - 1);
            return remainingPortionOfWord + firstLetterOfWord + "ay" + lastLetterOfWord;
        } else {
            String firstLetterOfWord = sentence.substring(0, 1);
            String remainingPortionOfWord = sentence.substring(1);
            return remainingPortionOfWord + firstLetterOfWord + "ay";
        }
    }
}