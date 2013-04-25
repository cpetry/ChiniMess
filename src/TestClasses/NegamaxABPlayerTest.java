package TestClasses;

import static org.junit.Assert.*;

import org.junit.Test;

import ChiniMess.Board;
import ChiniMess.Move;
import Players.*;

public class NegamaxABPlayerTest {

    @Test
    public void NegamaxABTest() {
        String input = "1 B \n"
                + "k....\n"
                + ".....\n"
                + "..r..\n"
                + "..P..\n"
                + "...p.\n"
                + "....K\n";
        Player p = new NegamaxABPlayer(3);
        Move m = p.chooseMove(new Board(input));
        //System.out.println(m);
        assertTrue(new Move("a6-b6").equals(m));
    }

}
