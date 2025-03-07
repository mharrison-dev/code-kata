package tdd.mar.tictactoe;

public class TicTacToe {
    private final String[][] board = {{"", "", ""}, {"", "", ""}, {"", "", ""}};

    public String[][] getBoard() {
        return board;
    }

    public void place(int rowIndex, int columnIndex, String piece) {
        board[rowIndex][columnIndex] = piece;
    }

    public String getWinner() {
        String[] pieces = {"X", "O"};
        for (String piece : pieces) {
            String diagonal = board[0][0] + board[1][1] + board[2][2];
            String flippedDiagonal = board[0][2] + board[1][1] + board[2][0];
            if (diagonal.equals(piece.repeat(3)) || flippedDiagonal.equals(piece.repeat(3))) {
                return piece;
            }
        }

        return null;
    }
}
