package Figures;

import ChiniMess.Move;
import ChiniMess.Square;

public class Queen extends Figure{

    public Queen(boolean white) {
        super(white);
        if (this.white)
            this.figure = 'Q';
        else
            this.figure = 'q';
        this.score = 900;
    }

    @Override
    public boolean canMoveTo(int dr, int dc) {
        if (dr == 0 && dc == 0) // not moving at all
            return false;
        
        else if ((Math.abs(dr) >= 1 && dc == 0)                 // left and right
                || (dr == 0 && Math.abs(dc) >= 1)               // up and down
                || (Math.abs(dr) >= 1 && Math.abs(dc) >= 1 && Math.abs(dc) == Math.abs(dr)))    // diagonal
            return true;
        
        return false;
    }

    @Override
    public boolean canCapture(int dr, int dc) {
        return this.canMoveTo(dr, dc);
    }
}
