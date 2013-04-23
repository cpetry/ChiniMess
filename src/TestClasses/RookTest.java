package TestClasses;

import static org.junit.Assert.*;

import org.junit.Test;

import Figures.Rook;

/**
 * @brief These are tests for the movement of figure.
 *          White and Black doesn't change anything
 */
public class RookTest {

    @Test
    public void moveToTest() {
        Rook r = new Rook(true); // white rook
        
        // straight line tests
        assertTrue(r.canMoveTo(1, 0));
        assertTrue(r.canMoveTo(0, 1));
        assertTrue(r.canMoveTo(-1, 0));
        assertTrue(r.canMoveTo(0, -1));
        assertTrue(r.canMoveTo(2, 0));
        assertTrue(r.canMoveTo(4, 0));
        assertTrue(r.canMoveTo(0, 2));
        
        // diagonal line tests
        assertFalse(r.canMoveTo(1, 1));
        assertFalse(r.canMoveTo(-1, -1));
        assertFalse(r.canMoveTo(-1, 1));
        assertFalse(r.canMoveTo(1, -1));
        assertFalse(r.canMoveTo(2, -1));
        assertFalse(r.canMoveTo(1, -2));
    }
    
    @Test
    public void captureTest() {
        Rook r = new Rook(true); // white rook
        assertTrue(r.canCapture(1, 0));
        assertTrue(r.canCapture(0, 1));
        assertTrue(r.canCapture(-1, 0));
        assertTrue(r.canCapture(0, -1));
        assertTrue(r.canCapture(2, 0));
        assertTrue(r.canCapture(4, 0));
        assertTrue(r.canCapture(0, 2));
        
        assertFalse(r.canCapture(1, 1));
        assertFalse(r.canCapture(-1, -1));
        assertFalse(r.canCapture(-1, 1));
        assertFalse(r.canCapture(1, -1));
        assertFalse(r.canCapture(2, -1));
        assertFalse(r.canCapture(1, -2));
    }

}
