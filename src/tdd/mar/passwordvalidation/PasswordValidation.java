package tdd.mar.passwordvalidation;

public class PasswordValidation {
    private static final int MINIMUM_NUMBER_OF_CHARACTERS = 9;

    public boolean evaluate(String password) {
        return password.length() >= MINIMUM_NUMBER_OF_CHARACTERS;
    }
}
