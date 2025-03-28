package tdd.mar.lookandsaysequence;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {"1", "5"})
    public void shouldReturnOneFollowedByGivenMember_whenGivenMemberContainsOneDigit(String member) {
        LookAndSaySequence lookAndSaySequence = new LookAndSaySequence();

        String expectedNextMember = "1" + member;
        String actualNextMember = lookAndSaySequence.nextMember(member);
        assertEquals(expectedNextMember, actualNextMember);
    }
}