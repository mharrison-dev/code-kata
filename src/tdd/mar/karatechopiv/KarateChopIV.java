package tdd.mar.karatechopiv;

public class KarateChopIV {
    public int chop(int target, int[] integers) {
        if (integers.length == 0) {
            return -1;
        }

        int lowerBound = 0;
        int upperBound = integers.length;
        return dualRecursiveBinarySearch(lowerBound, upperBound, target, integers);
    }

    private int dualRecursiveBinarySearch(int lowerBound, int upperBound, int target, int[] integers) {
        if (integers[lowerBound] > target || integers[upperBound - 1] < target) {
            return -1;
        }

        if (upperBound - lowerBound == 1) {
            if (integers[lowerBound] == target) {
                return lowerBound;
            } else {
                return -1;
            }
        }

        int splitIndex = lowerBound + (upperBound - lowerBound) / 2;
        return Math.max(
                dualRecursiveBinarySearch(lowerBound, splitIndex, target, integers),
                dualRecursiveBinarySearch(splitIndex, upperBound, target, integers)
        );
    }
}
