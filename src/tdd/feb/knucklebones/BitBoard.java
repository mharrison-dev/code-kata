package tdd.feb.knucklebones;

public class BitBoard {
    private static final byte WORD_LENGTH = 64;
    private static final byte ROW_LENGTH = 9;
    private long bitTable;

    public long asLong() {
        return bitTable;
    }

    public void addDie(Side side, Row row, long dieValue) {
        int offset;
        if (row.equals(Row.TOP)) {
            offset = WORD_LENGTH - ROW_LENGTH;
        } else {
            offset = WORD_LENGTH - ROW_LENGTH * 3;
        }
        bitTable = dieValue << offset;
    }
}
