package tdd.mar.simplepiglatin;

public class SimplePigLatin {
    public String translate(String sentence) {
        if (sentence.matches("\\p{Punct}") || sentence.equals("...")) {
            return sentence;
        }

        String firstLetterOfWord = sentence.substring(0, 1);
        String remainingPortionOfWord = sentence.substring(1);
        return remainingPortionOfWord + firstLetterOfWord + "ay";
    }
}