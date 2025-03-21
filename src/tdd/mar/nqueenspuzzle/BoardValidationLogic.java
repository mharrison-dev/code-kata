package tdd.mar.nqueenspuzzle;

import java.util.Arrays;

public class BoardValidationLogic {
    public boolean validate(String board) {
        if (board.length() == 1) {
            return true;
        }

        String emptyBoardRegex = "^([.]+(\n|$))+";
        if (board.matches(emptyBoardRegex)) {
            return true;
        }

        String rankWithTwoQueensRegex = "^.*Q.*Q.*";
        for (String rank : board.split("\n")) {
            if (rank.matches(rankWithTwoQueensRegex)) {
                return false;
            }
        }

        int[] numberOfQueensInEachFile = new int[board.indexOf("\n")];
        for (String rank : board.split("\n")) {
            for (int i = 0; i < rank.length(); i++) {
                if (rank.charAt(i) == 'Q') {
                    numberOfQueensInEachFile[i]++;
                }
            }
        }

        return Arrays.stream(numberOfQueensInEachFile)
                .filter(x -> x > 1)
                .findFirst().isEmpty();
    }
}
