package tdd.apr.multibasestringcalculator;

public class MultiBaseStringCalculator {
    public String add(int base, String addend, String otherAddend) {
        int sumInBaseTen = Integer.parseInt(addend) + Integer.parseInt(otherAddend);
        if (sumInBaseTen == base) {
            return "10";
        }
        return String.valueOf(Integer.parseInt(addend) + Integer.parseInt(otherAddend));
    }
}

