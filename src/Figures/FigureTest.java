package Figures;

import static org.junit.Assert.*;

import org.junit.Test;

import ChiniMess.Move;

public class FigureTest {

    @Test
    public void canExecuteMoveTest() {
        Rook r = new Rook(true); // white Rook
        Move m = new Move("a1b3"); 
    }

}
