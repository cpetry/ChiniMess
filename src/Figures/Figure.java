package Figures;

import ChiniMess.Move;

public abstract class Figure {
    protected boolean white;
    protected char figure;
    protected boolean canJump;
    protected int score;
    
    public Figure(boolean white){
        this.score = 0;
        this.white = white;
        this.canJump = false;   //normally no one can jump (except knight)
    }
    
    public abstract boolean canMoveTo(int dr, int dc);
    public abstract boolean canCapture(int dr, int dc);
    
    public boolean canJump(){
        return this.canJump;
    }
    
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
         
        return this.canMoveTo(delta_row, delta_col);    // can move to square
    }
    
    public boolean canExecuteCapture(Move m){
        int start_col = m.getFrom().getCol();
        int start_row = m.getFrom().getRow();
        int end_col = m.getTo().getCol();
        int end_row = m.getTo().getRow();
        
        int delta_col = end_col - start_col;
        int delta_row = end_row - start_row;
        return  this.canCapture(delta_row, delta_col); // can capture square
    }
    
    /**
     * @brief gets back the color of the figure
     * @return boolean : true if white, false if black
     */
    public boolean getColor(){
        return this.white;
    }
    
    /**
     * @brief gets back the score for that figure
     * @return int : score number
     */
    public int getScore(){
        return this.score;
    }
    
    public String toString(){
        return this.figure + "";
    }
}
