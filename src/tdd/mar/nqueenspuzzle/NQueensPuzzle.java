package tdd.mar.nqueenspuzzle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NQueensPuzzle {
    private static final FringeGenerationLogic FRINGE_GENERATION_LOGIC = new FringeGenerationLogic();

    public List<String> solve(String board) {
        int boardDimension = calculateBoardDimension(board);
        List<String> solutions = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.push(board);
        while (!stack.isEmpty()) {
            String currentBoard = stack.pop();

            List<String> fringe = FRINGE_GENERATION_LOGIC.generateFringe(currentBoard);
            for (String newBoard : fringe) {
                stack.push(newBoard);
            }

            int numberOfQueens = countNumberOfQueens(currentBoard);
            if (numberOfQueens == boardDimension) {
                solutions.add(currentBoard);
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