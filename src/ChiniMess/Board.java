

package ChiniMess;

import java.util.ArrayList;
import java.util.StringTokenizer;

import Figures.*;


public class Board {
    private final int WIDTH = 5, HEIGHT = 6;
    private int moveNumber; 
    private boolean onMove; 
    
    ArrayList<Figure> board = new ArrayList<Figure>();

    public Board() {
    	moveNumber = 0;
    	onMove = false; 	
    	initEmptyBoard();
    	initDefaultFigurePosition();
    	
    }
    
	public Board(String inputArgument) {
		moveNumber = 0;
    	onMove = false; 	
    	initEmptyBoard();
    	analyseArgument(inputArgument);
		
	}
	
	
	private void initEmptyBoard() {
		for (int i = 0; i < WIDTH * HEIGHT; i++) {
				this.board.add(null);
		}
		
	}
	
	
	
	public String toString() {
		String outputString = ""; 
		for (int i = 0; i < board.size(); i++) {
			if (i % WIDTH == 0)
				outputString += '\n';
			
			outputString += board.get(i);
			outputString += ' ';
			
		}
		return outputString;
	}
	
	private void  initDefaultFigurePosition() {
		
		int offset = 0;
		
		//set figures for one side
		board.set(0, new King()); 
		board.set(1, new Queen());
		board.set(2, new Bishop());
		board.set(3, new Knight());
		board.set(4, new Rook());

		
		//set pawns for one part
		for (int i = WIDTH; i < 2 * WIDTH; i++) {
			board.set(i, new Pawn());
		}
			
		
		//set figures for the other
		
		offset = WIDTH * HEIGHT - 1;
		board.set(offset - 0, new King()); 
		board.set(offset - 1, new Queen());
		board.set(offset - 2, new Bishop());
		board.set(offset - 3, new Knight());
		board.set(offset - 4, new Rook());
		
		offset = WIDTH * HEIGHT;
		//set pawn for the other
		for (int i = offset - 2 * WIDTH; i < offset - WIDTH; i++) {
			board.set(i, new Pawn());
		}
		
		
		
	}
	private void analyseArgument(String inputArgument) {
		
		//check for right-turn
		String currentToken = null;
		StringTokenizer tokenizer = new StringTokenizer(inputArgument, " ");
		if (tokenizer.hasMoreElements()) {
			currentToken = (String) tokenizer.nextElement();
		}
		
		if (currentToken == "B") {
			
		}
		else if (currentToken == "W") {
			
		}
		else {
			initDefaultFigurePosition();
			return;
		}
		//check for turn 	
		if (tokenizer.hasMoreElements()) {
			currentToken = (String) tokenizer.nextElement();
		}
		try {
			int moves = new Integer(currentToken);
		}
		catch(NumberFormatException e_ref) {
			initDefaultFigurePosition();
		}
		
		
	}
	
	
}
