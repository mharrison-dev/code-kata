package tdd.mar.nqueenspuzzle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BoardValidationLogicTest {
    @ParameterizedTest
    @ValueSource(strings = {".", "..\n..", "...\n...\n..."})
    public void shouldReturnTrue_whenGivenEmptyBoard(String emptyBoard) {
        BoardValidationLogic boardValidationLogic = new BoardValidationLogic();

        boolean result = boardValidationLogic.validate(emptyBoard);
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalse_whenBoardContainsTwoQueensOnOneRank() {
        String boardWithTwoQueensOnOneRank = "QQ\n..";
        BoardValidationLogic boardValidationLogic = new BoardValidationLogic();

        boolean result = boardValidationLogic.validate(boardWithTwoQueensOnOneRank);
        assertFalse(result);
    }
}