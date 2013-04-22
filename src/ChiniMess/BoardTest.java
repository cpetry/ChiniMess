package ChiniMess;
import static org.junit.Assert.*;

import org.junit.Test;

import Figures.Bishop;
import Figures.King;
import Figures.Knight;
import Figures.Queen;
import Figures.Rook;


public class BoardTest {

    @Test
    public void constructorTest() {
        Board b = new Board();
        b.getFigurOnField(new Square("a1")).isinstanceof(King.class);
        b.getFigurOnField(new Square("b1")).isinstanceof(Queen.class);
        b.getFigurOnField(new Square("c1")).isinstanceof(Bishop.class);
        b.getFigurOnField(new Square("d1")).isinstanceof(Knight.class);
        b.getFigurOnField(new Square("e1")).isinstanceof(Rook.class);
        
        fail("Not yet implemented");
    }

}
