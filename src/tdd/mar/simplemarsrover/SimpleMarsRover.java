package tdd.mar.simplemarsrover;

public class SimpleMarsRover {
    private String state = "";

    public void landAt(String startingPosition) {
        state = startingPosition;
    }

    public String getState() {
        return state;
    }
}
