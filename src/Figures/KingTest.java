package Figures;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @brief These are tests for the movement of figure.
 *          White and Black doesn't change anything
 */
public class KingTest {

    @Test
    public void moveToTest() {
        King k = new King(true); // white King
        
        // straight line tests
        assertTrue(k.canMoveTo(1, 0));
        assertTrue(k.canMoveTo(0, 1));
        assertTrue(k.canMoveTo(-1, 0));
        assertTrue(k.canMoveTo(0, -1));
        assertFalse(k.canMoveTo(2, 0));
        assertFalse(k.canMoveTo(4, 0));
        assertFalse(k.canMoveTo(-4, 0));
        assertFalse(k.canMoveTo(0, 2));
        assertFalse(k.canMoveTo(0, -2));
        
        // diagonal line tests
        assertTrue(k.canMoveTo(1, 1));
        assertTrue(k.canMoveTo(-1, -1));
        assertTrue(k.canMoveTo(-1, 1));
        assertTrue(k.canMoveTo(1, -1));
        assertFalse(k.canMoveTo(2, -1));
        assertFalse(k.canMoveTo(1, -2));
    }
    
    @Test
    public void captureTest() {
        King k = new King(true); // white King
        
        // straight line tests
        assertTrue(k.canCapture(1, 0));
        assertTrue(k.canCapture(0, 1));
        assertTrue(k.canCapture(-1, 0));
        assertTrue(k.canCapture(0, -1));
        assertFalse(k.canCapture(2, 0));
        assertFalse(k.canCapture(4, 0));
        assertFalse(k.canCapture(0, 2));
        
        // diagonal line tests
        assertTrue(k.canCapture(1, 1));
        assertTrue(k.canCapture(-1, -1));
        assertTrue(k.canCapture(-1, 1));
        assertTrue(k.canCapture(1, -1));
        assertFalse(k.canCapture(2, -1));
        assertFalse(k.canCapture(1, -2));
    }

}
