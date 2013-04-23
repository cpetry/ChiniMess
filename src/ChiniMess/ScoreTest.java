package ChiniMess;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreTest {

    @Test
    public void scoreTests() {
        Board dummyBoard = new Board();
        String input =    "22 W \n"
                        + "kqbnr\n"
                        + "ppppp\n"
                        + ".....\n"
                        + ".....\n"
                        + "PPPPP\n"
                        + "RNBQK";
        assertTrue(dummyBoard.checkAndSetBoardFromInput(input));
        assertTrue(dummyBoard != null);
        int score = Score.calculateScore(dummyBoard);
        System.out.println(score);
        assertTrue(score == 0);  // no player has an advantage
    }

}
