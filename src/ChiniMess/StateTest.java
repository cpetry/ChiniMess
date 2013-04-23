package ChiniMess;

import static org.junit.Assert.*;

import org.junit.Test;

public class StateTest {

    @Test
    public void equalConstructorTest() {
        Square s1 = new Square("a1");
        Square s2 = new Square(0, 0);
        assertEquals("should be equal", s1, s2);

        s1 = new Square("b2");
        s2 = new Square(1, 1);
        assertEquals("should be equal", s1, s2);
        
        s1 = new Square("c3");
        s2 = new Square(2, 2);
        assertEquals("should be equal", s1, s2);
        
        s1 = new Square("d4");
        s2 = new Square(3, 3);
        assertEquals("should be equal", s1, s2);
        
        s1 = new Square("e5");
        s2 = new Square(4, 4);
        assertEquals("should be equal", s1, s2);
    }
    
    @Test
    public void equalToString(){      
        assertEquals(new Square("a1").toString(), "a1");
        assertEquals(new Square("b2").toString(), "b2");
        assertEquals(new Square("c3").toString(), "c3");
        assertEquals(new Square("d4").toString(), "d4");
        assertEquals(new Square("e5").toString(), "e5");
    }
    
    @Test
    public void isValidTest(){      
        assertTrue(new Square("e4").isValid());
        assertTrue(new Square("a1").isValid());
        assertTrue(new Square("b3").isValid());
        assertTrue(new Square("d2").isValid());
        assertTrue(new Square("c5").isValid());
        
        assertFalse(new Square("e7").isValid());
        assertFalse(new Square("f1").isValid());
        assertFalse(new Square("g4").isValid());
        assertFalse(new Square("14").isValid());
        assertFalse(new Square("ab").isValid());
        
        assertTrue(new Square( 0, 5).isValid());
        assertTrue(new Square( 1, 4).isValid());
        assertTrue(new Square( 4, 2).isValid());
        assertTrue(new Square( 2, 1).isValid());
        assertTrue(new Square( 3, 0).isValid());
        
        assertFalse(new Square( 5, 5).isValid());
        assertFalse(new Square( 1, 9).isValid());
        assertFalse(new Square(-1, 3).isValid());
        assertFalse(new Square(-5, 2).isValid());
        assertFalse(new Square( 8, 4).isValid());
        
        
    }

}
