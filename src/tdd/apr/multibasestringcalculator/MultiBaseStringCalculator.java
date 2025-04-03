package tdd.apr.multibasestringcalculator;

public class MultiBaseStringCalculator {
    public String add(int base, String addend, String otherAddend) {
        return String.valueOf(Integer.parseInt(addend) + Integer.parseInt(otherAddend));
    }
}

