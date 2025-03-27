package tdd.mar.gameoflife;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LiveCellWithFewerThanTwoNeighboursRuleTest extends tdd.mar.gameoflife.Test {
    @ParameterizedTest
    @MethodSource("getAllThreeByThreeBoardsThatHaveOneCellWithFewerThanTwoNeighbours")
    public void shouldKillCell_whenCellHasFewerThanTwoNeighbours(int[][] board) {
        LiveCellWithFewerThanTwoNeighboursRule liveCellWithFewerThanTwoNeighboursRule = new LiveCellWithFewerThanTwoNeighboursRule();

        int[][] expectedBoard = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] actualBoard = liveCellWithFewerThanTwoNeighboursRule.update(board);
        assertTrue(Arrays.deepEquals(expectedBoard, actualBoard), getErrorMessage(expectedBoard, actualBoard));
    }

    @ParameterizedTest
    @MethodSource("getThreeByThreeBoardsThatCellsWithTwoOrMoreNeighbours")
    public void shouldNotKillCell_whenCellHasTwoOrMoreNeighbours(int[][] board) {
        LiveCellWithFewerThanTwoNeighboursRule liveCellWithFewerThanTwoNeighboursRule = new LiveCellWithFewerThanTwoNeighboursRule();

        int[][] expectedBoard = board;
        int[][] actualBoard = liveCellWithFewerThanTwoNeighboursRule.update(board);
        assertTrue(Arrays.deepEquals(expectedBoard, actualBoard), getErrorMessage(expectedBoard, actualBoard));
    }

    private static Stream<Arguments> getAllThreeByThreeBoardsThatHaveOneCellWithFewerThanTwoNeighbours() {
        return Stream.of(
                arguments((Object) new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}),
                arguments((Object) new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 0}}),
                arguments((Object) new int[][]{{0, 1, 0}, {0, 1, 0}, {0, 0, 0}}),
                arguments((Object) new int[][]{{0, 0, 1}, {0, 1, 0}, {0, 0, 0}}),
                arguments((Object) new int[][]{{0, 0, 0}, {1, 1, 0}, {0, 0, 0}}),
                arguments((Object) new int[][]{{0, 0, 0}, {0, 1, 1}, {0, 0, 0}}),
                arguments((Object) new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 0, 0}}),
                arguments((Object) new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 1, 0}}),
                arguments((Object) new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 1}})
        );
    }

    private static Stream<Arguments> getThreeByThreeBoardsThatCellsWithTwoOrMoreNeighbours() {
        return Stream.of(
                arguments((Object) new int[][]{{1, 1, 0}, {1, 0, 0}, {0, 0, 0}}),
                arguments((Object) new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 0}})
        );
    }
}