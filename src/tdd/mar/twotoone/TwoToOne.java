package tdd.mar.twotoone;

import java.util.Arrays;

public class TwoToOne {
    public String combine(String string, String otherString) {
        String[] strings = (string + otherString).split("");
        Arrays.sort(strings);
        return combineStringsWithoutDuplicates(strings);
    }

    private String combineStringsWithoutDuplicates(String[] strings) {
        StringBuilder nonDuplicateLetterBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            String currentString = strings[i];
            if (i == 0) {
                nonDuplicateLetterBuilder.append(currentString);
            } else {
                String previousString = strings[i - 1];
                if (currentString.equals(previousString)) {
                    continue;
                } else {
                    nonDuplicateLetterBuilder.append(currentString);
                }
            }
        }

        return nonDuplicateLetterBuilder.toString();
    }
}
