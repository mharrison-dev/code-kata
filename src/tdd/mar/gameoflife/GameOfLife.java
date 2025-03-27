package tdd.mar.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife {
    private static final LiveCellWithFewerThanTwoNeighboursRule LIVE_CELL_WITH_FEWER_THAN_TWO_NEIGHBOURS_RULE = new LiveCellWithFewerThanTwoNeighboursRule();
    private static final LiveCellWithMoreThanThreeNeighboursRule LIVE_CELL_WITH_MORE_THAN_THREE_NEIGHBOURS_RULE = new LiveCellWithMoreThanThreeNeighboursRule();
    private static final DeadCellWithExactlyThreeNeighboursRule DEAD_CELL_WITH_EXACTLY_THREE_NEIGHBOURS_RULE = new DeadCellWithExactlyThreeNeighboursRule();
    private static final Rule[] RULE_SET = new Rule[]{LIVE_CELL_WITH_FEWER_THAN_TWO_NEIGHBOURS_RULE, LIVE_CELL_WITH_MORE_THAN_THREE_NEIGHBOURS_RULE, DEAD_CELL_WITH_EXACTLY_THREE_NEIGHBOURS_RULE};

    public int[][] update(int[][] board) {
        List<int[][]> partiallyUpdatedBoards = getPartiallyUpdatedBoards(board);
        List<int[][]> updateDifferenceBoards = getUpdateDifferenceBoards(board, partiallyUpdatedBoards);
        int[][] unifiedUpdateDifferenceBoard = getUnifiedUpdateDifferenceBoard(board, updateDifferenceBoards);
        return getFullyUpdatedBoard(board, unifiedUpdateDifferenceBoard);
    }

    private static int[][] getFullyUpdatedBoard(int[][] board, int[][] unifiedUpdateDifferenceBoard) {
        int[][] fullyUpdatedBoard = new int[board.length][board[0].length];
        for (int i = 0; i < fullyUpdatedBoard.length; i++) {
            for (int j = 0; j < fullyUpdatedBoard[i].length; j++) {
                if (unifiedUpdateDifferenceBoard[i][j] == 1) {
                    fullyUpdatedBoard[i][j] = (board[i][j] == 0) ? 1 : 0;
                } else {
                    fullyUpdatedBoard[i][j] = board[i][j];
                }
            }
        }

        return fullyUpdatedBoard;
    }

    private static int[][] getUnifiedUpdateDifferenceBoard(int[][] board, List<int[][]> updateDifferenceBoards) {
        int[][] unifiedUpdateDifferenceBoard = new int[board.length][board[0].length];
        for (int[][] updateDifferenceBoard : updateDifferenceBoards) {
            for (int i = 0; i < updateDifferenceBoard.length; i++) {
                for (int j = 0; j < updateDifferenceBoard[0].length; j++) {
                    unifiedUpdateDifferenceBoard[i][j] += updateDifferenceBoard[i][j];
                }
            }
        }

        return unifiedUpdateDifferenceBoard;
    }

    private static List<int[][]> getUpdateDifferenceBoards(int[][] board, List<int[][]> partiallyUpdatedBoards) {
        List<int[][]> updateDifferenceBoards = new ArrayList<>(RULE_SET.length);
        for (int[][] partiallyUpdatedBoard : partiallyUpdatedBoards) {
            int[][] updateDifferenceBoard = getUpdateDifferenceBoard(board, partiallyUpdatedBoard);
            updateDifferenceBoards.add(updateDifferenceBoard);
        }

        return updateDifferenceBoards;
    }

    private static int[][] getUpdateDifferenceBoard(int[][] board, int[][] partiallyUpdatedBoard) {
        int[][] updateDifferenceBoard = new int[board.length][board[0].length];
        for (int i = 0; i < updateDifferenceBoard.length; i++) {
            for (int j = 0; j < updateDifferenceBoard[i].length; j++) {
                if (partiallyUpdatedBoard[i][j] != board[i][j]) {
                    updateDifferenceBoard[i][j] = 1;
                }
            }
        }

        return updateDifferenceBoard;
    }

    private static List<int[][]> getPartiallyUpdatedBoards(int[][] board) {
        List<int[][]> partiallyUpdatedBoards = new ArrayList<>(RULE_SET.length);
        for (Rule rule : RULE_SET) {
            int[][] partiallyUpdatedBoard = rule.update(board);
            partiallyUpdatedBoards.add(partiallyUpdatedBoard);
        }

        return partiallyUpdatedBoards;
    }
}
