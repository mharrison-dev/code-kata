package tdd.mar.gameoflife;

public class LiveCellWithMoreThanThreeNeighboursRule implements Rule {
    @Override
    public int[][] update(int[][] board) {
        int[][] boardCopy = copyBoard(board);
        killCellsThatHaveMoreThanThreeNeighbours(boardCopy);
        return boardCopy;
    }

    private int[][] copyBoard(int[][] board) {
        int[][] boardCopy = board.clone();
        for (int i = 0; i < board.length; i++) {
            boardCopy[i] = boardCopy[i].clone();
        }

        return boardCopy;
    }

    private void killCellsThatHaveMoreThanThreeNeighbours(int[][] boardCopy) {
        // Set dead cells to two so they can still be counted as neighbours for other live cells.
        // This makes sure that all cells are updated at the same time
        for (int i = 0; i < boardCopy.length; i++) {
            for (int j = 0; j < boardCopy[i].length; j++) {
                if (foundMoreThanThreeNeighbours(i, j, boardCopy)) {
                    boardCopy[i][j] = 2;
                }
            }
        }

        // After the update, set all dead cells to zero
        for (int i = 0; i < boardCopy.length; i++) {
            for (int j = 0; j < boardCopy[i].length; j++) {
                if (boardCopy[i][j] == 2) {
                    boardCopy[i][j] = 0;
                }
            }
        }
    }

    private boolean foundMoreThanThreeNeighbours(int rowIndex, int columnIndex, int[][] board) {
        int numberOfNeighbours = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int currentRowIndex = rowIndex + i;
                int currentColumnIndex = columnIndex + j;

                if (currentRowIndex == rowIndex && currentColumnIndex == columnIndex) {
                    continue;
                }

                if (currentRowIndex < 0 || currentRowIndex >= board.length) {
                    continue;
                }

                if (currentColumnIndex < 0 || currentColumnIndex >= board[currentRowIndex].length) {
                    continue;
                }

                if (board[currentRowIndex][currentColumnIndex] > 0) {
                    numberOfNeighbours++;
                }
            }
        }

        return numberOfNeighbours > 3;
    }
}
