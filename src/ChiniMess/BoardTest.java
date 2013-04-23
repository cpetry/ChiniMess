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
		String input = generateValidInput();
		assertTrue(dummyBoard.checkAndSetBoardFromInput(input));
	}
	
	@Test
	public void validFigure() {
		dummyBoard = new Board();
		char figure = 'k'; //white king
		int offset = 0;
		int position = 2;
		assertTrue(dummyBoard.validateAndSetCurrentFigure(figure,offset + position));
	}

	@Test	
	public void invalidFigure() {
		dummyBoard = new Board();
		char figure = 'k'; //white king
		int offset = 0;
		int position = 2222;
		assertFalse(dummyBoard.validateAndSetCurrentFigure(figure,offset + position));
	}
	
	@Test
	public void testOutputStream() {
		dummyBoard = new Board();
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
