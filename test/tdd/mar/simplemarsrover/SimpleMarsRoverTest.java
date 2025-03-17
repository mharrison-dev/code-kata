package tdd.mar.simplemarsrover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}