package tdd.mar.equalsidesofanarray;

public class EqualSidesOfAnArray {
    public int findMiddleIndex(int[] integers) {
        if (integers.length == 0) {
            return -1;
        }

        return integers.length / 2;
    }
}
