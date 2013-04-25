package TestClasses;

import static org.junit.Assert.*;

import org.junit.Test;

import ChiniMess.Board;
import ChiniMess.Move;
import ChiniMess.Square;
import Figures.Figure;
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
        //System.out.println("chosen move: " + m);
        assertTrue(new Move("c4b4").equals(m));
        
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
        //System.out.println("chosen move: " + m);
        assertTrue(new Move("c4b4").equals(m));
        
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
        //System.out.println("chosen move: " + m);
        assertTrue(new Move("d6c5").equals(m));
        
        
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
        //System.out.println("chosen move: " + m);
        assertTrue(new Move("c4c1").equals(m));
    }
    
    @Test
    public void do_undo_test() {
        String input = "1 B \n"
                + "...k.\n"
                + ".....\n"
                + "..r..\n"
                + "...Q.\n"
                + ".P...\n"
                + "....K\n";
        NegamaxPlayer p = new NegamaxPlayer(4);
        Board copy = new Board(input);
        Board b = new Board(input);
        
        Move m = p.chooseMove(b);
        
        Figure thrownFigure = null;
        boolean pawn_transformed = false;
        p.do__move(b, m, thrownFigure, pawn_transformed);
        p.undo__move(b, m, thrownFigure, pawn_transformed);
        
        
        //System.out.println("chosen move: " + m);
        //System.out.println(b);
        //System.out.println(copy);
        assertTrue(b.equals(copy));
        
        
        input = "1 B \n"
                + "...k.\n"
                + "P....\n"
                + "..r..\n"
                + "...Q.\n"
                + ".P...\n"
                + "....K\n";
        p = new NegamaxPlayer(4);
        copy = new Board(input);
        b = new Board(input);
        
        m = new Move("a5a6");
          
        thrownFigure = null;
        pawn_transformed = false;
        p.do__move(b, m, thrownFigure, pawn_transformed);
        
        p.undo__move(b, m, thrownFigure, pawn_transformed);
        assertTrue(b.equals(copy));
    }

}
