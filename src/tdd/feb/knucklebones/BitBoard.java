package tdd.feb.knucklebones;

public class BitBoard {
    private static final byte BIT_TABLE_LENGTH = 64;
    private static final byte ROW_LENGTH = 9;
    private long bitTable;

    public long asLong() {
        return bitTable;
    }

    public void addDie(Side side, Row row, long dieValue) {
        int offset = BIT_TABLE_LENGTH - ROW_LENGTH * (2 * row.ordinal() + 1);
        bitTable = dieValue << offset;
    }
}
