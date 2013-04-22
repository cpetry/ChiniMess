package Figures;

import ChiniMess.Move;

public class Bishop extends Figure{

    Bishop(boolean white, char figure) {
        super(white);
        if (this.white)
            this.figure = 'B';
        else
            this.figure = 'b';
    }
    
    @Override
    public boolean checkMove(Move m) {
        // TODO Auto-generated method stub
        return false;
    }
}
