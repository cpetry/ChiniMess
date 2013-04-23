package Figures;

import ChiniMess.Move;

public class Knight extends Figure{

    public Knight(boolean white) {
        super(white);
        if (this.white)
            this.figure = 'N';
        else
            this.figure = 'n';
    }

    @Override
    public boolean checkMove(Move m) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean canMoveTo(int dr, int dc) {
        if (dr == 0 && dc == 0) // not moving at all
            return false;
        else if ((Math.abs(dr) == 2 && Math.abs(dc) == 1)     // 4 possibilities
                || (Math.abs(dr) == 1 && Math.abs(dc) == 2))  // other 4 possibilities
            return true;
        return false;
    }

    @Override
    public boolean canCapture(int dr, int dc) {
       return this.canMoveTo(dr, dc);
    }
}
