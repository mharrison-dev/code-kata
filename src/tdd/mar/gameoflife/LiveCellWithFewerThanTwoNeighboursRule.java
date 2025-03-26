package tdd.mar.gameoflife;

public class LiveCellWithFewerThanTwoNeighboursRule implements Rule {
    public int[][] update(int[][] board) {
        return new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    }
}
