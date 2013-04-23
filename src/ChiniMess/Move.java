package ChiniMess;

public class Move {

	private Square from, to;
	
	public Move(String koordinaten){
		
		char [] chararray = koordinaten.toCharArray();
		
		
		from 	= new Square(chararray[0]+""+chararray[1]);
		to		= new Square(chararray[2]+""+chararray[3]);
		
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
