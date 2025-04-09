package tdd.apr.camelcasedeconstruction;

import java.util.ArrayList;
import java.util.List;

public class CamelCaseDeconstruction {
    public String deconstruct(String string) {
        int indexOfUppercaseLetter = getIndexOfUppercaseLetter(string);
        return (indexOfUppercaseLetter > -1)
                ? String.join(" ", string.substring(0, indexOfUppercaseLetter), string.substring(indexOfUppercaseLetter))
                : string;
    }

    private static int getIndexOfUppercaseLetter(String string) {
        int indexOfUppercaseLetter = -1;
        for (int i = 0; i < string.length(); i++) {
            char ithCharacter = string.charAt(i);
            if (Character.isUpperCase(ithCharacter)) {
                indexOfUppercaseLetter = i;
                break;
            }
        }

        return indexOfUppercaseLetter;
    }
}
