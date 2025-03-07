package tdd.mar.tictactoe;

import java.util.ArrayList;
import java.util.List;

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
        List<String> lines = new ArrayList<>();

        String diagonal = board[0][0] + board[1][1] + board[2][2];
        lines.add(diagonal);

        String flippedDiagonal = board[0][2] + board[1][1] + board[2][0];
        lines.add(flippedDiagonal);

        List<String> horizontals = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            horizontals.add(board[i][0] + board[i][1] + board[i][2]);
        }

        lines.addAll(horizontals);

        List<String> verticals = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            verticals.add(board[0][i] + board[1][i] + board[2][i]);
        }

        lines.addAll(verticals);

        return lines.toArray(new String[0]);
    }
}
