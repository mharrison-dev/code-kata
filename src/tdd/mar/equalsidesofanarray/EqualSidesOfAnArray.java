package tdd.mar.equalsidesofanarray;

import java.util.Arrays;

public class EqualSidesOfAnArray {
    public int findMiddleIndex(int[] integers) {
        for (int i = 0; i < integers.length; i++) {
            int leftSum = Arrays.stream(integers, 0, i).sum();
            int rightSum = Arrays.stream(integers, i + 1, integers.length).sum();
            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }
}
