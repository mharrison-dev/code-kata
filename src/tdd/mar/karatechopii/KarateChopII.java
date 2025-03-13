package tdd.mar.karatechopii;

public class KarateChopII {
    public int chop(int target, int[] integers) {
        return iterativeBinarySearch(target, integers);
    }

    private int iterativeBinarySearch(int target, int[] integers) {
        int lowerBound = 0;
        int upperBound = integers.length;
        while (lowerBound < upperBound) {
            int middleIndex = lowerBound + ((upperBound - lowerBound) / 2);
            if (target < integers[middleIndex]) {
                upperBound = middleIndex;
            } else if (target > integers[middleIndex]) {
                lowerBound = middleIndex + 1;
            } else {
                return middleIndex;
            }
        }

        return -1;
    }
}
