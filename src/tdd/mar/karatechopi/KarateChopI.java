package tdd.mar.karatechopi;

public class KarateChopI {
    public int chop(int target, int[] integers) {
        int lowerBound = 0;
        int upperBound = integers.length;
        return recursiveChop(lowerBound, upperBound, target, integers);
    }

    private int recursiveChop(int lowerBound, int upperBound, int target, int[] integers) {
        if (lowerBound >= upperBound) {
            return -1;
        }

        int middleIndex = ((upperBound - lowerBound) / 2) + lowerBound;
        if (target == integers[middleIndex]) {
            return middleIndex;
        }

        if (target < integers[middleIndex]) {
            int newUpperBound = middleIndex;
            return recursiveChop(lowerBound, newUpperBound, target, integers);
        } else { // target > integers[middleIndex]
            int newLowerBound = middleIndex + 1;
            return recursiveChop(newLowerBound, upperBound, target, integers);
        }
    }
}
