package Figures;

import ChiniMess.Move;

public class Bishop extends Figure{

    public Bishop(boolean white) {
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
