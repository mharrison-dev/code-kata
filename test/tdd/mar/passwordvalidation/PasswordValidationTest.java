package tdd.mar.passwordvalidation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidationTest {
    @Test
    public void shouldReturnFalse_whenGivenEmptyPassword() {
        PasswordValidation passwordValidation = new PasswordValidation();
        String emptyPassword = "";

        boolean evaluation = passwordValidation.evaluate(emptyPassword);
        assertFalse(evaluation);
    }
}