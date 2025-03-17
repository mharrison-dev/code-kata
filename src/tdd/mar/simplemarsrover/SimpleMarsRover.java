package tdd.mar.simplemarsrover;

public class SimpleMarsRover {
    private String state = "";

    public void landAt(String startingPosition) {
        state = startingPosition.substring(0, 3);
    }

    public String getState() {
        return state;
    }
}
