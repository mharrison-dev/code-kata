package tdd.mar.nqueenspuzzle;

import java.util.ArrayList;
import java.util.List;

public class FringeGenerationLogic {
    private static final BoardValidationLogic BOARD_VALIDATION_LOGIC = new BoardValidationLogic();

    public List<String> generateFringe(String board) {
        List<String> fringe = new ArrayList<>();
        for (int i = 0; i < board.length(); i++) {
            if (board.charAt(i) == '.') {
                String newBoard = placeQueen(i, board);
                if (BOARD_VALIDATION_LOGIC.validate(newBoard)) {
                    fringe.add(newBoard);
                }
            }
        }

        return fringe;
    }

    private static String placeQueen(int i, String board) {
        StringBuilder boardBuilder = new StringBuilder(board);
        boardBuilder.setCharAt(i, 'Q');
        return boardBuilder.toString();
    }
}
