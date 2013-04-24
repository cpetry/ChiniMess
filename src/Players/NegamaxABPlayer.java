package Players;

import java.util.ArrayList;

import ChiniMess.Board;
import ChiniMess.Move;

public class NegamaxABPlayer extends NegamaxPlayer{

    public Move chooseMove(Board b) {
        ArrayList<Move> moves = b.genMoves();
        System.out.println(moves);
        int alpha = -this.INF;
        
        negamax(b, this.start_depth, alpha, beta);
        
        return this.best_move;
    }
    
    private int negamax(Board state, int depth, int alpha, int beta){
        
    }
}
