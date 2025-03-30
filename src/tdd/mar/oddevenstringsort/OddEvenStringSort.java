package tdd.mar.oddevenstringsort;

public class OddEvenStringSort {
    public String sort(String string) {
        return String.join(" ", string.split(""));
    }
}