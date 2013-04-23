package ChiniMess;

import static org.junit.Assert.*;


import java.io.FileOutputStream;
import java.io.IOException;
import org.junit.Test;



public class BoardTest{
	
	Board dummyBoard; 
	
	public BoardTest() {
	}
	
	@Test
	public void validColorTest() {
		dummyBoard = new Board ();
        assertTrue(dummyBoard.checkAndSetColor("W"));
        assertTrue(dummyBoard.checkAndSetColor("B"));
	}
	
	@Test
	public void invalidColorTest() {
		dummyBoard = new Board ();
        assertFalse(dummyBoard.checkAndSetColor("C"));
        assertFalse(dummyBoard.checkAndSetColor("R"));
        assertFalse(dummyBoard.checkAndSetColor("55"));
	}
	
	@Test
	public void validTurnTest() {
		dummyBoard = new Board ();
		assertTrue(dummyBoard.checkAndSetCurrentTurn("22"));
		assertTrue(dummyBoard.checkAndSetCurrentTurn("1"));
		assertTrue(dummyBoard.checkAndSetCurrentTurn("14"));
		assertTrue(dummyBoard.checkAndSetCurrentTurn("35"));
	}
	
	@Test
	public void invalidTurnTest() {
		dummyBoard = new Board ();
		assertFalse(dummyBoard.checkAndSetCurrentTurn("2dd2"));
		assertFalse(dummyBoard.checkAndSetCurrentTurn("44")); // too high! max moves is 40!
		assertFalse(dummyBoard.checkAndSetCurrentTurn("0"));  // too low ! first move is 1!
		assertFalse(dummyBoard.checkAndSetCurrentTurn("-2"));
		assertFalse(dummyBoard.checkAndSetCurrentTurn("a"));
	}
	
	@Test
	public void validBoardInputTest() {
		
		dummyBoard = new Board();
		String input =    "22 B  \n"
                        + "kqbnr\n"
                        + "ppppp\n"
                        + ".....\n"
                        + ".....\n"
                        + "PPPPP\n"
                        + "RNBQK\n";
		assertTrue(dummyBoard.checkAndSetBoardFromInput(input));
		
		// move is 0
		input =   "0 B  \n"
                + "kqbnr\n"
                + "ppppp\n"
                + ".....\n"
                + ".....\n"
                + "PPPPP\n"
                + "RNBQK\n";
		assertFalse(dummyBoard.checkAndSetBoardFromInput(input));
		
		// player is incorrect
        input =   "0 F  \n"
                + "kqbnr\n"
                + "ppppp\n"
                + ".....\n"
                + ".....\n"
                + "PPPPP\n"
                + "RNBQK\n";
        assertFalse(dummyBoard.checkAndSetBoardFromInput(input));
		
		// one pawn transformed into bishop
        input =   "22 W \n"
                + "kqbnr\n"
                + "bpppp\n"
                + ".....\n"
                + ".....\n"
                + "PPPPP\n"
                + "RNBQK\n";
        assertTrue(dummyBoard.checkAndSetBoardFromInput(input));
        
        // one pawn transformed into queen
        input =   "22 W \n"
                + "kqbnr\n"
                + "ppppp\n"
                + ".....\n"
                + ".....\n"
                + "PPQPP\n"
                + "RNBQK\n";
        assertTrue(dummyBoard.checkAndSetBoardFromInput(input));
        
        // one pawn transformed into knight
        input =   "22 W \n"
                + "kqbnr\n"
                + "ppppp\n"
                + ".....\n"
                + ".....\n"
                + "PPNPP\n"
                + "RNBQK\n";
        assertTrue(dummyBoard.checkAndSetBoardFromInput(input));
        
        // one pawn transformed into rook
        input =   "22 W \n"
                + "kqbnr\n"
                + "ppppp\n"
                + ".....\n"
                + ".....\n"
                + "PPRPP\n"
                + "RNBQK\n";
        assertTrue(dummyBoard.checkAndSetBoardFromInput(input));
		
		// too many figures (bishop)
		input =   "22 W \n"
                + "kqbnr\n"
                + "ppppp\n"
                + "b....\n"
                + ".....\n"
                + "PPPPP\n"
                + "RNBQK\n";
        assertFalse(dummyBoard.checkAndSetBoardFromInput(input));
        
        // too many figures (knight)
        input =   "22 W \n"
                + "kqbnr\n"
                + "ppppp\n"
                + "n....\n"
                + ".....\n"
                + "PPPPP\n"
                + "RNBQK\n";
        assertFalse(dummyBoard.checkAndSetBoardFromInput(input));
        
        // too many figures (queen)
        input =   "22 W \n"
                + "kqbnr\n"
                + "ppppp\n"
                + "q....\n"
                + ".....\n"
                + "PPPPP\n"
                + "RNBQK\n";
        assertFalse(dummyBoard.checkAndSetBoardFromInput(input));
        
        // too many figures (rook)
        input =   "22 W \n"
                + "kqbnr\n"
                + "ppppp\n"
                + "r....\n"
                + ".....\n"
                + "PPPPP\n"
                + "RNBQK\n";
        assertFalse(dummyBoard.checkAndSetBoardFromInput(input));
        
        // too many figures (king)
        input =   "3 W  \n"
                + "kqbkr\n"
                + ".....\n"
                + "ppppp\n"
                + "PPPPP\n"
                + ".....\n"
                + "RNBQK\n";
        assertFalse(dummyBoard.checkAndSetBoardFromInput(input));
        
        
        // too many pawns
        input =   "3 W  \n"
                + "kqbnr\n"
                + ".pp..\n"
                + "ppppp\n"
                + "PPPPP\n"
                + ".....\n"
                + "RNBQK\n";
        assertFalse(dummyBoard.checkAndSetBoardFromInput(input));
	}
	
	@Test
	public void validFigure() {
		dummyBoard = new Board();
		char figure = 'k'; //white king
		Square s = new Square (2,1);
		assertTrue(dummyBoard.validateAndSetCurrentFigure(figure,s));
	}

	@Test	
	public void invalidFigure() {
		dummyBoard = new Board();
		char figure = 'k'; //white king
		Square s = new Square (22222,1);
		assertFalse(dummyBoard.validateAndSetCurrentFigure(figure,s));
	}
	
	@Test
	public void testOutputStream() {
		dummyBoard = new Board(generateValidInput());
		try {
			dummyBoard.print(new FileOutputStream("output.txt"));
			
		} 
		catch (IOException ex) {
	            ex.printStackTrace();
		}
		assertFalse(false); //TODO: @useful testCase
	}
	
	
	//helper_methods
	public String generateValidInput() {
		
		String outputString = "22 B  \n"
							+ "kqbnr\n"
							+ "ppppp\n"
							+ ".....\n"
							+ ".....\n"
							+ "PPPPP\n"
							+ "RNBQK\n";
		return outputString;
	}

	public String generateInitPositions() {
		String outputString =     "1 W  \n"
								+ "kqbnr\n" 
								+ "ppppp\n"
								+ ".....\n"
								+ ".....\n"
								+ "PPPPP\n"
								+ "RNBQK\n";
		return outputString;
	}
}
