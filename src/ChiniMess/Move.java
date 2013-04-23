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
	
	public boolean pathIsFree(Board board){
		

		int fromX = from.getCol();
		int fromY = from.getRow();
		int toX = to.getCol();
		int toY = to.getRow();
		Figure figureToMove; //figur on the startpostion
		Figure figureOnMove; //figur on the endposition of the given Square
		int currentpostion; //the currentposition on the board, sometimes y sometimes x
		int diagoOne; //the startX-endX
		int diagoTwo; //the startY-endY

		
	if(board.getFigureFromField(from) instanceof Knight){
		figureToMove = board.getFigureFromField(to);
		if(figureToMove == null){
			return true;
		}
		
		return lastPathPosition(board.getFigureFromField(from), figureToMove.getColor());
		
	}
		
	if(fromX == toX){// move on Y-Achsis
		if(fromY < toY){ // forward move
			for(currentpostion = fromY+1; currentpostion < toY; currentpostion++){//move on the y-achsis and look for trouble (other figure)
				if(board.getFigureFromField(new Square(fromX, currentpostion)) != null){//if on this position is no figure, the move works
					return false;
				}
			}
			figureToMove = board.getFigureFromField(new Square(fromX, currentpostion+1));
			figureOnMove = board.getFigureFromField(from);
			return lastPathPosition(figureToMove, figureOnMove.getColor()); //at the last move is there a other colored figure, you can kill them, if they have the same color, its a illegal move
		}
		if(fromY > toY){ // backward move
			for(currentpostion = fromY-1; currentpostion > toY; currentpostion--){//move on the y-achsis and look for trouble (other figure)
				if(board.getFigureFromField(new Square(fromX, currentpostion)) != null){//if on this position is no figure, the move works
					return false;
				}
			}
			figureToMove = board.getFigureFromField(new Square(fromX, currentpostion-1));
			figureOnMove = board.getFigureFromField(from);
			return lastPathPosition(figureToMove, figureOnMove.getColor());//at the last move is there a other colored figure, you can kill them, if they have the same color, its a illegal move
		}	
	}else if(fromY == toY){// move on X-Achsis
		if(fromX < toX){ // forward move 
			for(currentpostion = fromX+1; currentpostion < toX; currentpostion++){
				if(board.getFigureFromField(new Square(currentpostion, fromY)) != null){
					return false;
				}
			}

			figureToMove = board.getFigureFromField(new Square(currentpostion, fromY));
			figureOnMove = board.getFigureFromField(from);
			return lastPathPosition(figureToMove, figureOnMove.getColor());//at the last move is there a other colored figure, you can kill them, if they have the same color, its a illegal move
			
		}
		if(fromX > toX){ // backward move
			for(currentpostion = fromX-1; currentpostion > toX; currentpostion--){
				if(board.getFigureFromField(new Square(currentpostion, fromY)) != null){
					return false;
					}
				}

			figureToMove = board.getFigureFromField(new Square(currentpostion, fromY));
			figureOnMove = board.getFigureFromField(from);
			return lastPathPosition(figureToMove, figureOnMove.getColor()); //at the last move is there a other colored figure, you can kill them, if they have the same color, its a illegal move
			
			}
		}else{
				if(fromX < toX){
					diagoOne = toX - fromX;
				}else{
					diagoOne = fromX -toX;
				}
				if(fromY < toY){
					diagoTwo = toY - fromY;
				}else{
					diagoTwo = fromY - toY;
				}
					
				if(diagoOne == diagoTwo){
					if(fromY < toY){
						for(currentpostion = fromY+1; currentpostion < toY; currentpostion++){
							if(board.getFigureFromField(new Square(fromX+1, currentpostion)) == null){
								fromX++;
		
							}else{
								return false;
							}
						}
						
						figureToMove = board.getFigureFromField(new Square(currentpostion, fromX+1));
						figureOnMove = board.getFigureFromField(from);
	
						return lastPathPosition(figureToMove, figureOnMove.getColor());//at the last move is there a other colored figure, you can kill them, if they have the same color, its a illegal move
						
					}else{
						System.out.println("asdsafsad");
						for(currentpostion = fromY-1; currentpostion > toY; currentpostion--){
							if(board.getFigureFromField(new Square(fromX-1, currentpostion)) == null){
								fromX--;
	
							}else{
								return false;
							}
						}

						figureToMove = board.getFigureFromField(new Square(toX+1, currentpostion));
						figureOnMove = board.getFigureFromField(from);
						return lastPathPosition(figureToMove, true);//at the last move is there a other colored figure, you can kill them, if they have the same color, its a illegal move
					}
			}
			
		}
		
		return false;
	}
			
	private boolean lastPathPosition(Figure figure, boolean isWhite){
			
		System.out.println("verfickter scheiﬂ");

		if(figure == null || isWhite != figure.getColor()){
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * 
	 * @brief compare the position of "from" and "to" and checks the positions are on the board
	 * 
	 * @return return true, if the created Move has Squares in the board and "to" and "from" are not the same position, false if not
	 */
	public boolean IsValid(){
		
		if(from.isValid() && to.isValid() && from.toString().compareTo(to.toString()) != 0){ //ist from richtig, ist to richtig, sind die beiden String nicht gleich(nicht von a1 nach a1 laufen)
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
	
}
