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
        //System.out.println(b.genMoves());
        Move m = p.chooseMove(b);
        //System.out.println("chosen move" + m);
        assertTrue(new Move("c3a1").equals(m));
        
        input = "1 W \n"
                + "...k.\n"
                + ".....\n"
                + ".rQ..\n"
                + ".....\n"
                + ".P...\n"
                + "....K\n";
        p = new NegamaxPlayer(2);
        b = new Board(input);
        m = p.chooseMove(b);
        System.out.println("chosen move" + m);
        assertTrue(new Move("c3b3").equals(m));
        
        input = "1 B \n"
                + "...k.\n"
                + ".....\n"
                + "..r..\n"
                + "...Q.\n"
                + ".P...\n"
                + "....K\n";
        p = new NegamaxPlayer(4);
        b = new Board(input);
        m = p.chooseMove(b);
        //System.out.println("chosen move" + m);
        assertTrue(new Move("d1c2").equals(m));
        
        
        input = "1 B \n"
                + "...k.\n"
                + ".....\n"
                + "..rp.\n"
                + "...Q.\n"
                + ".P...\n"
                + "....K\n";
        p = new NegamaxPlayer(4);
        b = new Board(input);
        m = p.chooseMove(b);
        //System.out.println("chosen move" + m);
        assertTrue(new Move("c3c6").equals(m));
    }

}