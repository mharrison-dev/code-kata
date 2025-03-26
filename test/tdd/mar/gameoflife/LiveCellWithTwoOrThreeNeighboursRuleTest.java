package tdd.mar.gameoflife;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LiveCellWithTwoOrThreeNeighboursRuleTest {
    @ParameterizedTest
    @MethodSource("getAllThreeByThreeBoardsThatHaveOneCellWithTwoNeighboursOnOpposingSides")
    public void shouldNotKillCell_whenCellHasTwoNeighboursOnOpposingSides(int[][] board) {
        LiveCellWithTwoOrThreeNeighboursRule liveCellWithTwoOrThreeNeighboursRule = new LiveCellWithTwoOrThreeNeighboursRule();

        int[][] expectedBoard = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] actualBoard = liveCellWithTwoOrThreeNeighboursRule.update(board);
        assertTrue(Arrays.deepEquals(expectedBoard, actualBoard), getErrorMessage(expectedBoard, actualBoard));
    }

    private static Stream<Arguments> getAllThreeByThreeBoardsThatHaveOneCellWithTwoNeighboursOnOpposingSides() {
        return Stream.of(
                arguments((Object) new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}),
                arguments((Object) new int[][]{{0, 1, 0}, {0, 1, 0}, {0, 1, 0}}),
                arguments((Object) new int[][]{{0, 0, 1}, {0, 1, 0}, {1, 0, 0}}),
                arguments((Object) new int[][]{{0, 0, 0}, {1, 1, 1}, {0, 0, 0}})
        );
    }

    private String getErrorMessage(int[][] expectedBoard, int[][] actualBoard) {
        return "\nExpected: " + Arrays.deepToString(expectedBoard) + "\nActual: " + Arrays.deepToString(actualBoard);
    }
}