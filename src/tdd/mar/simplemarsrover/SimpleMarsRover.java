package tdd.mar.simplemarsrover;

public class SimpleMarsRover {
    private String state = "";

    public void landAt(String startingPosition) {
        state = startingPosition.substring(0, 3) + startingPosition.substring(4);
    }

    public String getState() {
        return state;
    }
}
