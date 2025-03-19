package tdd.mar.passwordvalidation;

public class PasswordValidation {
    private static final int MINIMUM_NUMBER_OF_CHARACTERS = 9;
    private static final String PASSWORD_WITH_AT_LEAST_ONE_CAPITAL_LETTER = ".*[A-Z].*";
    private static final String PASSWORD_WITH_AT_LEAST_ONE_LOWERCASE_LETTER = ".*[a-z].*";
    private static final String PASSWORD_WITH_AT_LEAST_ONE_DIGIT = ".*[0-9].*";
    private static final String PASSWORD_WITH_AT_LEAST_ONE_UNDERSCORE = ".*_.*";

    public boolean evaluate(String password) {
        if (!password.matches(PASSWORD_WITH_AT_LEAST_ONE_CAPITAL_LETTER)) {
            return false;
        }

        if (!password.matches(PASSWORD_WITH_AT_LEAST_ONE_LOWERCASE_LETTER)) {
            return false;
        }

        if (!password.matches(PASSWORD_WITH_AT_LEAST_ONE_DIGIT)) {
            return false;
        }

        if (!password.matches(PASSWORD_WITH_AT_LEAST_ONE_UNDERSCORE)) {
            return false;
        }

        return password.length() >= MINIMUM_NUMBER_OF_CHARACTERS;
    }
}
