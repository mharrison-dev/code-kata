package tdd.mar.bowling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrameTest {
    @Test
    public void getScore() {
        Frame frame = new Frame();

        int expectedScore = 0;
        int actualScore = frame.getScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void addScoreForFirstRoll() {
        Frame frame = new Frame();
        int scoreOfFirstRoll = 1;
        frame.addScoreForRoll(scoreOfFirstRoll);

        int expectedScore = scoreOfFirstRoll;
        int actualScore = frame.getScore();
        assertEquals(expectedScore, actualScore);
    }
}