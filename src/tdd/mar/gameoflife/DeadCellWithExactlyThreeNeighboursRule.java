package tdd.mar.gameoflife;

public class DeadCellWithExactlyThreeNeighboursRule implements Rule {
    @Override
    public int[][] update(int[][] board) {
        int[][] boardCopy = copyBoard(board);
        reviveCellsWithThreeOrMoveLiveNeighbours(boardCopy);
        return boardCopy;
    }

    private int[][] copyBoard(int[][] board) {
        int[][] boardCopy = board.clone();
        for (int i = 0; i < board.length; i++) {
            boardCopy[i] = boardCopy[i].clone();
        }

        return boardCopy;
    }

    private void reviveCellsWithThreeOrMoveLiveNeighbours(int[][] boardCopy) {
        // Set the revived cells to two so that they are ignored by remaining dead cells.
        // This prevents dead cells from being revived in the wrong update.
        for (int i = 0; i < boardCopy.length; i++) {
            for (int j = 0; j < boardCopy[i].length; j++) {
                if (foundThreeOrMoreLiveNeighbours(i, j, boardCopy)) {
                    boardCopy[i][j] = 2;
                }
            }
        }

        // Set all the revived cells to one after the update has finished.
        for (int i = 0; i < boardCopy.length; i++) {
            for (int j = 0; j < boardCopy[i].length; j++) {
                if (boardCopy[i][j] == 2) {
                    boardCopy[i][j] = 1;
                }
            }
        }
    }

    private boolean foundThreeOrMoreLiveNeighbours(int rowIndex, int columnIndex, int[][] board) {
        int numberOfLiveNeighbours = 0;
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

                if (board[currentRowIndex][currentColumnIndex] == 1) {
                    numberOfLiveNeighbours++;
                }
            }
        }

        return numberOfLiveNeighbours >= 3;
    }
}
