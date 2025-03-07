package tdd.mar.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void return2DArrayThatContainsOneO() {
        ticTacToe.place(0, 0, "O");

        String[][] expectedBoard = {{"O", "", ""}, {"", "", ""}, {"", "", ""}};
        String[][] actualBoard = ticTacToe.getBoard();
        assertArrayEquals(expectedBoard, actualBoard);
    }

    @Test
    public void returnNullForWinner() {
        String expectedWinner = null;
        String actualWinner = ticTacToe.getWinner();
        assertEquals(expectedWinner, actualWinner);
    }

    @Test
    public void returnXForWinnerForXDiagonal() {
        ticTacToe.place(0, 0, "X");
        ticTacToe.place(1, 1, "X");
        ticTacToe.place(2, 2, "X");

        String expectedWinner = "X";
        String actualWinner = ticTacToe.getWinner();
        assertEquals(expectedWinner, actualWinner);
    }

    @Test
    public void returnXForWinnerForXFlippedDiagonal() {
        ticTacToe.place(0, 2, "X");
        ticTacToe.place(1, 1, "X");
        ticTacToe.place(2, 0, "X");

        String expectedWinner = "X";
        String actualWinner = ticTacToe.getWinner();
        assertEquals(expectedWinner, actualWinner);
    }

    @Test
    public void returnOForWinnerForODiagonal() {
        ticTacToe.place(0, 0, "O");
        ticTacToe.place(1, 1, "O");
        ticTacToe.place(2, 2, "O");

        String expectedWinner = "O";
        String actualWinner = ticTacToe.getWinner();
        assertEquals(expectedWinner, actualWinner);
    }
}