package Figures;

import ChiniMess.Move;

public abstract class Figure {
    protected boolean white;
    protected char figure;
    
    Figure(boolean white){
        this.white = white;
    }
    
    public abstract boolean checkMove(Move m);
    public String toString(){
        return this.figure + "";
    }
}
