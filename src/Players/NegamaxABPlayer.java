package Players;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

import ChiniMess.Board;
import ChiniMess.GameStatus;
import ChiniMess.Move;

public class NegamaxABPlayer extends NegamaxPlayer{

    long start_time, maximum_time;
    int depth=0;
    
    public NegamaxABPlayer(int depth){
        this.depth = depth;
        maximum_time = 1000; // 1 sec per move
    }
    
    public Move chooseMove(Board b) {
        start_time = System.currentTimeMillis();
        Move m = best_move(b, this.depth);
        return m;
    }
    
    private int negamax(Board state, int depth, int beta, int alpha){
       if (state.gameOver() != GameStatus.GAME_RUNNING || depth == 0)
           return state.calculateScore();
        
        int v = -this.INF;
       ArrayList<Move> moves = state.genMoves();
       for (Move m : moves){
           Board next_state = new Board(state);
           next_state.executeMove(m);
           v = Math.max(v, -negamax(next_state, depth-1, -beta, -alpha));
           
           //state.executeMove(new Move(m.getTo(), m.getFrom()));
           
           alpha = Math.max(alpha, v);
           if (v>= beta)
               return v;
       }
       return v;    }
    
    private Move best_move(Board state, int depth){
        int d0 = 1;
        ArrayList<Move> moves = state.genMoves();
        Move m0 = moves.get(0);
        while(System.currentTimeMillis() - start_time < maximum_time){
            int v = -this.INF;
            int a0 = -this.INF;
            for (Move m : moves){
                
                Board next_state = new Board(state);
                next_state.executeMove(m);
                int v0 = Math.max(v, -negamax(next_state, d0, -this.INF, -a0));
                
                //next_state.executeMove(new Move(m.getTo(), m.getFrom()));
                
                a0 = Math.max(a0, v0);
                if (v0 >= v)
                    m0 = m;
                v = Math.max(v,v0);
            }
            d0 = d0 + 1;
        }
        return m0;
    }
}
