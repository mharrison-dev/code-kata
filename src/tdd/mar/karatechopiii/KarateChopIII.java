package tdd.mar.karatechopiii;

public class KarateChopIII {
    public int chop(int target, int[] integers) {
        return smallestScaledDifferenceBinarySearch(target, integers);
    }

    private int smallestScaledDifferenceBinarySearch(int target, int[] integers) {
        int lowerBound = 0;
        int upperBound = integers.length;
        while (lowerBound < upperBound) {
            int differenceBetweenTargetAndSmallestValue = target - integers[lowerBound];
            if (differenceBetweenTargetAndSmallestValue < 0) {
                return -1;
            }

            int differenceBetweenLargestNumberAndTarget = integers[upperBound - 1] - target;
            if (differenceBetweenLargestNumberAndTarget < 0) {
                return -1;
            }

            int middleIndex;
            int differenceBetweenUpperBoundAndLowerBound = upperBound - lowerBound;
            int differenceBetweenLargestNumberAndSmallestNumber = integers[upperBound - 1] - integers[lowerBound];
            if (differenceBetweenLargestNumberAndSmallestNumber == 0) {
                return lowerBound;
            }

            if (differenceBetweenTargetAndSmallestValue < differenceBetweenLargestNumberAndTarget) {
                middleIndex = lowerBound + ((differenceBetweenTargetAndSmallestValue * differenceBetweenUpperBoundAndLowerBound) / differenceBetweenLargestNumberAndSmallestNumber);
            } else {
                middleIndex = upperBound - ((differenceBetweenLargestNumberAndTarget * differenceBetweenUpperBoundAndLowerBound) / differenceBetweenLargestNumberAndSmallestNumber) - 1;
            }

            if (integers[middleIndex] < target) {
                lowerBound = middleIndex + 1;
            } else if (integers[middleIndex] > target) {
                upperBound = middleIndex;
            } else {
                return middleIndex;
            }
        }

        return -1;
    }
}
