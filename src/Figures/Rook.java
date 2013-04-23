package Figures;

import ChiniMess.Move;

public class Rook extends Figure{

    public Rook(boolean white) {
        super(white);
        if (this.white)
            this.figure = 'R';
        else
            this.figure = 'r';
    }

    @Override
    public boolean canMoveTo(int dr, int dc) {
        if (dr == 0 && dc == 0) // not moving at all
            return false;
        
        else if ((Math.abs(dr) >= 1 && dc == 0)     // left and right
                || (dr == 0 && Math.abs(dc) >= 1))   // up and down
            return true;
        
        return false;
    }

    @Override
    public boolean canCapture(int dr, int dc) {
        return this.canMoveTo(dr, dc);
    }
}
