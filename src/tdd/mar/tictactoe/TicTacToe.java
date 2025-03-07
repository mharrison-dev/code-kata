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
        return null;
    }
}
