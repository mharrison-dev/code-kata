package tdd.mar.leapyear;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LeapYearTest {
    @ParameterizedTest
    @ValueSource(ints = {1997, 2001, 2015})
    public void shouldReturnFalse_whenYearIsNotDivisibleByFour(int year) {
        LeapYear leapYear = new LeapYear();

        assertFalse(leapYear.validate(year));
    }

    @Test
    public void shouldReturnFalse_whenYearIsDivisibleByOneHundredButNotByFourHundred() {
        LeapYear leapYear = new LeapYear();

        assertFalse(leapYear.validate(1800));
    }
}