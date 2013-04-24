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
    
    public NegamaxABPlayer(long time_to_think){
        maximum_time = time_to_think;
    }
    
    public Move chooseMove(Board b) {
        ArrayList<Move> moves = b.genMoves();
        start_time = System.currentTimeMillis();
        return best_move(b);
    }
    
    private int negamax(Board state, int depth, int alpha, int beta){
        if (state.gameOver() != GameStatus.GAME_RUNNING || depth == 0)
            return state.calculateScore();
        
        ArrayList<Board> states = new ArrayList<Board>();
        
        for (Move m : state.genMoves()){
            Board next_state = new Board(state.toString());
            next_state.executeMove(m);
            states.add(next_state);
        }
        
        // sort reverse order because best one should be first!
        Collections.sort(states, Collections.reverseOrder()); 
        
        int value = -1;
        int a0 = alpha;
        for (Board next_state : states){
            value = Math.max(value, -negamax(next_state, depth -1, - beta, -a0));
            a0 = Math.max(a0, value);
            if (value >= beta)
                return value;
        }
        return value;
    }
    
    private Move best_move(Board state){
        int d0 = 1;
        ArrayList<Move> moves = state.genMoves();
        Move m0 = null;
        while((System.currentTimeMillis() - start_time) < maximum_time) {
            int value = -100;
            int a0 = -1;            
            for (Move m : moves){
                Board next_state = new Board(state.toString());
                next_state.executeMove(m);
                int v0 = Math.max(value, -negamax(next_state, d0, -1, -a0)); 
                a0 = Math.max(a0, v0);
                if (v0 > value)
                    m0 = m;
                value = Math.max(value, v0);
               
                if ((System.currentTimeMillis() - start_time) > maximum_time)
                   break;
            }
            d0 = d0 + 1;
        }
        return m0;
    }
}
