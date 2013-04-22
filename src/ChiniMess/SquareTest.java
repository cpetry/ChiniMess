package ChiniMess;

import static org.junit.Assert.*;

import org.junit.Test;

public class SquareTest {

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

}
