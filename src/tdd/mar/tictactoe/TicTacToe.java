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
            String[] lines = getLines();
            for (String line : lines) {
                if (line.equals(piece.repeat(3))) {
                    return piece;
                }
            }
        }

        return null;
    }

    private String[] getLines() {
        String diagonal = board[0][0] + board[1][1] + board[2][2];
        String flippedDiagonal = board[0][2] + board[1][1] + board[2][0];
        String topHorizontal = board[0][0] + board[0][1] + board[0][2];
        return new String[]{diagonal, flippedDiagonal, topHorizontal};
    }
}
