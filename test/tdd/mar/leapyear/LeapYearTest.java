package tdd.mar.leapyear;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LeapYearTest {
    private LeapYear leapYear = null;

    @BeforeEach
    public void setUp() {
        leapYear = new LeapYear();
    }

    @ParameterizedTest
    @ValueSource(ints = {1997, 2001, 2015})
    public void shouldReturnFalse_whenYearIsNotDivisibleByFour(int year) {
        assertFalse(leapYear.validate(year));
    }

    @Test
    public void shouldReturnFalse_whenYearIsDivisibleByOneHundredButNotByFourHundred() {
        assertFalse(leapYear.validate(1800));
    }

    @Test
    public void shouldReturnTrue_whenYearIsDivisibleByFour() {
        assertTrue(leapYear.validate(1996));
    }
}