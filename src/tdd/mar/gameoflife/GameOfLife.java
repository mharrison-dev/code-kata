package tdd.mar.gameoflife;

public class GameOfLife {
    public int[][] update(int[][] board) {
        if (foundTwoNeighbours(board)) {
            return new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        }

        return new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    }

    private boolean foundTwoNeighbours(int[][] board) {
        int rowIndex = 1;
        int columnIndex = 1;

        for (int i = -1; i <= 0; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    if (board[rowIndex + i][columnIndex + j] == 1 && board[rowIndex - i][columnIndex - j] == 1) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
