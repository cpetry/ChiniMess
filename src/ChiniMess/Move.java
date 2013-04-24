package ChiniMess;

import Figures.*;

public class Move {

	private Square from, to;
	
	public Move(String koordinaten){
		
		char [] chararray = koordinaten.toCharArray();
		
		from 	= new Square(chararray[0]+""+chararray[1]);
		to		= new Square(chararray[2]+""+chararray[3]);
		
	}
	
	public Move(Square from, Square to){
		
		this.from = from;
		this.to = to;
	}
	
	public boolean pathIsFree(Board board) {

		int fromX = from.getCol();
		int fromY = from.getRow();
		int toX = to.getCol();
		int toY = to.getRow();
		Figure figureToMove = null; // figur on the startpostion
		Figure figureOnMove; // figur on the endposition of the given Square
		int currentpostion; // the currentposition on the board, sometimes y sometimes x
		int diagoOne; //  startX-endX
		int diagoTwo; //  startY-endY

		if (board.getFigureFromField(from) instanceof Knight) {
			figureToMove = board.getFigureFromField(to);
			if (figureToMove == null) {
				return true;
			}

			return lastPathPosition(board.getFigureFromField(from),
					figureToMove.getColor());
		}

		if (fromX == toX) {// move on Y-axis
			if (fromY < toY) { // forward move
				for (currentpostion = fromY + 1; currentpostion < toY; currentpostion++) {// move on the y-axis and look for trouble (other figure)
					if (board.getFigureFromField(new Square(fromX,currentpostion)) != null) {// if on this position is no figure, the move works
						return false;
					}
				}

				figureToMove = board.getFigureFromField(new Square(fromX,currentpostion));
			}
			if (fromY > toY) { // backward move
				for (currentpostion = fromY - 1; currentpostion > toY; currentpostion--) {// move on the y-axis and look for trouble (other figure)
					if (board.getFigureFromField(new Square(fromX, currentpostion)) != null) {// if on this position is no figure, the move works
						return false;
					}
				}
				figureToMove = board.getFigureFromField(new Square(fromX,currentpostion));
			}
		} else if (fromY == toY) {// move on X-axis
			if (fromX < toX) { // forward move
				for (currentpostion = fromX + 1; currentpostion < toX; currentpostion++) {
					if (board.getFigureFromField(new Square(currentpostion,fromY)) != null) {
						return false;
					}
				}

				figureToMove = board.getFigureFromField(new Square(currentpostion, fromY));

			}
			if (fromX > toX) { // backward move
				for (currentpostion = fromX - 1; currentpostion > toX; currentpostion--) {
					if (board.getFigureFromField(new Square(currentpostion,
							fromY)) != null) {
						return false;
					}
				}

				figureToMove = board.getFigureFromField(new Square(currentpostion, fromY));

			}
		} else {// move diagonal
			if (fromX < toX) {
				diagoOne = toX - fromX;
			} else {
				diagoOne = fromX - toX;
			}
			if (fromY < toY) {
				diagoTwo = toY - fromY;
			} else {
				diagoTwo = fromY - toY;
			}

			if (diagoOne == diagoTwo) {// if their are equal, its a diagonal move
				if (fromY > toY) {// its a move from "down" to "up"
					if (fromX > toX) {//move from left to right (diagonal)

						for (currentpostion = fromY - 1; currentpostion > toY; currentpostion--) {
							if (board.getFigureFromField(new Square(fromX - 1,currentpostion)) == null) {
								fromX--;

							} else {
								return false;
							}
						}
						figureToMove = board.getFigureFromField(new Square(fromX - 1, currentpostion));

					} else {//move from right to left (diagonal)

						for (currentpostion = fromY - 1; currentpostion > toY; currentpostion--) {
							if (board.getFigureFromField(new Square(fromX + 1,currentpostion)) == null) {
								fromX++;

							} else {
								return false;
							}
						}
						figureToMove = board.getFigureFromField(new Square(fromX + 1, currentpostion));
					}
				} else {// its a move from "up" to "down"
					if (fromX > toX) {//move from left to right (diagonal)
						for (currentpostion = fromY + 1; currentpostion < toY; currentpostion++) {
							if (board.getFigureFromField(new Square(fromX - 1,currentpostion)) == null) {
								fromX--;

							} else {
								return false;
							}
						}

						figureToMove = board.getFigureFromField(new Square(fromX - 1, currentpostion));

					} else {////move from right to left (diagonal)

						for (currentpostion = fromY + 1; currentpostion < toY; currentpostion++) {
							if (board.getFigureFromField(new Square(fromX + 1,currentpostion)) == null) {
								fromX++;
							} else {
								return false;
							}
						}

						figureToMove = board.getFigureFromField(new Square(fromX + 1, currentpostion));
					}
				}
			}
		}

		figureOnMove = board.getFigureFromField(from);
		return lastPathPosition(figureToMove, figureOnMove.getColor());
		// at the last move is there a other colored figure, you can kill them, if they have the same color, its a illegal move

	}
			
	private boolean lastPathPosition(Figure figure, boolean isWhite){
			// checks the last position of a move

		if(figure == null || isWhite != figure.getColor()){
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * 
	 * @brief compare the positions of "from" and "to" and checks the positions are on the board
	 * 
	 * @return return true, if the created Move has Squares in the board and "to" and "from" are not the same position, false if not
	 */
	public boolean isValid(){
		
		if(from.isValid() && to.isValid() && from.toString().compareTo(to.toString()) != 0){ 
			//if "from" and "to" real positions and "from" and "to" not the same...
			return true;
		}
		return false;
	}
	
	
	public Square getFrom() {
		return from;


	}

	public void setFrom(Square from) {
		this.from = from;
	}

	public Square getTo() {
		return to;
	}

	public void setTo(Square to) {
		this.to = to;
	}

	public String toString(){
				
		return from+""+to;
		
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + from.getCol();
        result = prime * result + from.getRow();
        result = prime * result + to.getCol();
        result = prime * result + to.getRow();
        
        return result;
    }
	
	   @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Move other = (Move) obj;
	        if (from.getCol() != other.from.getCol() || from.getRow() != other.from.getRow())
	            return false;
	        if (to.getCol() != other.to.getCol() || to.getRow() != other.to.getRow())
	            return false;
	        return true;
	    }

}
