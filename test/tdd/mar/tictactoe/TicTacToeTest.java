package tdd.mar.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicTacToeTest {
    @Test
    public void return2DArrayFilledWithEmptyStrings() {
        TicTacToe ticTacToe = new TicTacToe();

        String[][] expectedBoard = {{"", "", ""}, {"", "", ""}, {"", "", ""}};
        String[][] actualBoard = ticTacToe.getBoard();
        assertArrayEquals(expectedBoard, actualBoard);
    }

    @Test
    public void return2DArrayThatContainsOneX() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.place(0, 0, "X");

        String[][] expectedBoard = {{"X", "", ""}, {"", "", ""}, {"", "", ""}};
        String[][] actualBoard = ticTacToe.getBoard();
        assertArrayEquals(expectedBoard, actualBoard);
    }
}