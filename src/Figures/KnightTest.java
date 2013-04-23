package Figures;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @brief These are tests for the movement of figure.
 *          White and Black doesn't change anything
 */
public class KnightTest {

    @Test
    public void moveToTest() {
        Knight n = new Knight(true); // white Knight
        
        // possible movements
        assertTrue(n.canMoveTo(2,  1));
        assertTrue(n.canMoveTo(-2, 1));
        assertTrue(n.canMoveTo(2,  -1));
        assertTrue(n.canMoveTo(-2, -1));
        assertTrue(n.canMoveTo(1,  2));
        assertTrue(n.canMoveTo(-1, 2));
        assertTrue(n.canMoveTo(1, -2));
        assertTrue(n.canMoveTo(-1, -2));
        
        // some impossible movements
        assertFalse(n.canMoveTo(1, 0));
        assertFalse(n.canMoveTo(0, 1));
        assertFalse(n.canMoveTo(-1, 0));
        assertFalse(n.canMoveTo(0, -1));
        assertFalse(n.canMoveTo(2, 0));
        assertFalse(n.canMoveTo(4, 0));
        assertFalse(n.canMoveTo(0, 2));
        assertFalse(n.canMoveTo(1, 1));
        assertFalse(n.canMoveTo(-1, -1));
        assertFalse(n.canMoveTo(-1, 1));
        assertFalse(n.canMoveTo(1, -1));
    }
    
    @Test
    public void captureTest() {
        Knight n = new Knight(true); // white Knight
        
        // possible movements
        assertTrue(n.canMoveTo(2,  1));
        assertTrue(n.canMoveTo(-2, 1));
        assertTrue(n.canMoveTo(2,  -1));
        assertTrue(n.canMoveTo(-2, -1));
        assertTrue(n.canMoveTo(1,  2));
        assertTrue(n.canMoveTo(-1, 2));
        assertTrue(n.canMoveTo(1, -2));
        assertTrue(n.canMoveTo(-1, -2));
        
        // some impossible movements
        assertFalse(n.canMoveTo(1, 0));
        assertFalse(n.canMoveTo(0, 1));
        assertFalse(n.canMoveTo(-1, 0));
        assertFalse(n.canMoveTo(0, -1));
        assertFalse(n.canMoveTo(2, 0));
        assertFalse(n.canMoveTo(4, 0));
        assertFalse(n.canMoveTo(0, 2));
        assertFalse(n.canMoveTo(1, 1));
        assertFalse(n.canMoveTo(-1, -1));
        assertFalse(n.canMoveTo(-1, 1));
        assertFalse(n.canMoveTo(1, -1));
    }
}
