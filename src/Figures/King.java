package Figures;

import ChiniMess.Move;

public class King extends Figure {

    King(boolean white) {
        super(white);
        if (white)
            this.figure = 'K';
        else
            this.figure = 'k';
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean checkMove(Move m) {
        // TODO Auto-generated method stub
        return false;
    }
}
