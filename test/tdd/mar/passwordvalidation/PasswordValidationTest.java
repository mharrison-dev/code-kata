package tdd.mar.passwordvalidation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidationTest {
    private PasswordValidation passwordValidation = null;

    @BeforeEach
    public void setUp() {
        passwordValidation = new PasswordValidation();
    }

    @Test
    public void shouldReturnFalse_whenGivenEmptyPassword() {
        String emptyPassword = "";

        boolean evaluation = passwordValidation.evaluate(emptyPassword);
        assertFalse(evaluation);
    }

    @Test
    public void shouldReturnTrue_whenGivenPasswordWithMoreThanEightCharacters() {
        String passwordWithNineCharacters = "012345_bA";

        boolean evaluation = passwordValidation.evaluate(passwordWithNineCharacters);
        assertTrue(evaluation);
    }

    @Test
    public void shouldReturnFalse_whenGivenPasswordWithEightCharactersOrFewer() {
        String passwordWithEightCharacters = "01234567";

        boolean evaluation = passwordValidation.evaluate(passwordWithEightCharacters);
        assertFalse(evaluation);
    }

    @Test
    public void shouldReturnFalse_whenGivenPasswordWithoutCapitalLetter() {
        String passwordWithoutCapitalLetter = "012345678";

        boolean evaluation = passwordValidation.evaluate(passwordWithoutCapitalLetter);
        assertFalse(evaluation);
    }

    @Test
    public void shouldReturnFalse_whenGivenPasswordWithoutLowercaseLetter() {
        String passwordWithoutLowerLetter = "01234567A";

        boolean evaluation = passwordValidation.evaluate(passwordWithoutLowerLetter);
        assertFalse(evaluation);
    }

    @Test
    public void shouldReturnFalse_whenGivenPasswordWithoutDigit() {
        String passwordWithoutDigit = "ihgfedcbA";

        boolean evaluation = passwordValidation.evaluate(passwordWithoutDigit);
        assertFalse(evaluation);
    }

    @Test
    public void shouldReturnFalse_whenGivenPasswordWithoutUnderscore() {
        String passwordWithoutUnderscore = "0123456bA";

        boolean evaluation = passwordValidation.evaluate(passwordWithoutUnderscore);
        assertFalse(evaluation);
    }
}