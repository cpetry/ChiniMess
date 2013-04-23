package Figures;

import ChiniMess.Move;

public class Bishop extends Figure{

    public Bishop(boolean white) {
        super(white);
        if (this.white)
            this.figure = 'B';
        else
            this.figure = 'b';
        this.score = 300;
    }

    @Override
    /**
     * @brief Bishop can move diagonal several squares.
     *          Extra: He can move one square to every direction.
     *                     "He can change color"
     */
    public boolean canMoveTo(int dr, int dc) {
        if (dr == 0 && dc == 0) // not moving at all
            return false;
        
        else if ((Math.abs(dr) == 1 && dc == 0)                 // left and right
                || (dr == 0 && Math.abs(dc) == 1)               // up and down
                || (Math.abs(dr) >= 1 && Math.abs(dc) >= 1 && Math.abs(dc) == Math.abs(dr)))    // diagonal
            return true;
        
        return false;
    }

    @Override
    /**
     * @brief Bishops can capture only diagonal!
     */
    public boolean canCapture(int dr, int dc) {
        if (dr == 0 && dc == 0) // not moving at all
            return false;
        
        else if (Math.abs(dr) >= 1 && Math.abs(dc) >= 1 && Math.abs(dc) == Math.abs(dr))    // diagonal
            return true;
        
        return false;
    }
}
