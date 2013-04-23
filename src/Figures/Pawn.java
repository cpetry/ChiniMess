package Figures;

import ChiniMess.Move;

public class Pawn extends Figure{

    public Pawn(boolean white) {
        super(white);
        if (this.white)
            this.figure = 'P';
        else
            this.figure = 'p';
        this.score = 100;
    }

    @Override
    public boolean canMoveTo(int dr, int dc) {
        if (dr == 0 && dc == 0) // not moving at all
            return false;    
        
        else if ((this.white && dr == -1 && dc == 0)    // forward for white
                || (!this.white && dr == 1 && dc == 0)) // forward for black
            return true;
            
        return false;
    }
    
    public boolean canCapture(int dr, int dc){
        if (dr == 0 && dc == 0) // not moving at all
            return false;
        else if ((this.white && dr == -1 && Math.abs(dc) == 1)     // diagonal forward for white
              || (!this.white && dr == 1 && Math.abs(dc) == 1))     // diagonal forward for black
            return true;
        return false;
    }
}
