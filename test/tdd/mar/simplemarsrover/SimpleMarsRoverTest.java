package tdd.mar.simplemarsrover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SimpleMarsRoverTest {
    private SimpleMarsRover simpleMarsRover = null;
    private final String startingPosition = "0:0:N";

    @BeforeEach
    public void setUp() {
        simpleMarsRover = new SimpleMarsRover();
    }

    @Test
    public void shouldReturnEmptyString_whenQueriedAboutStateBeforeLanding() {
        String expectedStateOfSimpleMarsRover = "";
        String actualStateOfSimpleMarsRover = simpleMarsRover.getState();
        assertEquals(expectedStateOfSimpleMarsRover, actualStateOfSimpleMarsRover);
    }

    @Test
    public void shouldLandAtCorrectGridPosition() {
        simpleMarsRover.landAt(startingPosition);

        String expectedGridPosition = "0:0";
        String stateOfSimpleMarsRover = simpleMarsRover.getState();
        assertTrue(stateOfSimpleMarsRover.startsWith(expectedGridPosition));
    }

    @Test
    public void shouldLandWithCorrectOrientation() {
        simpleMarsRover.landAt(startingPosition);

        String expectedOrientation = "N";
        String stateOfSimpleMarsRover = simpleMarsRover.getState();
        assertTrue(stateOfSimpleMarsRover.endsWith(expectedOrientation));
    }

    @Test
    public void shouldReportStateWithCorrectSyntax() {
        simpleMarsRover.landAt(startingPosition);

        String expectedState = startingPosition;
        String stateOfSimpleMarsRover = simpleMarsRover.getState();
        assertEquals(expectedState, stateOfSimpleMarsRover);
    }

    @ParameterizedTest
    @ValueSource(strings = {"NW", "WS", "SE", "EN"})
    public void shouldRotateRight(String initialAndFinalCardinalDirection) {
        String startingPosition = "0:0:" + initialAndFinalCardinalDirection.charAt(0);
        simpleMarsRover.landAt(startingPosition);
        simpleMarsRover.executeCommands("R");

        String expectedOrientation = initialAndFinalCardinalDirection.substring(1);
        String actualOrientationOfSimpleMarsRover = simpleMarsRover.getState().substring(4);
        assertEquals(expectedOrientation, actualOrientationOfSimpleMarsRover);
    }

    @ParameterizedTest
    @ValueSource(strings = {"NE", "ES", "SW", "WN"})
    public void shouldRotateLeft(String initialAndFinalCardinalDirection) {
        String startingPosition = "0:0:" + initialAndFinalCardinalDirection.charAt(0);
        simpleMarsRover.landAt(startingPosition);
        simpleMarsRover.executeCommands("L");

        String expectedOrientation = initialAndFinalCardinalDirection.substring(1);
        String actualOrientationOfSimpleMarsRover = simpleMarsRover.getState().substring(4);
        assertEquals(expectedOrientation, actualOrientationOfSimpleMarsRover);
    }

    @Test
    public void shouldRotateTwiceFromOneMessage() {
        simpleMarsRover.landAt(startingPosition);
        simpleMarsRover.executeCommands("LL");

        String expectedOrientation = "S";
        String actualOrientationOfSimpleMarsRover = simpleMarsRover.getState().substring(4);
        assertEquals(expectedOrientation, actualOrientationOfSimpleMarsRover);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0:1:N,0:0:N", "0:0:W,1:0:W", "0:0:S,0:1:S", "1:0:E,0:0:E"})
    public void shouldMoveForwardInCurrentDirection(String example) {
        String startingPosition = example.split(",")[0];
        simpleMarsRover.landAt(startingPosition);
        simpleMarsRover.executeCommands("M");

        String expectedState = example.split(",")[1];
        String actualStateOfSimpleMarsRover = simpleMarsRover.getState();
        assertEquals(expectedState, actualStateOfSimpleMarsRover);
    }
}