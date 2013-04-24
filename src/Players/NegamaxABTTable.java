package Players;

import TTable.*;
import ChiniMess.Board;
import ChiniMess.GameStatus;
import ChiniMess.Move;

public class NegamaxABTTable extends NegamaxABPlayer{
    public NegamaxABTTable(long time_to_think) {
        super(time_to_think);
    }

    TTable ttable = new TTable();
    
    private int negamax(Board state, int depth, int alpha, int beta){
        if (state.gameOver() != GameStatus.GAME_RUNNING || depth == 0)
            return state.calculateScore();
        
        TTableEntry t = ttable.getHash(state.hashCode());
        if (t != null 
        && ((t.a < t.value && t.value < t.b)
        || (t.a <= alpha && beta <= t.b))
        && t.depth >= depth)
            return t.value;
        
        
        int value = -1;
        int a0 = alpha;
        
        
        
        for (Move m : state.genMoves()){
            
            Board next_state = new Board(state.toString());
            next_state.executeMove(m);
            value = Math.max(value, -negamax(next_state, depth -1, - beta, -a0));
            a0 = Math.max(a0, value);
            if (value >= beta)
                return value;
        }
        return value;
    }
}
