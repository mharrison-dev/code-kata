package tdd.mar.simplemarsrover;

public class SimpleMarsRover {
    private boolean landed = false;
    private int xPosition = -1;
    private int yPosition = -1;
    private CardinalDirection cardinalDirection = null;

    public void landAt(String startingPosition) {
        landed = true;

        String xPositionComponent = startingPosition.substring(0, 1);
        xPosition = Integer.parseInt(xPositionComponent);

        String yPositionComponent = startingPosition.substring(2, 3);
        yPosition = Integer.parseInt(yPositionComponent);

        String orientationComponent = startingPosition.substring(4);
        cardinalDirection = CardinalDirection.valueOf(orientationComponent);
    }

    public String getState() {
        if (!landed) {
            return "";
        }

        return xPosition + ":" + yPosition + ":" + cardinalDirection;
    }

    public void executeCommands(String commands) {
        for (String command : commands.split("")) {
            if (command.equals("L")) {
                cardinalDirection = cardinalDirection.getLeftCardinalDirection();
            } else if (command.equals("R")) {
                cardinalDirection = cardinalDirection.getRightCardinalDirection();
            } else {
                xPosition = Math.floorMod(xPosition + cardinalDirection.xOffset, 10);
                yPosition = Math.floorMod(yPosition + cardinalDirection.yOffset, 10);
            }
        }
    }
}
