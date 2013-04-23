package Figures;

import static org.junit.Assert.*;

import org.junit.Test;

import ChiniMess.Move;

public class FigureTest {

    public void canJumpTest(){
        Pawn p = new Pawn(true);       // white Pawn
        Rook r = new Rook(true);        // white Rook
        Knight n = new Knight(true);    // white Knight
        Bishop b = new Bishop(true);    // white Bishop
        Queen q = new Queen(true);      // white Queen
        King k = new King(true);        // white King
        
        assertFalse(p.canJump());
        assertFalse(r.canJump());
        assertTrue(n.canJump());
        assertFalse(b.canJump());
        assertFalse(q.canJump());
        assertFalse(k.canJump());
    }
    @Test
    /**
     * @brief Tests if the figure can move straight several squares
     */
    public void canExecuteMoveStraightFarTest() {
        Pawn pw = new Pawn(true);       // white Pawn
        Pawn pb = new Pawn(false);      // black Pawn
        Rook r = new Rook(true);        // white Rook
        Knight n = new Knight(true);    // white Knight
        Bishop b = new Bishop(true);    // white Bishop
        Queen q = new Queen(true);      // white Queen
        King k = new King(true);        // white King
        
        
        Move m = new Move("a1a3");
        
        assertFalse(pw.canExecuteMove(m));
        assertFalse(pb.canExecuteMove(m));
        assertTrue(r.canExecuteMove(m));
        assertFalse(n.canExecuteMove(m));
        assertFalse(b.canExecuteMove(m));
        assertTrue(q.canExecuteMove(m));
        assertFalse(k.canExecuteMove(m));
        
        m = new Move("b3e3");
        
        assertFalse(pw.canExecuteMove(m));
        assertFalse(pb.canExecuteMove(m));
        assertTrue(r.canExecuteMove(m));
        assertFalse(n.canExecuteMove(m));
        assertFalse(b.canExecuteMove(m));
        assertTrue(q.canExecuteMove(m));
        assertFalse(k.canExecuteMove(m));
    }
    
    @Test
    /**
     * @brief Tests if the figure can move straight one squares
     */
    public void canExecuteMoveStraightNearTest() {
        Pawn pw = new Pawn(true);       // white Pawn
        Pawn pb = new Pawn(false);      // black Pawn
        Rook r = new Rook(true);        // white Rook
        Knight n = new Knight(true);    // white Knight
        Bishop b = new Bishop(true);    // white Bishop
        Queen q = new Queen(true);      // white Queen
        King k = new King(true);        // white King
        
        
        Move m = new Move("a2a1"); // moving straight upwards
        
        assertTrue(pw.canExecuteMove(m));
        assertFalse(pb.canExecuteMove(m));
        assertTrue(r.canExecuteMove(m));
        assertFalse(n.canExecuteMove(m));
        assertTrue(b.canExecuteMove(m)); // only if no enemy is at destination!
        assertTrue(q.canExecuteMove(m));
        assertTrue(k.canExecuteMove(m));
        
        m = new Move("c3b3");       // moving straight to the left
        
        assertFalse(pw.canExecuteMove(m));
        assertFalse(pb.canExecuteMove(m));
        assertTrue(r.canExecuteMove(m));
        assertFalse(n.canExecuteMove(m));
        assertTrue(b.canExecuteMove(m)); // only if no enemy is at destination!
        assertTrue(q.canExecuteMove(m));
        assertTrue(k.canExecuteMove(m));
    }
    
    @Test
    /**
     * @brief Tests if the figure can move diagonal one square
     */
    public void canExecuteMoveDiagonalNearTest() {
        Pawn pw = new Pawn(true);       // white Pawn
        Pawn pb = new Pawn(false);      // black Pawn
        Rook r = new Rook(true);        // white Rook
        Knight n = new Knight(true);    // white Knight
        Bishop b = new Bishop(true);    // white Bishop
        Queen q = new Queen(true);      // white Queen
        King k = new King(true);        // white King
        
        
        Move m = new Move("a1b2"); // moving diagonal right-downwards
        
        assertFalse(pw.canExecuteMove(m)); 
        assertTrue(pb.canExecuteMove(m));   // only if an enemy is at destination!
        assertFalse(r.canExecuteMove(m));
        assertFalse(n.canExecuteMove(m));
        assertTrue(b.canExecuteMove(m)); 
        assertTrue(q.canExecuteMove(m));
        assertTrue(k.canExecuteMove(m));
        
        m = new Move("c3d4");       // moving diagonal left-downwards
        
        assertFalse(pw.canExecuteMove(m));   
        assertTrue(pb.canExecuteMove(m));   // only if an enemy is at destination!
        assertFalse(r.canExecuteMove(m));
        assertFalse(n.canExecuteMove(m));
        assertTrue(b.canExecuteMove(m));
        assertTrue(q.canExecuteMove(m));
        assertTrue(k.canExecuteMove(m));
        
        m = new Move("b3a2");       // moving diagonal left-upwards
        
        assertTrue(pw.canExecuteMove(m));   // only if an enemy is at destination!
        assertFalse(pb.canExecuteMove(m));
        assertFalse(r.canExecuteMove(m));
        assertFalse(n.canExecuteMove(m));
        assertTrue(b.canExecuteMove(m));
        assertTrue(q.canExecuteMove(m));
        assertTrue(k.canExecuteMove(m));
        
        m = new Move("b3c2");       // moving diagonal right-upwards
        
        assertTrue(pw.canExecuteMove(m));   // only if an enemy is at destination!
        assertFalse(pb.canExecuteMove(m));
        assertFalse(r.canExecuteMove(m));
        assertFalse(n.canExecuteMove(m));
        assertTrue(b.canExecuteMove(m));
        assertTrue(q.canExecuteMove(m));
        assertTrue(k.canExecuteMove(m));
    }
    
    @Test
    /**
     * @brief Tests if the figure can move diagonal several squares
     */
    public void canExecuteMoveDiagonalFarTest() {
        Pawn pw = new Pawn(true);       // white Pawn
        Pawn pb = new Pawn(false);      // black Pawn
        Rook r = new Rook(true);        // white Rook
        Knight n = new Knight(true);    // white Knight
        Bishop b = new Bishop(true);    // white Bishop
        Queen q = new Queen(true);      // white Queen
        King k = new King(true);        // white King
        
        
        Move m = new Move("a1c3"); // moving diagonal right-downwards
        
        assertFalse(pw.canExecuteMove(m)); 
        assertFalse(pb.canExecuteMove(m));
        assertFalse(r.canExecuteMove(m));
        assertFalse(n.canExecuteMove(m));
        assertTrue(b.canExecuteMove(m)); 
        assertTrue(q.canExecuteMove(m));
        assertFalse(k.canExecuteMove(m));
        
        m = new Move("c3e5");       // moving diagonal left-downwards
        
        assertFalse(pw.canExecuteMove(m));
        assertFalse(pb.canExecuteMove(m));
        assertFalse(r.canExecuteMove(m));
        assertFalse(n.canExecuteMove(m));
        assertTrue(b.canExecuteMove(m));
        assertTrue(q.canExecuteMove(m));
        assertFalse(k.canExecuteMove(m));
        
        m = new Move("e5b2");       // moving diagonal left-upwards
        
        assertFalse(pw.canExecuteMove(m));
        assertFalse(pb.canExecuteMove(m));
        assertFalse(r.canExecuteMove(m));
        assertFalse(n.canExecuteMove(m));
        assertTrue(b.canExecuteMove(m));
        assertTrue(q.canExecuteMove(m));
        assertFalse(k.canExecuteMove(m));
        
        m = new Move("b3d1");       // moving diagonal right-upwards
        
        assertFalse(pw.canExecuteMove(m));
        assertFalse(pb.canExecuteMove(m));
        assertFalse(r.canExecuteMove(m));
        assertFalse(n.canExecuteMove(m));
        assertTrue(b.canExecuteMove(m));
        assertTrue(q.canExecuteMove(m));
        assertFalse(k.canExecuteMove(m));
    }
    
    @Test
    /**
     * @brief Tests if the figure can move diagonal several squares
     */
    public void canExecuteMoveKnightTest() {
        Pawn pw = new Pawn(true);       // white Pawn
        Pawn pb = new Pawn(false);      // black Pawn
        Rook r = new Rook(true);        // white Rook
        Knight n = new Knight(true);    // white Knight
        Bishop b = new Bishop(true);    // white Bishop
        Queen q = new Queen(true);      // white Queen
        King k = new King(true);        // white King
    
        Move m1 = new Move("c3a2");
        Move m2 = new Move("c3b1");
        Move m3 = new Move("c3b5");
        Move m4 = new Move("c3a4");
        Move m5 = new Move("c3e2");
        Move m6 = new Move("c3d1");
        Move m7 = new Move("c3d5");
        Move m8 = new Move("c3e4");
        
        assertFalse(pw.canExecuteMove(m1));
        assertFalse(pb.canExecuteMove(m1));
        assertFalse(r.canExecuteMove(m1));
        assertTrue(n.canExecuteMove(m1));
        assertFalse(b.canExecuteMove(m1));
        assertFalse(q.canExecuteMove(m1));
        assertFalse(k.canExecuteMove(m1));
        
        assertFalse(pw.canExecuteMove(m2));
        assertFalse(pb.canExecuteMove(m2));
        assertFalse(r.canExecuteMove(m2));
        assertTrue(n.canExecuteMove(m2));
        assertFalse(b.canExecuteMove(m2));
        assertFalse(q.canExecuteMove(m2));
        assertFalse(k.canExecuteMove(m2));
        
        assertFalse(pw.canExecuteMove(m3));
        assertFalse(pb.canExecuteMove(m3));
        assertFalse(r.canExecuteMove(m3));
        assertTrue(n.canExecuteMove(m3));
        assertFalse(b.canExecuteMove(m3));
        assertFalse(q.canExecuteMove(m3));
        assertFalse(k.canExecuteMove(m3));
        
        assertFalse(pw.canExecuteMove(m4));
        assertFalse(pb.canExecuteMove(m4));
        assertFalse(r.canExecuteMove(m4));
        assertTrue(n.canExecuteMove(m4));
        assertFalse(b.canExecuteMove(m4));
        assertFalse(q.canExecuteMove(m4));
        assertFalse(k.canExecuteMove(m4));
        
        assertFalse(pw.canExecuteMove(m5));
        assertFalse(pb.canExecuteMove(m5));
        assertFalse(r.canExecuteMove(m5));
        assertTrue(n.canExecuteMove(m5));
        assertFalse(b.canExecuteMove(m5));
        assertFalse(q.canExecuteMove(m5));
        assertFalse(k.canExecuteMove(m5));
        
        assertFalse(pw.canExecuteMove(m6));
        assertFalse(pb.canExecuteMove(m6));
        assertFalse(r.canExecuteMove(m6));
        assertTrue(n.canExecuteMove(m6));
        assertFalse(b.canExecuteMove(m6));
        assertFalse(q.canExecuteMove(m6));
        assertFalse(k.canExecuteMove(m6));
        
        assertFalse(pw.canExecuteMove(m7));
        assertFalse(pb.canExecuteMove(m7));
        assertFalse(r.canExecuteMove(m7));
        assertTrue(n.canExecuteMove(m7));
        assertFalse(b.canExecuteMove(m7));
        assertFalse(q.canExecuteMove(m7));
        assertFalse(k.canExecuteMove(m7));
        
        assertFalse(pw.canExecuteMove(m8));
        assertFalse(pb.canExecuteMove(m8));
        assertFalse(r.canExecuteMove(m8));
        assertTrue(n.canExecuteMove(m8));
        assertFalse(b.canExecuteMove(m8));
        assertFalse(q.canExecuteMove(m8));
        assertFalse(k.canExecuteMove(m8));
    }
}
