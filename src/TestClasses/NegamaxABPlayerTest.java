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
        Player p = new NegamaxABPlayer(2000);
        p = new GreedyPlayer();
        Board b = new Board(input);
        //System.out.println(b.genMoves());
        Move m = p.chooseMove(b);
        //System.out.println(m);
        assertTrue(new Move("d2-e1").equals(m));
    }

}
