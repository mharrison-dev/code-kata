package tdd.mar.equalsidesofanarray;

public class EqualSidesOfAnArray {
    public int findMiddleIndex(int[] integers) {
        if (integers.length == 0) {
            return -1;
        }

        if (integers.length == 1) {
            return 0;
        }

        if (integers[0] == integers[2]) {
            return 1;
        }

        return -1;
    }
}
