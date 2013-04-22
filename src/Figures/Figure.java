copyright @ 2013 Christian Petry

package Figures;

import ChiniMess.Move;

public abstract class Figure {
    private boolean white;
    private char figure;
    
    public abstract boolean checkMove(Move m);
    public abstract String toString();
}
