package tdd.mar.simplemarsrover;

public class SimpleMarsRover {
    private String firstPortionOfState = "";
    private int cardinalDirectionIndex = -1;
    private final static String[] CARDINAL_DIRECTIONS_IN_CLOCKWISE_ORDER = {"N", "E", "S", "W"};

    public void landAt(String startingPosition) {
        String cardinalDirection = startingPosition.substring(4);
        cardinalDirectionIndex = getIndexFor(cardinalDirection);

        firstPortionOfState = startingPosition.substring(0, 4);
    }

    private int getIndexFor(String cardinalDirection) {
        for (int i = 0; i < CARDINAL_DIRECTIONS_IN_CLOCKWISE_ORDER.length; i++) {
            if (CARDINAL_DIRECTIONS_IN_CLOCKWISE_ORDER[i].equals(cardinalDirection)) {
                return i;
            }
        }

        return -1;
    }

    public String getState() {
        return firstPortionOfState + getCardinalDirectionFor(cardinalDirectionIndex);
    }

    private String getCardinalDirectionFor(int cardinalDirectionIndex) {
        if (cardinalDirectionIndex == -1) {
            return "";
        }

        return CARDINAL_DIRECTIONS_IN_CLOCKWISE_ORDER[cardinalDirectionIndex];
    }

    public void executeCommands(String commands) {
        if (commands.contains("L")) {
            cardinalDirectionIndex = Math.floorMod(cardinalDirectionIndex - 1, CARDINAL_DIRECTIONS_IN_CLOCKWISE_ORDER.length);
        } else {
            cardinalDirectionIndex = Math.floorMod(cardinalDirectionIndex + 1, CARDINAL_DIRECTIONS_IN_CLOCKWISE_ORDER.length);
        }
    }
}
