package tdd.feb.knucklebones;

import org.junit.jupiter.api.Test;

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
}