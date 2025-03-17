package tdd.mar.simplemarsrover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleMarsRoverTest {
    @Test
    public void shouldReturnEmptyString_whenQueriedAboutStateBeforeLanding() {
        SimpleMarsRover simpleMarsRover = new SimpleMarsRover();

        String expectedStateOfSimpleMarsRover = "";
        String actualStateOfSimpleMarsRover = simpleMarsRover.getState();
        assertEquals(expectedStateOfSimpleMarsRover, actualStateOfSimpleMarsRover);
    }
}