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
    public void shouldRotateLeft(String initialAndFinalCardinalDirection) {
        String startingPosition = "0:0:" + initialAndFinalCardinalDirection.charAt(0);
        simpleMarsRover.landAt(startingPosition);
        simpleMarsRover.executeCommands("L");

        String expectedOrientation = initialAndFinalCardinalDirection.substring(1);
        String actualOrientationOfSimpleMarsRover = simpleMarsRover.getState().substring(4);
        assertEquals(expectedOrientation, actualOrientationOfSimpleMarsRover);
    }

    @ParameterizedTest
    @ValueSource(strings = {"NE", "ES", "SW", "WN"})
    public void shouldRotateRight(String initialAndFinalCardinalDirection) {
        String startingPosition = "0:0:" + initialAndFinalCardinalDirection.charAt(0);
        simpleMarsRover.landAt(startingPosition);
        simpleMarsRover.executeCommands("R");

        String expectedOrientation = initialAndFinalCardinalDirection.substring(1);
        String actualOrientationOfSimpleMarsRover = simpleMarsRover.getState().substring(4);
        assertEquals(expectedOrientation, actualOrientationOfSimpleMarsRover);
    }
}