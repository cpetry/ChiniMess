package Figures;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @brief These are tests for the movement of figure.
 *          White and Black doesn't change anything
 */
public class QueenTest {

    @Test
    public void moveToTest() {
        Queen q = new Queen(true); // white Queen
        
        // straight line tests
        assertTrue(q.canMoveTo(1, 0));
        assertTrue(q.canMoveTo(0, 1));
        assertTrue(q.canMoveTo(-1, 0));
        assertTrue(q.canMoveTo(0, -1));
        assertTrue(q.canMoveTo(2, 0));
        assertTrue(q.canMoveTo(4, 0));
        assertTrue(q.canMoveTo(0, 2));
        
     // diagonal line tests
        assertTrue(q.canMoveTo(1, 1));
        assertTrue(q.canMoveTo(-1, -1));
        assertTrue(q.canMoveTo(-1, 1));
        assertTrue(q.canMoveTo(1, -1));
        assertTrue(q.canMoveTo(2, 2));
        assertTrue(q.canMoveTo(-3, -3));
        assertTrue(q.canMoveTo(-2, 2));
        assertTrue(q.canMoveTo(4, -4));
        
        // Knight test
        assertFalse(q.canMoveTo(2, 1));
        assertFalse(q.canMoveTo(-2, 1));
        assertFalse(q.canMoveTo(2, -1));
        assertFalse(q.canMoveTo(-2, -1));
        assertFalse(q.canMoveTo(1, 2));
        assertFalse(q.canMoveTo(-1, 2));
        assertFalse(q.canMoveTo(1, -2));
        assertFalse(q.canMoveTo(-1, -2));
    }
    
    @Test
    public void captureTest() {
        Queen q = new Queen(true); // white Queen
        
        // straight line tests
        assertTrue(q.canCapture(1, 0));
        assertTrue(q.canCapture(0, 1));
        assertTrue(q.canCapture(-1, 0));
        assertTrue(q.canCapture(0, -1));
        assertTrue(q.canCapture(2, 0));
        assertTrue(q.canCapture(4, 0));
        assertTrue(q.canCapture(0, 2));
        
     // diagonal line tests
        assertTrue(q.canCapture(1, 1));
        assertTrue(q.canCapture(-1, -1));
        assertTrue(q.canCapture(-1, 1));
        assertTrue(q.canCapture(1, -1));
        assertTrue(q.canCapture(2, 2));
        assertTrue(q.canCapture(-3, -3));
        assertTrue(q.canCapture(-2, 2));
        assertTrue(q.canCapture(4, -4));
        
        // Knight test
        assertFalse(q.canCapture(2, 1));
        assertFalse(q.canCapture(-2, 1));
        assertFalse(q.canCapture(2, -1));
        assertFalse(q.canCapture(-2, -1));
        assertFalse(q.canCapture(1, 2));
        assertFalse(q.canCapture(-1, 2));
        assertFalse(q.canCapture(1, -2));
        assertFalse(q.canCapture(-1, -2));
    }

}
