package ChiniMess;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

import Figures.Figure;

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
	public void validCurrentMoveTest() {
		dummyBoard = new Board ();
		assertTrue(dummyBoard.checkAndSetMoves("22"));
		assertTrue(dummyBoard.checkAndSetMoves("1"));
		assertTrue(dummyBoard.checkAndSetMoves("14"));
		assertTrue(dummyBoard.checkAndSetMoves("35"));
	}
	
	@Test
	public void invalidCurrentMoveTest() {
		dummyBoard = new Board ();
		assertFalse(dummyBoard.checkAndSetMoves("2dd2"));
		assertFalse(dummyBoard.checkAndSetMoves("44")); // too high! max moves is 40!
		assertFalse(dummyBoard.checkAndSetMoves("0"));  // too low ! first move is 1!
		assertFalse(dummyBoard.checkAndSetMoves("-2"));
		assertFalse(dummyBoard.checkAndSetMoves("a"));
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
			dummyBoard.print(new BufferedWriter(new FileWriter("output.txt")));
			
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
