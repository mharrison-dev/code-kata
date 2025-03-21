package tdd.mar.nqueenspuzzle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BoardValidationLogicTest {
    private BoardValidationLogic boardValidationLogic;

    @BeforeEach
    public void setUp() {
        boardValidationLogic = new BoardValidationLogic();
    }

    @ParameterizedTest
    @ValueSource(strings = {".", "..\n..", "...\n...\n..."})
    public void shouldReturnTrue_whenGivenEmptyBoard(String emptyBoard) {
        boolean result = boardValidationLogic.validate(emptyBoard);
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalse_whenBoardContainsTwoQueensOnOneRank() {
        String boardWithTwoQueensOnOneRank = "QQ\n..";

        boolean result = boardValidationLogic.validate(boardWithTwoQueensOnOneRank);
        assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Q", "..\n.Q", "...\n...\n..Q"})
    public void shouldReturnTrue_whenBoardContainsOneQueen(String boardWithOneQueen) {
        boolean result = boardValidationLogic.validate(boardWithOneQueen);
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalse_whenBoardContainsTwoQueensOnOneFile() {
        String boardWithTwoQueensOnOnFile = "Q.\nQ.";

        boolean result = boardValidationLogic.validate(boardWithTwoQueensOnOnFile);
        assertFalse(result);
    }
}