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
                + ".....\n"
                + "..P..\n"
                + "...p.\n"
                + "....K\n";
        Player p = new NegamaxABPlayer(200);
        Board b = new Board(input);
        assertTrue(b.getPlayerOnTurn() == Board.BLACK); 
        //System.out.println(b.genMoves());
        Move m = p.chooseMove(b);
        //System.out.println("chosen move: " + m);
        assertTrue(new Move("d2-e1").equals(m));
        
        input =   "1 B  \n"
                + "k....\n"
                + "r....\n"
                + ".....\n"
                + ".....\n"
                + ".....\n"
                + "K....\n";
        p = new NegamaxABPlayer(200);
        b = new Board(input);
        
        m = p.chooseMove(b);
        //System.out.println(b.genMoves());
        //System.out.println("chosen move: " + m);
        assertTrue(new Move("a5a1").equals(m));
        
        input =   "10 B  \n"
                + "k..r.\n"
                + ".....\n"
                + ".....\n"
                + ".....\n"
                + ".....\n"
                + "...K.\n";
        p = new NegamaxABPlayer(200);
        b = new Board(input);
        
        
        m = p.chooseMove(b);
        //System.out.println(b.genMoves());
        //System.out.println("chosen move: " + m);
        assertTrue(new Move("d6d1").equals(m));
        
        input =   "10 W  \n"
                + "k....\n"
                + ".....\n"
                + ".....\n"
                + ".....\n"
                + ".....\n"
                + "R...K\n";
        p = new NegamaxABPlayer(200);
        b = new Board(input);
        
        
        m = p.chooseMove(b);
        //System.out.println(b.genMoves());
        //System.out.println("chosen move: " + m);
        assertTrue(new Move("a1a6").equals(m));
        
        input =   "1 B  \n"
                + "....K\n"
                + ".....\n"
                + "..q..\n"
                + ".R...\n"
                + ".....\n"
                + "....k\n";
        p = new NegamaxABPlayer(500);
        b = new Board(input);
        
        m = p.chooseMove(b);
        
        //System.out.println(b.genMoves());
        //System.out.println("chosen move: " + m);
        assertTrue(new Move("c4e6").equals(m));
        
        input =    "1 B \n"
                + "...K.\n"
                + "...q.\n"
                + "..R..\n"
                + ".....\n"
                + ".p...\n"
                + "....k\n";
        p = new NegamaxABPlayer(500);
        b = new Board(input);
        m = p.chooseMove(b);
        //System.out.println("chosen move: " + m);
        assertTrue(new Move("d5d6").equals(m));
        
        input =   "1 B \n"
                + "...k.\n"
                + ".....\n"
                + "..r..\n"
                + "...Q.\n"
                + ".P...\n"
                + "....K\n";
        p = new NegamaxABPlayer(1000);
        b = new Board(input);
        m = p.chooseMove(b);
        System.out.println("chosen move: " + m);
        assertTrue(new Move("d3-d6").equals(m));
        
        input =   "1 B  \n"
                + "k....\n"
                + ".....\n"
                + ".....\n"
                + ".....\n"
                + ".....\n"
                + "r..K.\n";
        p = new NegamaxABPlayer(1000);
        b = new Board(input);
        m = p.chooseMove(b);
        //System.out.println("chosen move: " + m);
        assertTrue(new Move("a1d1").equals(m));
        
        input =   "1 W  \n"
                + "k.R..\n"
                + ".....\n"
                + ".p.q.\n"
                + "...P.\n"
                + ".....\n"
                + "..K..\n";
        p = new NegamaxABPlayer(200);
        b = new Board(input);
        m = p.chooseMove(b);
        System.out.println("chosen move: " + m);
        assertTrue(new Move("c6a6").equals(m));
        
        input =   "1 B  \n"
                + "..k..\n"
                + ".....\n"
                + "...p.\n"
                + ".P.Q.\n"
                + ".....\n"
                + "..r.K\n";
        p = new NegamaxABPlayer(200);
        b = new Board(input);
        m = p.chooseMove(b);
        System.out.println("chosen move: " + m);
        //assertTrue(new Move("c1e1").equals(m));
        
        
        input =   "1 B  \n"
                + "..k..\n"
                + ".....\n"
                + "..rp.\n"
                + "...Q.\n"
                + ".P...\n"
                + "....K\n";
        p = new NegamaxABPlayer(200);
        b = new Board(input);
        m = p.chooseMove(b);
        System.out.println("chosen move: " + m);
        assertTrue(new Move("c4c1").equals(m));
    }

}
