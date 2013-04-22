package ChiniMess;

public class Move {

	public Square from, to;
	
	
	public Move(String koordinaten){
		
		char [] chararray = koordinaten.toCharArray();
		
		from 	= new Square(chararray[0]+""+chararray[1]);
		to		= new Square(chararray[2]+""+chararray[3]);
		
	}
	
	
	public String toString(){
		
		return from+""+to;
		
	}
}
