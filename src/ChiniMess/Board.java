

package ChiniMess;

import java.util.ArrayList;

import Figures.*;


public class Board {
    private final int WIDTH = 5, HEIGHT = 6;
    private int moveNumber; 
    private boolean onMove; 
    
    ArrayList<Figure> board = new ArrayList<Figure>();

    public Board() {
    	initEmptyBoard();
    }
    
	public Board(String inputField) {
		
	}
	
	
	private void initEmptyBoard() {
		for (int i = 0; i < WIDTH * HEIGHT; i++) {
				this.board.add(null);
		}
		
	}
	
	public String toString() {
		String outputString = ""; 
		for (Figure f: board) {
			for (int i = 0; i < WIDTH; i++) {
				outputString += f ;
				outputString += ' ';
			}
			outputString += '\n';
		}
		return outputString;
	}
	
}
