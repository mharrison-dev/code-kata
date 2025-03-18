package tdd.mar.tennisscorecalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TennisScoreCalculatorTest {
    @Test
    public void shouldReturnLoveAll_whenBothPlayersHaveScoredZeroPoints() {
        int playerOnePoints = 0;
        int playerTwoPoints = 0;
        TennisScoreCalculator tennisScoreCalculator = new TennisScoreCalculator();

        String expectedScore = "Love All";
        String actualScore = tennisScoreCalculator.score(playerOnePoints, playerTwoPoints);
        assertEquals(expectedScore, actualScore);
    }
}