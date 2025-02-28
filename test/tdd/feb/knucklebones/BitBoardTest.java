package tdd.feb.knucklebones;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    /*
    Bit Board Format
        | Bit Table                 | Row Bit Indices |
        | 000-000-000 : 000-000-000 |               0 |
        | 000-000-000 : 000-000-000 |              18 |
        | 000-000-000 : 000-000-000 |              36 |
    */

    @Test
    public void getBitTable() {
        BitBoard bitBoard = new BitBoard();
        long expectedBitBoard = 0L;
        long actualBitBoard = bitBoard.asLong();
        assertEquals(expectedBitBoard, actualBitBoard);
    }

    @Test
    public void addDie() {
        Side playerOneSide = Side.PLAYER_ONE_SIDE;
        Row topRow = Row.TOP;
        long dieValue = 1L;

        BitBoard bitBoard = new BitBoard();
        bitBoard.addDie(playerOneSide, topRow, dieValue);

        long expectedBitBoard = dieValue << 55;
        long actualBitBoard = bitBoard.asLong();
        assertEquals(expectedBitBoard, actualBitBoard);
    }

    @Test
    public void addDieWithValueOfTwo() {
        Side playerOneSide = Side.PLAYER_ONE_SIDE;
        Row topRow = Row.TOP;
        long dieValue = 2L;

        BitBoard bitBoard = new BitBoard();
        bitBoard.addDie(playerOneSide, topRow, dieValue);

        long expectedBitBoard = dieValue << 55;
        long actualBitBoard = bitBoard.asLong();
        assertEquals(expectedBitBoard, actualBitBoard);
    }
}