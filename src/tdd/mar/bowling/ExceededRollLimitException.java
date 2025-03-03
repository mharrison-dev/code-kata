package tdd.mar.bowling;

public class ExceededRollLimitException extends RuntimeException {
    public ExceededRollLimitException(String message) {
        super(message);
    }
}
