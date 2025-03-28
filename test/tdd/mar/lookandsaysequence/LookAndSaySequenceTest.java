package tdd.mar.lookandsaysequence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LookAndSaySequenceTest {
    private LookAndSaySequence lookAndSaySequence = null;

    @BeforeEach
    public void setUp() {
        lookAndSaySequence = new LookAndSaySequence();
    }

    @Test
    public void shouldReturnEmptyString_whenGivenEmptyString() {
        String emptyString = "";

        String expectedNextMember = "";
        String actualNextMember = lookAndSaySequence.nextMember(emptyString);
        assertEquals(expectedNextMember, actualNextMember);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "5"})
    public void shouldReturnOneFollowedByGivenMember_whenGivenMemberContainsOneDigit(String member) {
        String expectedNextMember = "1" + member;
        String actualNextMember = lookAndSaySequence.nextMember(member);
        assertEquals(expectedNextMember, actualNextMember);
    }

    @ParameterizedTest
    @ValueSource(strings = {"11", "55"})
    public void shouldReturnTwoOnesFollowedByFirstDigitOfGivenMember_whenGivenMemberContainsTwoIdenticalDigits(String member) {
        String expectedNextMember = "2" + member.charAt(0);
        String actualNextMember = lookAndSaySequence.nextMember(member);
        assertEquals(expectedNextMember, actualNextMember);
    }

    @Test
    public void shouldReturnMemberOneOneOneFive_whenGivenMemberOneFive() {
        String member = "15";

        String expectedNextMember = "1115";
        String actualNextMember = lookAndSaySequence.nextMember(member);
        assertEquals(expectedNextMember, actualNextMember);
    }
}