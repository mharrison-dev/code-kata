package tdd.apr.camelcasedeconstruction;

import java.util.ArrayList;
import java.util.List;

public class CamelCaseDeconstruction {
    public String deconstruct(String string) {
        List<int[]> subStringIndicesList = getSubstringIndicesList(string);
        String[] subStrings = getSubStrings(string, subStringIndicesList);
        return String.join(" ", subStrings);
    }

    private static String[] getSubStrings(String string, List<int[]> subStringIndicesList) {
        String[] subStrings = new String[subStringIndicesList.size()];
        for (int i = i = 0; i < subStrings.length; i++) {
            int[] subStringIndices = subStringIndicesList.get(i);
            int beginIndex = subStringIndices[0];
            int endIndex = subStringIndices[1];
            subStrings[i] = string.substring(beginIndex, endIndex).toLowerCase();
        }
        return subStrings;
    }

    private static List<int[]> getSubstringIndicesList(String string) {
        List<int[]> subStringIndicesList = new ArrayList<>();
        int beginIndex = 0;
        List<Integer> upperCaseLetterIndexList = getUppercaseLetterIndexList(string);
        for (int endIndex : upperCaseLetterIndexList) {
            int[] subStringIndices = {beginIndex, endIndex};
            subStringIndicesList.add(subStringIndices);
            beginIndex = endIndex;
        }
        int[] lastSubStringIndices = {beginIndex, string.length()};
        subStringIndicesList.add(lastSubStringIndices);
        return subStringIndicesList;
    }

    private static List<Integer> getUppercaseLetterIndexList(String string) {
        List<Integer> upperCaseLetterIndexList = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            char ithCharacter = string.charAt(i);
            if (Character.isUpperCase(ithCharacter)) {
                upperCaseLetterIndexList.add(i);
            }
        }
        return upperCaseLetterIndexList;
    }
}
