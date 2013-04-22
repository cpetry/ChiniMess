package ChiniMess;

import static org.junit.Assert.*;

import org.junit.Test;

public class SquareTest {

    @Test
    public void equalConstructorTest() {
        Square s1 = new Square("a1");
        Square s2 = new Square(0, 0);
        
        assertEquals("should be equal", s1, s2);
        //fail("Not yet implemented");
    }
    
    public void equalToString(){
        Square s1 = new Square("a1");
        
        assertEquals(s1, "a1");
    }

}
