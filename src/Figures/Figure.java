package Figures;

import ChiniMess.Move;
import ChiniMess.Square;

public abstract class Figure {
    protected boolean white;
    protected char figure;
    
    public Figure(boolean white){
        this.white = white;
    }
    
    public abstract boolean canMoveTo(int dr, int dc);
    public abstract boolean canCapture(int dr, int dc);
    
    /**
     * Tests the Move-command if the figure can execute it.
     * @param m :  move command
     * @return boolean : true if figure can move or capture square, false if not.
     */
    public boolean canExecuteMove(Move m){
        int start_col = m.getFrom().getCol();
        int start_row = m.getFrom().getRow();
        int end_col = m.getTo().getCol();
        int end_row = m.getTo().getRow();
        
        int delta_col = end_col - start_col;
        int delta_row = end_row - start_row;
        
        if (this.canMoveTo(delta_row, delta_col)    // can move to square
          || this.canCapture(delta_row, delta_col)) // can capture square
            return true;
        else
            return false;
    }
    
    /**
     * @brief gets back the color of the figure
     * @return boolean : true if white, false if black
     */
    public boolean getColor(){
        return this.white;
    }
    
    public String toString(){
        return this.figure + "";
    }
}
