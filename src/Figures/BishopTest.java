package Figures;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @brief These are tests for the movement of figure.
 *          White and Black doesn't change anything
 */
public class BishopTest {

    @Test
    public void moveToTest() {
        Bishop b = new Bishop(true); // white Bishop
        
        // straight line tests
        assertTrue(b.canMoveTo(1, 0));
        assertTrue(b.canMoveTo(0, 1));
        assertTrue(b.canMoveTo(-1, 0));
        assertTrue(b.canMoveTo(0, -1));
        assertFalse(b.canMoveTo(2, 0));
        assertFalse(b.canMoveTo(4, 0));
        assertFalse(b.canMoveTo(-4, 0));
        assertFalse(b.canMoveTo(0, 2));
        assertFalse(b.canMoveTo(0, -2));
        
        // diagonal line tests
        assertTrue(b.canMoveTo(1, 1));
        assertTrue(b.canMoveTo(-1, -1));
        assertTrue(b.canMoveTo(-1, 1));
        assertTrue(b.canMoveTo(1, -1));
        assertTrue(b.canMoveTo(2, 2));
        assertTrue(b.canMoveTo(-3, -3));
        assertTrue(b.canMoveTo(-2, 2));
        assertTrue(b.canMoveTo(4, -4));
        
        // Knight test
        assertFalse(b.canMoveTo(2, 1));
        assertFalse(b.canMoveTo(-2, 1));
        assertFalse(b.canMoveTo(2, -1));
        assertFalse(b.canMoveTo(-2, -1));
        assertFalse(b.canMoveTo(1, 2));
        assertFalse(b.canMoveTo(-1, 2));
        assertFalse(b.canMoveTo(1, -2));
        assertFalse(b.canMoveTo(-1, -2));
    }
    
    @Test
    public void captureTest() {
        Bishop b = new Bishop(true); // white Bishop
        
        // straight line tests
        assertFalse(b.canCapture(1, 0));
        assertFalse(b.canCapture(0, 1));
        assertFalse(b.canCapture(-1, 0));
        assertFalse(b.canCapture(0, -1));
        assertFalse(b.canCapture(2, 0));
        assertFalse(b.canCapture(4, 0));
        assertFalse(b.canCapture(0, 2));
        
        // diagonal line tests
        assertTrue(b.canCapture(1, 1));
        assertTrue(b.canCapture(-1, -1));
        assertTrue(b.canCapture(-1, 1));
        assertTrue(b.canCapture(1, -1));
        assertTrue(b.canCapture(2, 2));
        assertTrue(b.canCapture(-3, -3));
        assertTrue(b.canCapture(-2, 2));
        assertTrue(b.canCapture(4, -4));
        
        // Knight test
        assertFalse(b.canCapture(2, 1));
        assertFalse(b.canCapture(-2, 1));
        assertFalse(b.canCapture(2, -1));
        assertFalse(b.canCapture(-2, -1));
        assertFalse(b.canCapture(1, 2));
        assertFalse(b.canCapture(-1, 2));
        assertFalse(b.canCapture(1, -2));
        assertFalse(b.canCapture(-1, -2));
    }

}
