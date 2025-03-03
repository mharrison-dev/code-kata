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
}