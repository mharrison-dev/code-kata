package tdd.mar.bowling;

public class Frame {
    private int score = 0;

    public int getScore() {
        return score;
    }

    public void addScoreForRoll(int score) {
        this.score = score;
    }
}
