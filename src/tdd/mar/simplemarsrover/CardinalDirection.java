package tdd.mar.simplemarsrover;

public enum CardinalDirection {
    N(0, -1),
    W(1, 0),
    S(0, 1),
    E(-1, 0);

    public final int xOffset;
    public final int yOffset;

    CardinalDirection(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public CardinalDirection getLeftCardinalDirection() {
        int neighbourOrdinal = Math.floorMod(this.ordinal() - 1, CardinalDirection.values().length);
        return CardinalDirection.values()[neighbourOrdinal];
    }

    public CardinalDirection getRightCardinalDirection() {
        int neighbourOrdinal = Math.floorMod(this.ordinal() + 1, CardinalDirection.values().length);
        return CardinalDirection.values()[neighbourOrdinal];
    }
}
