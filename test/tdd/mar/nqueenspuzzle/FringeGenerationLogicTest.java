package tdd.mar.nqueenspuzzle;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FringeGenerationLogicTest {
    @Test
    public void shouldReturnFourBoardsThatEachContainOneQueen_whenGivenEmptyTwoByTwoBoard() {
        FringeGenerationLogic fringeGenerationLogic = new FringeGenerationLogic();
        String emptyBoard = "..\n..";

        List<String> expectedBoards = List.of("Q.\n..", ".Q\n..", "..\nQ.", "..\n.Q");
        List<String> actualBoards = fringeGenerationLogic.generateFringe(emptyBoard);
        assertTrue(expectedBoards.containsAll(actualBoards));
    }

    @Test
    public void shouldReturnEmptyList_whenGivenTwoByTwoBoardWithOneQueen(){
        FringeGenerationLogic fringeGenerationLogic = new FringeGenerationLogic();
        String emptyBoard = "Q.\n..";

        List<String> expectedBoards = List.of();
        List<String> actualBoards = fringeGenerationLogic.generateFringe(emptyBoard);
        assertTrue(expectedBoards.containsAll(actualBoards));
    }
}