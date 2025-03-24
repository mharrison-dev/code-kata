package tdd.mar.nqueenspuzzle;

public class QueenPlacementLogic {
    public String placeQueen(int rowIndex, int columnIndex, String board) {
        String[][] boardArray = convertToArray(board);
        for (int i = rowIndex - 1; i <= rowIndex + 1; i++) {
            if (i > -1 && i < boardArray.length) {
                for (int j = columnIndex - 1; j <= columnIndex + 1; j++) {
                    if (j > -1 && j < boardArray.length) {
                        boardArray[i][j] = "X";
                    }
                }
            }
        }

        boardArray[rowIndex][columnIndex] = "Q";

        return convertToString(boardArray);
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

    private String convertToString(String[][] boardArray) {
        String board = "";
        for (int i = 0; i < boardArray.length; i++) {
            if (i > 0) {
                board += "\n";
            }

            for (int j = 0; j < boardArray.length; j++) {
                board += boardArray[i][j];
            }
        }

        return board;
    }
}
