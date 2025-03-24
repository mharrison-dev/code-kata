package tdd.mar.nqueenspuzzle;

public class BoardValidationLogic {
    public boolean validate(String board) {
        if (board.length() == 1) {
            return true;
        }

        String[][] boardArray = convertToArray(board);
        for (int i = 0; i < boardArray.length; i++) {
            for (int j = 0; j < boardArray.length; j++) {
                if (boardArray[i][j].equals("Q")) {
                    if (hasSightOfOtherQueen(i, j, boardArray)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private String[][] convertToArray(String board) {
        String[] ranks = board.split("\n");
        String[][] boardArray = new String[ranks.length][ranks.length];
        for (int i = 0; i < ranks.length; i++) {
            String currentRank = ranks[i];
            String[] currentFiles = currentRank.split("");
            System.arraycopy(currentFiles, 0, boardArray[i], 0, currentFiles.length);
        }

        return boardArray;
    }

    private boolean hasSightOfOtherQueen(int rowIndex, int columnIndex, String[][] boardArray) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else {
                    int currentRowIndex = rowIndex + i;
                    int currentColumnIndex = columnIndex + j;
                    while (currentRowIndex > -1 && currentRowIndex < boardArray.length && currentColumnIndex > -1 && currentColumnIndex < boardArray.length) {
                        if (boardArray[currentRowIndex][currentColumnIndex].equals("Q")) {
                            return true;
                        }
                        currentRowIndex += i;
                        currentColumnIndex += j;
                    }
                }
            }
        }

        return false;
    }
}