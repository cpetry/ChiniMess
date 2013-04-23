

package ChiniMess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Figures.*;


public class Board {
    private final int WIDTH = 5, HEIGHT = 6;
    private final int MAXMOVIES = 40; 
    
    private int moveNumber; 
    private boolean onMove; 
    
    ArrayList<Figure> board = new ArrayList<Figure>();

    /**
     * @brief init board with default values and positions
     */
    public Board() {
    	moveNumber = 1; 			 // first move is one
    	onMove = true;  			 //white gets first 		
    	initEmptyBoard(); 			 //set empty board
    	initDefaultFigurePosition(); //set start positions
    	
    }
    
    /**
     * @brief set board from String-Input; set default if Input is not valid
     * @param boardInput
     */
	public Board(String boardInput) {
		
    	if (checkAndSetBoardFromInput(boardInput) == false) { //check and set input
    		moveNumber = 1; 								  //white gets first
        	onMove = true; 									  // first move is one
    		initEmptyBoard(); 	
    		initDefaultFigurePosition(); 					  //set start positions if input is rubbish!
    		 								  
    	}
	}
	
	
	public Board(InputStream inputStream) throws IOException { // don't forget ExceptionHandling!
		
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
		String strLine; // buffer for current line
		String input = "";
				
		while ((strLine = br.readLine()) != null)   { //Read File Line By Line
			input += strLine;
		}
		if (checkAndSetBoardFromInput(input) == false) { //check and set input
			initEmptyBoard(); 
			initDefaultFigurePosition(); 					   //set start positions if input is rubbish!
    		moveNumber = 1; 							       // first move is one
        	onMove = true;  								   //white gets first 
    	}
	}
	
	/**
	 * @brief init the ArrayList with null-values
	 */
	private void initEmptyBoard() {
		for (int i = 0; i < WIDTH * HEIGHT; i++) {
				this.board.add(null); //put an empty figure in each cell
		}
		
	}
	
	
	/**
	 * @brief get String from current Board_parameters
	 * @return String
	 */
	public String toString() {
		String outputString = "";
			
		outputString += "" + this.moveNumber + " "; //print number of moves first
		
		//set header
		if (this.onMove == true) //white 
				outputString += "W"; //white-players turn
		else
				outputString += "B"; //black-players turn

		outputString += "\n"; //new line for board
		
		//set board
		for (int i = 0; i < board.size(); i++) {
			if (i % WIDTH == 0 && i != 0) 
				outputString += '\n'; //end of one line
			
			if (board.get(i) != null) {
				outputString += board.get(i); //print the toString() of the figure
			}
			else {
				outputString += "."; //for empty positions
			}
			
		}
		return outputString; //return the result
	}
	
	
	/**
	 * @brief 
	 * @param inputMove
	 * @return boolean
	 */
	public boolean checkAndSetMoves(String inputMove) {
		//check moves
		try {
			int moves = Integer.valueOf(inputMove);
			if (moves < MAXMOVIES  && moves >= 0 ) {	//check if move is in range	
				this.moveNumber = moves; 				//set attribute to current move_value
				return true;							//return success
			}
			return false;								//BAM!
			
					
		}
		//set default if no luck
		catch(NumberFormatException e_ref) {
			return false;								//BAM!
		}
		
	}
	public boolean checkAndSetColor(String input) {
		
		
		//check colors
		if (input.contains("W") && input.contains("B")) {;
			return false; 					// current move cannot be black and white!
		}
		else if (input.contains("W")) {
			this.onMove = true; 			//set white player
		}
		else if (input.contains("B"))
			this.onMove = false; 			//set black player
		else
			return false;					//BAM! 
		
		return true;						//YEAH!
		
	}
	
	public boolean checkAndSetBoardFromInput(String input) {

		
		//init StringTokenizer -> remove spaces
		String tokens [] = input.split("[ \t\n]+"); //split by regular expression
		if (tokens[0] != null && this.checkAndSetMoves(tokens[0]) == false)	//first part of the String has to be the move_value
				return false;	
		
		if (tokens[1] != null && this.checkAndSetColor(tokens[1]) == false) 
				return false;
		

		if (tokens.length == HEIGHT + 2) { //test if String_HEIGHT is valid
			for (int i = 2; i < tokens.length; i++) {
				char currentLine [] = tokens[i].toCharArray();
				
				if (currentLine.length < WIDTH) //test String_WIDTH is valid
					return false;
				
				int offset = (i - 2) * WIDTH;	//-2 for counting from zero
				for (int j = 0; j < currentLine.length;j++) {
					if (validateAndSetCurrentFigure(currentLine[j],offset + j) == false) { //check and set current Figure_Object
						return false;
					}
				}
			}
			return true;
		}
		return false;
		
	}
	
	public boolean validateAndSetCurrentFigure(char c, int index) {
		boolean isWhite = false; 
		boolean possible = true; // return_value
		
		if (c > 'A' && c < 'Z') //white is upper_Case
			isWhite = true; 
		
		c = Character.toLowerCase(c); //we do not need to check upper and lower-cases
		
		try { //set the objects
			switch (c) {
				
				case 'k':
					board.set(index, new King(isWhite));
					break;
				case 'q':
					board.set(index, new Queen(isWhite));
					break;
				case 'b':
					board.set(index, new Bishop(isWhite));
					break;
				case 'n':
					board.set(index, new Knight(isWhite));
					break;
				case 'r':
					board.set(index, new Rook(isWhite));
					break;
				case 'p':
					board.set(index, new Pawn(isWhite));
					break;
				case '.':
					board.set(index,null);
					break;
				default: 
					possible = false;
			}
		}
		//if index is out of range
		catch (IndexOutOfBoundsException e_ref) {
			possible = false;
		}
		//return success
		return possible;
		
	}
	
	
	
	public boolean executeMove(Move m)  {
		
		int y_From = m.getFrom().getRow();
		int x_From = m.getFrom().getCol();
		
		int y_To = m.getTo().getRow();
		int x_To = m.getTo().getCol();
		
		if(m.IsValid()) {
			
			if(board.get(y_From * x_From + x_From) != null && y_To < HEIGHT && x_To < WIDTH) {
					
				
			}
					
		}
		else 
			return false;
		
		return true;
		
	}
	
	
	public Figure getFigureFromField(Square inputSquare) {
		if (inputSquare.isValid()) {
			return board.get((1 + inputSquare.getRow()) * inputSquare.getCol()); //get Figure from Square
			
		}
		return null;
	}
	
	public void print(BufferedWriter bw) throws IOException { //BAM-> ExceptionHandling outside the class!
		String output [] = this.toString().split("\n"); //BufferedWriter ignores '\n'
		for (String line: output) {
			bw.write(line); //write board to file
			bw.newLine();	//and another line...
		}
		bw.close(); //close stream
	}
	
	private void  initDefaultFigurePosition() {
		
		int offset = 0;
		
		//set figures for black 
		board.set(0, new King(false)); 
		board.set(1, new Queen(false));
		board.set(2, new Bishop(false));
		board.set(3, new Knight(false));
		board.set(4, new Rook(false));

		
		//set pawns for black
		for (int i = WIDTH; i < 2 * WIDTH; i++) {
			board.set(i, new Pawn(false));
		}

		//set figures for white
		offset = WIDTH * HEIGHT - 1;
		board.set(offset - 0, new King(true)); 
		board.set(offset - 1, new Queen(true));
		board.set(offset - 2, new Bishop(true));
		board.set(offset - 3, new Knight(true));
		board.set(offset - 4, new Rook(true));
		
		offset = WIDTH * HEIGHT;
		//set pawn for white
		for (int i = offset - 2 * WIDTH; i < offset - WIDTH; i++) {
			board.set(i, new Pawn(true));
		}
			
	}
	
	
	
}
