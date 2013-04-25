package TestClasses;

import static org.junit.Assert.*;

import org.junit.Test;

import Figures.Pawn;

/**
 * @brief These are tests for the movement of figure.
 *          Attention! Color does matter!
 */
public class PawnTest {

    @Test
    public void moveToTestWhite() {
        Pawn p = new Pawn(true); // white Pawn
        
        // straight line tests
        assertTrue(p.canMoveTo(1, 0));
        assertFalse(p.canMoveTo(0, 1));
        assertFalse(p.canMoveTo(-1, 0));
        assertFalse(p.canMoveTo(0, -1));
        assertFalse(p.canMoveTo(2, 0));
        assertFalse(p.canMoveTo(4, 0));
        assertFalse(p.canMoveTo(0, 2));
        
        // diagonal line tests
        assertFalse(p.canMoveTo(1, 1));
        assertFalse(p.canMoveTo(-1, -1));
        assertFalse(p.canMoveTo(-1, 1));
        assertFalse(p.canMoveTo(1, -1));
        assertFalse(p.canMoveTo(2, -1));
        assertFalse(p.canMoveTo(1, -2));
    }
    
    @Test
    public void captureTestWhite() {
        Pawn p = new Pawn(true); // white Pawn
        
        // straight line tests
        assertFalse(p.canCapture(1, 0));
        assertFalse(p.canCapture(0, 1));
        assertFalse(p.canCapture(-1, 0));
        assertFalse(p.canCapture(0, -1));
        assertFalse(p.canCapture(2, 0));
        assertFalse(p.canCapture(4, 0));
        assertFalse(p.canCapture(0, 2));
        
        // diagonal line tests
        assertFalse(p.canCapture(-1, -1));
        assertTrue(p.canCapture(1, 1));
        assertTrue(p.canCapture(1, -1));
        assertFalse(p.canCapture(-1, 1));
        assertFalse(p.canCapture(2, -1));
        assertFalse(p.canCapture(1, -2));
    }
    
    @Test
    public void moveToTestBlack() {
        Pawn p = new Pawn(false); // black Pawn
        
        // straight line tests
        assertFalse(p.canMoveTo(1, 0));
        assertFalse(p.canMoveTo(0, 1));
        assertTrue(p.canMoveTo(-1, 0));
        assertFalse(p.canMoveTo(0, -1));
        assertFalse(p.canMoveTo(2, 0));
        assertFalse(p.canMoveTo(4, 0));
        assertFalse(p.canMoveTo(0, 2));
        
        // diagonal line tests
        assertFalse(p.canMoveTo(-1, -1));
        assertFalse(p.canMoveTo(-1, -1));
        assertFalse(p.canMoveTo(-1, 1));
        assertFalse(p.canMoveTo(1, -1));
        assertFalse(p.canMoveTo(2, -1));
        assertFalse(p.canMoveTo(1, -2));
    }
    
    @Test
    public void captureTestBlack() {
        Pawn p = new Pawn(false); // black Pawn
        
        // straight line tests
        assertFalse(p.canCapture(1, 0));
        assertFalse(p.canCapture(0, 1));
        assertFalse(p.canCapture(-1, 0));
        assertFalse(p.canCapture(0, -1));
        assertFalse(p.canCapture(2, 0));
        assertFalse(p.canCapture(4, 0));
        assertFalse(p.canCapture(0, 2));
        
        // diagonal line tests
        assertTrue(p.canCapture(-1, -1));
        assertFalse(p.canCapture(1, 1));
        assertFalse(p.canCapture(1, -1));
        assertTrue(p.canCapture(-1, 1));
        assertFalse(p.canCapture(2, -1));
        assertFalse(p.canCapture(1, -2));
    }

}
