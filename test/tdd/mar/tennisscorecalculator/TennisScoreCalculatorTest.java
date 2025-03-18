package tdd.mar.tennisscorecalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TennisScoreCalculatorTest {
    private TennisScoreCalculator tennisScoreCalculator = null;

    @BeforeEach
    public void setUp() {
        tennisScoreCalculator = new TennisScoreCalculator();
    }

    @Test
    public void shouldReturnLoveAll_whenBothPlayersHaveScoredZeroPoints() {
        int playerOnePoints = 0;
        int playerTwoPoints = 0;

        String expectedScore = "Love All";
        String actualScore = tennisScoreCalculator.score(playerOnePoints, playerTwoPoints);
        assertEquals(expectedScore, actualScore);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,Love", "1,Fifteen", "2,Thirty", "3,Forty"})
    public void shouldReturnRespectiveScoreForEachPointBelowFour_forPlayerOne(String example) {
        int playerOnePoints = Integer.parseInt(example.split(",")[0]);
        int playerTwoPoints = 1;

        String expectedScore = example.split(",")[1] + "-Fifteen";
        String actualScore = tennisScoreCalculator.score(playerOnePoints, playerTwoPoints);
        assertEquals(expectedScore, actualScore);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,Love", "1,Fifteen", "2,Thirty", "3,Forty"})
    public void shouldReturnRespectiveScoreForEachPointBelowFour_forPlayerTwo(String example) {
        int playerOnePoints = 1;
        int playerTwoPoints = Integer.parseInt(example.split(",")[0]);

        String expectedScore = "Fifteen-" + example.split(",")[1];
        String actualScore = tennisScoreCalculator.score(playerOnePoints, playerTwoPoints);
        assertEquals(expectedScore, actualScore);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3,3", "4,4"})
    public void shouldReturnDeuce_whenEachPlayerHasScoreAtLeastThreePointsAndHasSameAmountOfPoints(String points) {
        int playerOnePoints = Integer.parseInt(points.split(",")[0]);
        int playerTwoPoints = Integer.parseInt(points.split(",")[1]);

        String expectedScore = "Deuce";
        String actualScore = tennisScoreCalculator.score(playerOnePoints, playerTwoPoints);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void shouldReturnAdvantagePlayerOne_whenEachPlayHasScoredAtLeastThreePointsAndPlayerOneHasScoredOneMorePointThanPlayerTwo() {
        int playerOnePoints = 4;
        int playerTwoPoints = 3;

        String expectedScore = "Advantage Player One";
        String actualScore = tennisScoreCalculator.score(playerOnePoints, playerTwoPoints);
        assertEquals(expectedScore, actualScore);
    }
}