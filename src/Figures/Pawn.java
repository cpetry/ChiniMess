package Figures;

import ChiniMess.Move;

public class Pawn extends Figure{

    Pawn(boolean white) {
        super(white);
        if (this.white)
            this.figure = 'P';
        else
            this.figure = 'p';
    }

    @Override
    public boolean checkMove(Move m) {
        // TODO Auto-generated method stub
        return false;
    }    
}
