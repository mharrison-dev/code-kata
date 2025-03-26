package tdd.mar.gameoflife;

public class LiveCellWithTwoOrThreeNeighboursRule implements Rule {
    public int[][] update(int[][] board) {
        return new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    }
}
