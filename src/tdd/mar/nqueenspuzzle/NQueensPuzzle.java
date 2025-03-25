package tdd.mar.nqueenspuzzle;

import java.util.ArrayList;
import java.util.List;

public class NQueensPuzzle {
    private static final FringeGenerationLogic FRINGE_GENERATION_LOGIC = new FringeGenerationLogic();

    public List<String> solve(String board) {
        int boardDimension = calculateBoardDimension(board);
        List<String> solutions = new ArrayList<>();
        List<String> fringe = FRINGE_GENERATION_LOGIC.generateFringe(board);
        for (String newBoard : fringe) {
            int numberOfQueens = countNumberOfQueens(newBoard);
            if (numberOfQueens == boardDimension) {
                solutions.add(newBoard);
            }
        }

        return solutions;
    }

    private int calculateBoardDimension(String board) {
        return (board.length() == 1)
                ? 1
                : board.indexOf("\n");
    }

    private int countNumberOfQueens(String board) {
        int numberOfQueens = 0;
        for (String string : board.split("")) {
            if (string.equals("Q")) {
                numberOfQueens++;
            }
        }

        return numberOfQueens;
    }
}