package ChiniMess;

public class Square {

	public int col, row;
	
	
	

    public Square(String koordinaten){
		
		char [] chararray = koordinaten.toCharArray();
		
		switch(chararray[0]){
		
			case 'a' : col = 0; 
			case 'b' : col = 1; 
			case 'c' : col = 2; 
			case 'd' : col = 3; 
			case 'e' : col = 4; 
			
			default : col = -1;
		}
		switch(chararray[1]){
		
			case '1' : row = 0;
			case '2' : row = 1;
			case '3' : row = 2;
			case '4' : row = 3;
			case '5' : row = 4;
			case '6' : row = 5;
			
			default : row = -1;
		}
	}
	
	public Square(int col, int row){
		
		this.col = col;
		this.row = row;
		
	}

	public String toString(){
		
		return col+""+row;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + col;
        result = prime * result + row;
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
        Square other = (Square) obj;
        if (col != other.col)
            return false;
        if (row != other.row)
            return false;
        return true;
    }
}
