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

        int[] numberOfQueensInEachFile = countNumberOfQueensInEachFile(board);
        if (!foundElementLargerThanOne(numberOfQueensInEachFile)) {
            return false;
        }

        int[] numberOfQueensInEachRightDiagonal = countNumberOfQueensInEachRightDiagonal(board);
        if (!foundElementLargerThanOne(numberOfQueensInEachRightDiagonal)) {
            return false;
        }

        int[] numberOfQueensInEachLeftDiagonal = countNumberOfQueensInEachLeftDiagonal(board);
        if (!foundElementLargerThanOne(numberOfQueensInEachLeftDiagonal)) {
            return false;
        }

        return true;
    }

    private int[] countNumberOfQueensInEachLeftDiagonal(String board) {
        int[] numberOfQueensInEachLeftDiagonal = new int[board.indexOf("\n")];
        String[] ranks = board.split("\n");
        for (int i = 0; i < ranks.length; i++) {
            String rank = ranks[i];
            String shiftedRank = shift(-i, rank);
            for (int j = 0; j < shiftedRank.length() - i; j++) {
                if (shiftedRank.charAt(j) == 'Q') {
                    numberOfQueensInEachLeftDiagonal[j]++;
                }
            }
        }
        return numberOfQueensInEachLeftDiagonal;
    }

    private int[] countNumberOfQueensInEachRightDiagonal(String board) {
        int[] numberOfQueensInEachRightDiagonal = new int[board.indexOf("\n")];
        String[] ranks = board.split("\n");
        for (int i = 0; i < ranks.length; i++) {
            String rank = ranks[i];
            String shiftedRank = shift(i, rank);
            for (int j = i; j < shiftedRank.length(); j++) {
                if (shiftedRank.charAt(j) == 'Q') {
                    numberOfQueensInEachRightDiagonal[j]++;
                }
            }
        }
        return numberOfQueensInEachRightDiagonal;
    }

    private static int[] countNumberOfQueensInEachFile(String board) {
        int[] numberOfQueensInEachFile = new int[board.indexOf("\n")];
        for (String rank : board.split("\n")) {
            for (int i = 0; i < rank.length(); i++) {
                if (rank.charAt(i) == 'Q') {
                    numberOfQueensInEachFile[i]++;
                }
            }
        }
        return numberOfQueensInEachFile;
    }

    private String shift(int offset, String string) {
        String shiftedString = string;
        for (int i = 0; i < Math.abs(offset); i++) {
            shiftedString = (offset < 0)
                    ? leftShift(shiftedString)
                    : rightShift(shiftedString);
        }

        return shiftedString;
    }

    private String leftShift(String string) {
        return string.substring(1) + ".";
    }

    private String rightShift(String string) {
        return "." + string.substring(0, string.length() - 1);
    }

    private boolean foundElementLargerThanOne(int[] array) {
        return Arrays.stream(array)
                .filter(x -> x > 1)
                .findFirst()
                .isEmpty();
    }
}