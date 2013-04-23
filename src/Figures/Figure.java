package Figures;

import ChiniMess.Move;
import ChiniMess.Square;

public abstract class Figure {
    protected boolean white;
    protected char figure;
    
    public Figure(boolean white){
        this.white = white;
    }
    
    public abstract boolean checkMove(Move m);
    public abstract boolean canMoveTo(int dr, int dc);
    public abstract boolean canCapture(int dr, int dc);
    
    public String toString(){
        return this.figure + "";
    }
}
