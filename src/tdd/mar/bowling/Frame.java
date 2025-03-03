package tdd.mar.bowling;

public class Frame {
    private boolean isSpare = false;
    private boolean isStrike = false;
    private int numberOfRolls = 0;
    private int totalScore = 0;

    public int getScore() {
        return totalScore;
    }

    public void addScoreForRoll(int score) {
        totalScore += score;
        numberOfRolls++;

        if (numberOfRolls == 1 && score == 10) {
            isStrike = true;
        }

        if (numberOfRolls == 2 && score > 0 && totalScore == 10) {
            isSpare = true;
        }
    }

    public boolean isSpare() {
        return isSpare;
    }

    public boolean isStrike() {
        return isStrike;
    }
}
