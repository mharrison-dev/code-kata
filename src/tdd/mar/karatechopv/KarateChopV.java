package tdd.mar.karatechopv;

import java.util.Arrays;

public class KarateChopV {
    public int chop(int target, int[] integers) {
        return subArrayBinarySearch(target, integers);
    }

    private int subArrayBinarySearch(int target, int[] integers) {
        if (integers.length == 0) {
            return -1;
        }

        int middleIndex = (integers.length % 2 == 0)
                ? (integers.length - 1) / 2
                : integers.length / 2;

        if (integers[middleIndex] < target) {
            int[] rightSubArray = Arrays.copyOfRange(integers, middleIndex + 1, integers.length);
            int targetIndex = subArrayBinarySearch(target, rightSubArray);
            if (targetIndex != -1) {
                targetIndex += Math.round(integers.length / 2f);
            }
            return targetIndex;
        } else if (integers[middleIndex] > target) {
            int[] leftSubArray = Arrays.copyOfRange(integers, 0, middleIndex);
            return subArrayBinarySearch(target, leftSubArray);
        } else if (integers[middleIndex] == target) {
            return middleIndex;
        } else {
            return -1;
        }
    }
}
