package tdd.mar.nqueenspuzzle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NQueensPuzzleTest {
    private NQueensPuzzle nQueensPuzzle = null;

    @BeforeEach
    public void setUp() {
        nQueensPuzzle = new NQueensPuzzle();
    }

    @Test
    public void shouldReturnOneBoard_whenGivenEmptyOneByOneBoard() {
        String board = ".";

        List<String> expectedSolutionList = List.of("Q");
        List<String> actualSolutionList = nQueensPuzzle.solve(board);
        assertFalse(actualSolutionList.isEmpty());
        assertTrue(expectedSolutionList.containsAll(actualSolutionList));
    }

    @Test
    public void shouldReturnNoBoard_whenGivenEmptyTwoByTwoBoard() {
        String board = "..\n..";

        List<String> actualSolutionList = nQueensPuzzle.solve(board);
        assertTrue(actualSolutionList.isEmpty());
    }

    @Test
    public void shouldReturnTwoBoards_whenGivenEmptyFourByFourBoard() {
        String board = "....\n....\n....\n....";

        List<String> expectedSolutionList = List.of(".Q..\n...Q\nQ...\n..Q.", "..Q.\nQ...\n...Q\n.Q..");
        List<String> actualSolutionList = nQueensPuzzle.solve(board);
        assertFalse(actualSolutionList.isEmpty());
        assertTrue(expectedSolutionList.containsAll(actualSolutionList));
    }
}