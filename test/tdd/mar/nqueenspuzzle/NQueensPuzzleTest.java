package tdd.mar.nqueenspuzzle;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NQueensPuzzleTest {
    @Test
    public void shouldReturnOneBoard_whenGivenEmptyOneByOneBoard() {
        String board = ".";
        NQueensPuzzle nQueensPuzzle = new NQueensPuzzle();

        List<String> expectedSolutionList = List.of("Q");
        List<String> actualSolutionList = nQueensPuzzle.solve(board);
        assertTrue(expectedSolutionList.containsAll(actualSolutionList));
    }

    @Test
    public void shouldReturnNoBoard_whenGivenEmptyTwoByTwoBoard(){
        String board = "..\n..";
        NQueensPuzzle nQueensPuzzle = new NQueensPuzzle();

        List<String> actualSolutionList = nQueensPuzzle.solve(board);
        assertTrue(actualSolutionList.isEmpty());
    }
}