package tdd.apr.multibasestringcalculator;

import java.util.Arrays;

public class MultiBaseStringCalculator {
    public String add(int base, String addend, String otherAddend) {
        int[] accumulator = new int[Math.max(addend.length(), otherAddend.length()) + 1];
        addToAccumulator(addend, accumulator, base);
        addToAccumulator(otherAddend, accumulator, base);
        return convertAccumulatorToString(accumulator);
    }

    private void addToAccumulator(String addend, int[] accumulator, int base) {
        int[] addendAsArray = Arrays.stream(addend.split("")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < addendAsArray.length; i++) {
            int offset = accumulator.length - addendAsArray.length;
            int accumulatorColumn = accumulator[i + offset] + addendAsArray[i];
            accumulator[i + offset - 1] += (accumulatorColumn >= base) ? 1 : 0;
            accumulator[i + offset] = accumulatorColumn % base;
        }
    }

    private String convertAccumulatorToString(int[] accumulator) {
        String[] accumulatorAsStringArray = Arrays.stream(accumulator).mapToObj(Integer::toString).toArray(String[]::new);
        String accumulatorAsString = String.join("", accumulatorAsStringArray);
        return accumulatorAsString.replaceAll("^0", "");
    }
}

