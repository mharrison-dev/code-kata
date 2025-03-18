package tdd.mar.tennisscorecalculator;

public class TennisScoreCalculator {
    private final String[] terminologyForEachPointBelowFour = {"Love", "Fifteen", "Thirty", "Forty"};

    public String score(int playerOnePoints, int playerTwoPoints) {
        if (playerOnePoints == 0 && playerTwoPoints == 0) {
            return "Love All";
        }

        if (playerOnePoints == playerTwoPoints && playerOnePoints >= 3) {
            return "Deuce";
        }

        if (playerOnePoints >= 3 && playerTwoPoints >= 3 && playerOnePoints - playerTwoPoints == 1) {
            return "Advantage Player One";
        }

        if (playerOnePoints >= 3 && playerTwoPoints >= 3 && playerTwoPoints - playerOnePoints == 1) {
            return "Advantage Player Two";
        }

        if (playerOnePoints >= 4 && playerOnePoints - playerTwoPoints >= 2) {
            return "Win Player One";
        }

        if (playerTwoPoints >= 4 && playerTwoPoints - playerOnePoints >= 2) {
            return "Win Player Two";
        }

        return terminologyForEachPointBelowFour[playerOnePoints] + "-" + terminologyForEachPointBelowFour[playerTwoPoints];
    }
}
