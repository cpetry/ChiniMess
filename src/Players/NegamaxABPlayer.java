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
        int d = 1;
        Move m = best_move(b, 0);
        
        while(true){
            Move m_next = best_move(b, d);
            if (System.currentTimeMillis() - start_time > maximum_time){
                return m;
            }
            m = m_next;
            d = d + 1;
        }
    }
    
    private int negamax(Board state, int depth, int beta, int alpha){
        if (depth == 0)
            return state.calculateScore();
        
        ArrayList<Board> next_states = new ArrayList<Board>();
        
        for (Move m : state.genMoves()){
            Board next_state = new Board(state);
            next_state.executeMove(m);
            next_states.add(next_state);
        }
        
        // sort reverse order because best one should be first!
        Collections.sort(next_states); 
        
        /*System.out.println("test");
        for (Board test : next_states){
            System.out.println(test.calculateScore());
        }*/
        
        int score = 0;
        
        for (Board next_state : next_states){
            if (next_state.gameOver() != GameStatus.GAME_RUNNING){
                if (next_state.gameOver() == GameStatus.GAME_DRAW)
                    score = 0;
                else if ((next_state.gameOver() == GameStatus.GAME_WHITEWINS
                        && next_state.getPlayerOnTurn() == Board.WHITE)
                        || (next_state.gameOver() == GameStatus.GAME_BLACKWINS
                        && next_state.getPlayerOnTurn() == Board.BLACK))
                    score = -this.INF;
                else
                    score = this.INF;
            }
            else
                score = -negamax(next_state, depth-1, -beta, -alpha);
            
            if (score > beta)
               return score;
            if (score > alpha)
               alpha = score;
        }
        return alpha;
    }
    
    private Move best_move(Board state, int depth){
        int a0 = -this.INF;
        int b0 = this.INF;
        
        int score = 0;
        ArrayList<Move> moves = state.genMoves();
        Move m0 = null;
        for (Move m : moves){
            Board next_state = new Board(state);
            next_state.executeMove(m);
            score = -negamax(next_state, depth, -b0, -a0); 
            if (score > a0){
                m0 = m;
                a0 = score;
            }
        }
        //System.out.println("highest value: " + score);
        
        return m0;
    }
}
