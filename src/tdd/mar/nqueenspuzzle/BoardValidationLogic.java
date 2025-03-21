package tdd.mar.nqueenspuzzle;

public class BoardValidationLogic {
    public boolean validate(String board) {
        if (board.matches("[.\n]+")) {
            return true;
        }

        return board.matches(".*Q.*");
    }
}
