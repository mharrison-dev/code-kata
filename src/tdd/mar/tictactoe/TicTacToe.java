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
        String diagonal = board[0][0] + board[1][1] + board[2][2];
        String flippedDiagonal = board[0][2] + board[1][1] + board[2][0];
        if (diagonal.equals("XXX") || flippedDiagonal.equals("XXX")) {
            return "X";
        } else {
            return null;
        }
    }
}
