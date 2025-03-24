package tdd.mar.nqueenspuzzle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenPlacementLogicTest {
    @Test
    public void shouldReturnBoardWithQueen_whenGivenEmptyOneByOneBoard() {
        String board = ".";
        QueenPlacementLogic queenPlacementLogic = new QueenPlacementLogic();

        String expectedBoard = "Q";
        String actualBoard = queenPlacementLogic.placeQueen(0, 0, board);
        assertEquals(expectedBoard, actualBoard);
    }

    @Test
    public void shouldReturnBoardWithQueenSurroundedByXs_whenQueenIsPlacedInCenterOfEmptyThreeByThreeBoard() {
        String board = "...\n...\n...";
        QueenPlacementLogic queenPlacementLogic = new QueenPlacementLogic();

        String expectedBoard = "XXX\nXQX\nXXX";
        String actualBoard = queenPlacementLogic.placeQueen(1, 1, board);
        assertEquals(expectedBoard, actualBoard);
    }

    @Test
    public void shouldReturnBoardWithAttackSquaresMarkedByXs_whenQueenIsPlacedInCenterOfEmptyFiveByFiveBoard() {
        String board = ".....\n.....\n.....\n.....\n.....";
        QueenPlacementLogic queenPlacementLogic = new QueenPlacementLogic();

        String expectedBoard = "X.X.X\n.XXX.\nXXQXX\n.XXX.\nX.X.X";
        String actualBoard = queenPlacementLogic.placeQueen(2, 2, board);
        assertEquals(expectedBoard, actualBoard);
    }
}