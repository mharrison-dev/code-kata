package tdd.mar.gameoflife;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DeadCellWithExactlyThreeNeighboursRuleTest extends RuleTest {
    @ParameterizedTest
    @MethodSource("getBoardsWithDeadCellsThatHaveFewerThanThreeLiveNeighbours")
    public void shouldNotReviveAnyDeadCell_whenDeadCellsHaveFewerThanThreeLiveNeighbours(int[][] board) {
        DeadCellWithExactlyThreeNeighboursRule deadCellWithExactlyThreeNeighboursRule = new DeadCellWithExactlyThreeNeighboursRule();

        int[][] expectedBoard = board;
        int[][] actualBoard = deadCellWithExactlyThreeNeighboursRule.update(board);
        assertTrue(Arrays.deepEquals(expectedBoard, actualBoard), getErrorMessage(expectedBoard, actualBoard));
    }

    @ParameterizedTest
    @MethodSource("getBoardsWithDeadCellsThatHaveExactlyThreeLiveNeighbours")
    public void shouldReviveAnyDeadCell_whenDeadCellsHaveExactlyThreeNeighbours(int[][] board) {
        DeadCellWithExactlyThreeNeighboursRule deadCellWithExactlyThreeNeighboursRule = new DeadCellWithExactlyThreeNeighboursRule();

        int[][] expectedBoard = reviveCenterCell(board);
        int[][] actualBoard = deadCellWithExactlyThreeNeighboursRule.update(board);
        assertTrue(Arrays.deepEquals(expectedBoard, actualBoard), getErrorMessage(expectedBoard, actualBoard));
    }

    private static Stream<Arguments> getBoardsWithDeadCellsThatHaveFewerThanThreeLiveNeighbours() {
        return Stream.of(
                arguments((Object) new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}),
                arguments((Object) new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}}),
                arguments((Object) new int[][]{{0, 0, 0}, {1, 0, 1}, {0, 0, 0}})
        );
    }

    private static Stream<Arguments> getBoardsWithDeadCellsThatHaveExactlyThreeLiveNeighbours() {
        return Stream.of(
                arguments((Object) new int[][]{{1, 0, 1}, {0, 0, 0}, {0, 1, 0}}),
                arguments((Object) new int[][]{{0, 1, 0}, {0, 0, 1}, {0, 0, 1}}),
                arguments((Object) new int[][]{{0, 0, 1}, {1, 0, 0}, {1, 0, 0}})
        );
    }

    private int[][] reviveCenterCell(int[][] board) {
        int[][] boardCopy = board.clone();
        for (int i = 0; i < board.length; i++) {
            boardCopy[i] = boardCopy[i].clone();
        }

        boardCopy[1][1] = 1;
        return boardCopy;
    }
}