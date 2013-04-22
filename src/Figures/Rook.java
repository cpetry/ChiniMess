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
    public boolean checkMove(Move m) {
        // TODO Auto-generated method stub
        return false;
    }
}
