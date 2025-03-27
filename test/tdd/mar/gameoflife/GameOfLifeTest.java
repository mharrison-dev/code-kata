package tdd.mar.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GameOfLifeTest extends tdd.mar.gameoflife.Test {
    @Test
    public void shouldReturnBoardWithProperUpdates_whenGivenValidBoard() {
        int[][] board = {
                {0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };
        GameOfLife gameOfLife = new GameOfLife();

        int[][] expectedBoard = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };
        int[][] actualBoard = gameOfLife.update(board);
        assertTrue(Arrays.deepEquals(expectedBoard, actualBoard), getErrorMessage(expectedBoard, actualBoard));
    }
}