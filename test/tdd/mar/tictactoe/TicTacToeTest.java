package tdd.mar.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicTacToeTest {
    private TicTacToe ticTacToe = null;

    @BeforeEach
    public void setUp() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void return2DArrayFilledWithEmptyStrings() {
        String[][] expectedBoard = {{"", "", ""}, {"", "", ""}, {"", "", ""}};
        String[][] actualBoard = ticTacToe.getBoard();
        assertArrayEquals(expectedBoard, actualBoard);
    }

    @Test
    public void return2DArrayThatContainsOneX() {
        ticTacToe.place(0, 0, "X");

        String[][] expectedBoard = {{"X", "", ""}, {"", "", ""}, {"", "", ""}};
        String[][] actualBoard = ticTacToe.getBoard();
        assertArrayEquals(expectedBoard, actualBoard);
    }

    @Test
    public void return2DArrayThatContainsOneXInDifferentPosition() {
        ticTacToe.place(1, 1, "X");

        String[][] expectedBoard = {{"", "", ""}, {"", "X", ""}, {"", "", ""}};
        String[][] actualBoard = ticTacToe.getBoard();
        assertArrayEquals(expectedBoard, actualBoard);
    }
}