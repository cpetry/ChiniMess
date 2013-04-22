package ChiniMess;

public class Square {

	private int col, row;
	
	
	public Square(String koordinaten){
		
		char [] chararray = koordinaten.toCharArray();
		
		switch(chararray[0]){
		
			case 'a' : col = 0; 
			case 'b' : col = 1; 
			case 'c' : col = 2; 
			case 'd' : col = 3; 
			case 'e' : col = 4; 
		
		}
		switch(chararray[1]){
		
			case '1' : row = 0;
			case '2' : row = 1;
			case '3' : row = 2;
			case '4' : row = 3;
			case '5' : row = 4;
			case '6' : row = 5;
			
		}
	}
	
	public Square(int col, int row){
		
		this.col = col;
		this.row = row;
		
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
	
	public String toString(){
		
		return col+""+row;
	}
	
}
