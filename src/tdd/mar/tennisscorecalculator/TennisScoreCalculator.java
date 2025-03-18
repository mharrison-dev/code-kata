package tdd.mar.tennisscorecalculator;

public class TennisScoreCalculator {
    private String[] terminologyForEachPointBelowFour = {"Love", "Fifteen", "Thirty", "Forty"};

    public String score(int playerOnePoints, int playerTwoPoints) {
        if (playerOnePoints == 0 && playerTwoPoints == 0) {
            return "Love All";
        }

        return terminologyForEachPointBelowFour[playerOnePoints] + "-Fifteen";
    }
}
