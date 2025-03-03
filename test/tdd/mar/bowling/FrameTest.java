package tdd.mar.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrameTest {
    private Frame frame = null;

    @BeforeEach
    public void setUp() {
        frame = new Frame();
    }

    @Test
    public void getScore() {
        int expectedScore = 0;
        int actualScore = frame.getScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void addScoreForFirstRoll() {
        int scoreOfFirstRoll = 1;
        frame.addScoreForRoll(scoreOfFirstRoll);

        int expectedScore = scoreOfFirstRoll;
        int actualScore = frame.getScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void addScoreForSecondRoll() {
        int scoreOfFirstRoll = 1;
        frame.addScoreForRoll(scoreOfFirstRoll);
        int scoreOfSecondRoll = 2;
        frame.addScoreForRoll(scoreOfSecondRoll);

        int expectedScore = scoreOfFirstRoll + scoreOfSecondRoll;
        int actualScore = frame.getScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void isNotSpareWhenScoreOfFirstRollEqualsTen() {
        int scoreOfFirstRoll = 10;
        frame.addScoreForRoll(scoreOfFirstRoll);

        assertFalse(frame.isSpare());
    }

    @Test
    public void isNotSpareWhenScoreOfFirstRollEqualsTenAndSecondRollEqualsZero() {
        int scoreOfFirstRoll = 10;
        frame.addScoreForRoll(scoreOfFirstRoll);
        int scoreOfSecondRoll = 0;
        frame.addScoreForRoll(scoreOfSecondRoll);

        assertFalse(frame.isSpare());
    }

    @Test
    public void isSpare() {
        int scoreOfFirstRoll = 5;
        frame.addScoreForRoll(scoreOfFirstRoll);
        int scoreOfSecondRoll = 5;
        frame.addScoreForRoll(scoreOfSecondRoll);

        assertTrue(frame.isSpare());
    }

    @Test
    public void isStrike() {
        int scoreOfFirstRoll = 10;
        frame.addScoreForRoll(scoreOfFirstRoll);

        assertTrue(frame.isStrike());
    }

    @Test
    public void isNotStrikeWhenScoreOfFirstRollEqualsZeroAndSecondRollEqualsTen() {
        int scoreOfFirstRoll = 0;
        frame.addScoreForRoll(scoreOfFirstRoll);
        int scoreOfSecondRoll = 10;
        frame.addScoreForRoll(scoreOfSecondRoll);

        assertFalse(frame.isStrike());
    }

    @Test
    public void throwExceptionWhenRollLimitIsExceededForNormalFrame() {
        try {
            int scoreOfFirstRoll = 1;
            frame.addScoreForRoll(scoreOfFirstRoll);
            int scoreOfSecondRoll = 2;
            frame.addScoreForRoll(scoreOfSecondRoll);
            int scoreOfThirdRoll = 3;
            frame.addScoreForRoll(scoreOfThirdRoll);
            fail("Expected an ExceededRollLimitException to be thrown");
        } catch (Exception e) {
            String expectedExceptionMessage = "Exceeded roll limit of: 2";
            String actualExceptionMessage = e.getMessage();
            assertEquals(expectedExceptionMessage, actualExceptionMessage);
        }
    }

    @Test
    public void throwExceptionWhenRollLimitIsExceededForSpareFrame() {
        try {
            int scoreOfFirstRoll = 5;
            frame.addScoreForRoll(scoreOfFirstRoll);
            int scoreOfSecondRoll = 5;
            frame.addScoreForRoll(scoreOfSecondRoll);
            int scoreOfThirdRoll = 3;
            frame.addScoreForRoll(scoreOfThirdRoll);
            int scoreOfFourthRoll = 4;
            frame.addScoreForRoll(scoreOfFourthRoll);
            fail("Expected an ExceededRollLimitException to be thrown");
        } catch (Exception e) {
            String expectedExceptionMessage = "Exceeded roll limit of: 3";
            String actualExceptionMessage = e.getMessage();
            assertEquals(expectedExceptionMessage, actualExceptionMessage);
        }
    }
}