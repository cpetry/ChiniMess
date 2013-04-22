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
}
