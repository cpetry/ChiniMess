

package ChiniMess;

import java.util.ArrayList;
import java.util.StringTokenizer;

import Figures.*;


public class Board {
    private final int WIDTH = 5, HEIGHT = 6;
    private final int MAXMOVIES = 40; 
    
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
			
			if (board.get(i) != null) {
				outputString += board.get(i);
			}
			else {
				outputString += ".";
			}
			
		}
		return outputString;
	}
	
	private void  initDefaultFigurePosition() {
		
		int offset = 0;
		
		//set figures for white 
		board.set(0, new King(false)); 
		board.set(1, new Queen(false));
		board.set(2, new Bishop(false));
		board.set(3, new Knight(false));
		board.set(4, new Rook(false));

		
		//set pawns for white
		for (int i = WIDTH; i < 2 * WIDTH; i++) {
			board.set(i, new Pawn(false));
		}
			
		
		//set figures for black
		
		offset = WIDTH * HEIGHT - 1;
		board.set(offset - 0, new King(true)); 
		board.set(offset - 1, new Queen(true));
		board.set(offset - 2, new Bishop(true));
		board.set(offset - 3, new Knight(true));
		board.set(offset - 4, new Rook(true));
		
		offset = WIDTH * HEIGHT;
		//set pawn for black
		for (int i = offset - 2 * WIDTH; i < offset - WIDTH; i++) {
			board.set(i, new Pawn(true));
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
			this.onMove = false;
		}
		else if (currentToken == "W") {
			this.onMove = true;
		}
		else {
			initDefaultFigurePosition();
			return;
		}
		//check for turn 	
		if (tokenizer.hasMoreElements()) {
			currentToken = (String) tokenizer.nextElement();
		}
		//try to get current move from string
		try {
			int moves = new Integer(currentToken);
			if (moves < MAXMOVIES && moves >= 0  
				&& (moves % 2 == 0 && this.onMove)			//test for white-players turn 
				&& (moves % 2 == 1 && !this.onMove)) {		//test for black-players turn 
				this.moveNumber = moves;
			}
			
		}
		//set default if no luck
		catch(NumberFormatException e_ref) {
			initDefaultFigurePosition();
		}
		
		//set figure_positions 
		//validateFigureChars();
		
		
	}
	
	public static void main (String args []) {
		Board b = new Board(); 
		System.out.println(b);
	}
	
}
