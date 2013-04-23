package ChiniMess;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Test;

import Figures.Figure;

public class BoardTest{
	
	Board dummyBoard; 
	
	public BoardTest() {
	}
	
	@Test
	public void validColorTest() {
		dummyBoard = new Board ();
        assertEquals("should be equal",dummyBoard.checkAndSetColor("W"),true);
	}
	
	@Test
	public void invalidColorTest() {
		dummyBoard = new Board ();
        assertEquals("should be equal",dummyBoard.checkAndSetColor("C"),false);
	}
	
	@Test
	public void validMoveTest() {
		dummyBoard = new Board ();
        assertEquals("should be equal",dummyBoard.checkAndSetMoves("22"),true);
	}
	
	@Test
	public void invalidMoveTest() {
		dummyBoard = new Board ();
        assertEquals("should be equal",dummyBoard.checkAndSetMoves("2dd2"),false);
	}
	
	@Test
	public void validBoardInputTest() {
		
		dummyBoard = new Board();
		String input = generateValidInput();
		assertEquals("should be equal",dummyBoard.checkAndSetBoardFromInput(input),true);
	}
	
	@Test
	public void validFigure() {
		dummyBoard = new Board();
		char figure = 'k'; //white king
		int offset = 0;
		int position = 2;
		assertEquals("should be equal",dummyBoard.validateAndSetCurrentFigure(figure,offset + position),true);
	}

	@Test	
	public void invalidFigure() {
		dummyBoard = new Board();
		char figure = 'k'; //white king
		int offset = 0;
		int position = 2222;
		assertEquals("should be equal",dummyBoard.validateAndSetCurrentFigure(figure,offset + position),false);
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
		assertEquals("should be equal",false,false); //TODO: @useful testCase
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
