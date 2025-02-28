package tdd.feb.knucklebones;

public class BitBoard {
    private long bitTable;

    public long asLong() {
        return bitTable;
    }

    public void addDie(Side side, Row row, long dieValue) {
        bitTable = 1L << 55;
    }
}
