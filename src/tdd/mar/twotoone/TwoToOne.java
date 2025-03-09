package tdd.mar.twotoone;

import java.util.Arrays;

public class TwoToOne {
    public String combine(String string, String otherString) {
        String[] strings = (string + otherString).split("");
        Arrays.sort(strings);
        return String.join("", strings);
    }
}
