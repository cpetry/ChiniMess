package Figures;

import ChiniMess.Move;

public class Queen extends Figure{

    public Queen(boolean white) {
        super(white);
        if (this.white)
            this.figure = 'Q';
        else
            this.figure = 'q';
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean checkMove(Move m) {
        // TODO Auto-generated method stub
        return false;
    }
}
