package tdd.mar.gameoflife;

import java.util.Arrays;

public abstract class Test {
    public String getErrorMessage(int[][] expectedBoard, int[][] actualBoard) {
        return "\nExpected: " + Arrays.deepToString(expectedBoard) + "\nActual: " + Arrays.deepToString(actualBoard);
    }
}
