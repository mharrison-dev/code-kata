package tdd.mar.lookandsaysequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LookAndSaySequenceTest {
    @Test
    public void shouldReturnEmptyString_whenGivenEmptyString() {
        String emptyString = "";
        LookAndSaySequence lookAndSaySequence = new LookAndSaySequence();

        String expectedNextMember = "";
        String actualNextMember = lookAndSaySequence.nextMember(emptyString);
        assertEquals(expectedNextMember, actualNextMember);
    }
}