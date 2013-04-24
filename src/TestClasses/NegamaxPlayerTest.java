package TestClasses;

import static org.junit.Assert.*;

import org.junit.Test;

import ChiniMess.Board;
import ChiniMess.Move;
import Players.NegamaxPlayer;
import Players.Player;

public class NegamaxPlayerTest {

    @Test
    public void test() {
        String input = "1 W \n"
                + "k....\n"
                + ".....\n"
                + ".rQ..\n"
                + ".....\n"
                + ".P...\n"
                + "....K\n";
        Player p = new NegamaxPlayer(3);
        Board b = new Board(input);
        System.out.println(b.genMoves());
        Move m = p.chooseMove(b);
        System.out.println(m);
        assertTrue("c3a1".equals(m.toString()));
    }

}
