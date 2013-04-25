package Figures;

public class King extends Figure {

    public King(boolean white) {
        super(white);
        if (white)
            this.figure = 'K';
        else
            this.figure = 'k';
    }

    @Override
    public boolean canMoveTo(int dr, int dc) {
        if (dr == 0 && dc == 0) // not moving at all
            return false;
        else if ((Math.abs(dr) == 1 && dc == 0)                 // left and right
                || (dr == 0 && Math.abs(dc) == 1)               // up and down
                || (Math.abs(dr) == 1 && Math.abs(dc) == 1))    // diagonal
            return true;
        return false;
    }

    @Override
    public boolean canCapture(int dr, int dc) {
        return this.canMoveTo(dr, dc);
    }
}
