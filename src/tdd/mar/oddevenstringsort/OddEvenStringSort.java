package tdd.mar.oddevenstringsort;

import java.util.stream.IntStream;

public class OddEvenStringSort {
    public String sort(String string) {
        String evenString = getEvenString(string);
        if (evenString.isEmpty()) {
            return "";
        }

        String oddString = getOddString(string);
        if (oddString.isEmpty()) {
            return evenString;
        }

        return evenString + " " + oddString;
    }

    private String getEvenString(String string) {
        return IntStream.range(0, string.length())
                .filter(i -> i % 2 == 0)
                .collect(
                        StringBuilder::new,
                        (builder, i) -> builder.append(string.charAt(i)),
                        StringBuilder::append
                )
                .toString();
    }

    private String getOddString(String string) {
        return IntStream.range(0, string.length())
                .filter(i -> i % 2 != 0)
                .collect(
                        StringBuilder::new,
                        (builder, i) -> builder.append(string.charAt(i)),
                        StringBuilder::append
                )
                .toString();
    }
}