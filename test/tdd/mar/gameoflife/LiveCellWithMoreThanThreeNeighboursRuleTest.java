package tdd.mar.gameoflife;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LiveCellWithMoreThanThreeNeighboursRuleTest extends tdd.mar.gameoflife.Test {
    @ParameterizedTest
    @MethodSource("getBoardsWithLiveCenterCellThatHasMoreThanThreeNeighbours")
    public void shouldKillCell_whenCellHasMoreThanThreeNeighbours(int[][] board) {
        LiveCellWithMoreThanThreeNeighboursRule liveCellWithMoreThanThreeNeighboursRule = new LiveCellWithMoreThanThreeNeighboursRule();

        int[][] expectedBoard = killCenterCell(board);
        int[][] actualBoard = liveCellWithMoreThanThreeNeighboursRule.update(board);
        assertTrue(Arrays.deepEquals(expectedBoard, actualBoard), getErrorMessage(expectedBoard, actualBoard));
    }

    @org.junit.jupiter.api.Test
    public void shouldKillAllCellsAtOnce_whenGivenBoardWithMultipleTargets() {
        int[][] board = {
                {0, 0, 0},
                {0, 1, 1},
                {1, 1, 1}
        };
        LiveCellWithMoreThanThreeNeighboursRule liveCellWithMoreThanThreeNeighboursRule = new LiveCellWithMoreThanThreeNeighboursRule();

        int[][] expectedBoard = {
                {0, 0, 0},
                {0, 0, 1},
                {1, 0, 1}
        };
        int[][] actualBoard = liveCellWithMoreThanThreeNeighboursRule.update(board);
        assertTrue(Arrays.deepEquals(expectedBoard, actualBoard), getErrorMessage(expectedBoard, actualBoard));
    }

    private static Stream<Arguments> getBoardsWithLiveCenterCellThatHasMoreThanThreeNeighbours() {
        return Stream.of(
                arguments((Object) new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}}),
                arguments((Object) new int[][]{{1, 1, 1}, {0, 1, 0}, {1, 0, 0}}),
                arguments((Object) new int[][]{{1, 1, 0}, {0, 1, 1}, {1, 0, 1}})
        );
    }

    private int[][] killCenterCell(int[][] board) {
        int[][] boardCopy = board.clone();
        for (int i = 0; i < board.length; i++) {
            boardCopy[i] = boardCopy[i].clone();
        }

        boardCopy[1][1] = 0;
        return boardCopy;
    }
}