package tdd.mar.nqueenspuzzle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenPlacementLogicTest {
    @Test
    public void shouldReturnBoardWithQueen_whenGivenEmptyOneByOneBoard() {
        String board = ".";
        QueenPlacementLogic queenPlacementLogic = new QueenPlacementLogic();

        String expectedBoard = "Q";
        String actualBoard = queenPlacementLogic.placeQueen(0, 0);
        assertEquals(expectedBoard, actualBoard);
    }
}