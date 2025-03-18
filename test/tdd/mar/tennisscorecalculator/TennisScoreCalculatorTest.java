package tdd.mar.tennisscorecalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {"0,Love", "1,Fifteen", "2,Thirty", "3,Forty"})
    public void shouldReturnRespectiveScoreForEachPointBelowFour_forPlayerOne(String example) {
        int playerOnePoints = Integer.parseInt(example.split(",")[0]);
        int playerTwoPoints = 1;
        TennisScoreCalculator tennisScoreCalculator = new TennisScoreCalculator();

        String expectedScore = example.split(",")[1] + "-Fifteen";
        String actualScore = tennisScoreCalculator.score(playerOnePoints, playerTwoPoints);
        assertEquals(expectedScore, actualScore);
    }
}