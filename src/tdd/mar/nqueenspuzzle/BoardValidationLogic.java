package tdd.mar.nqueenspuzzle;

public class BoardValidationLogic {
    public boolean validate(String board) {
        String emptyBoardRegex = "^([.]+(\n|$))+";
        if (board.matches(emptyBoardRegex)) {
            return true;
        }

        for (String rank : board.split("\n")) {
            String rankWithTwoQueensRegex = "^.*Q.*Q.*";
            if (rank.matches(rankWithTwoQueensRegex)) {
                return false;
            }
        }

        return true;
    }
}
