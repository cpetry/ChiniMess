package Players;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

import ChiniMess.Board;
import ChiniMess.GameStatus;
import ChiniMess.Move;
import Figures.Figure;

public class NegamaxABPlayer extends NegamaxPlayer{

    long start_time, maximum_time, time_spent;
    int start_depth, end_depth, move_depth;
    int time_counter;
    boolean timeover;
    
    public NegamaxABPlayer(int maximum_time){
        this.maximum_time = maximum_time; // 1 sec per move
    }
    
    public Move chooseMove(Board b) {
        this.time_counter = 0;
        this.timeover = false;
        this.start_time = System.currentTimeMillis();
        this.start_depth = 2;
        this.end_depth = this.INF;
        ArrayList<Move> moves = b.genMoves();
        Move m = moves.get(0);
        while(true){
            Board negamaxboard = new Board(b);
            Move m_test = best_move(negamaxboard, start_depth);
            if (this.timeover)
                return m;            
            if (m_test != null)
            	m = m_test;

            start_depth++;
        }
    }
    
    private int negamax(Board state, int depth, int alpha, int beta){
    	
    	GameStatus game_status = state.gameOver();
        if (game_status != GameStatus.GAME_RUNNING || depth == 0){
        	this.move_depth = this.start_depth - depth;
            return state.calculateScore();
        }
    	
        int v = alpha;
        ArrayList<Move> moves = state.genMoves();
        
        for (Move m : moves){
        	this.time_counter++;
            
            if (this.time_counter > 100){
                //System.out.println("time counter");
                this.time_counter = 0;
                this.time_spent = System.currentTimeMillis() - start_time;
                //System.out.println(time_spent);
                if (this.time_spent > this.maximum_time){
                    //System.out.println("Time over!");
                    this.timeover = true;
                    return v;
                }
            }
            
            Figure thrownFigure = null;
            boolean pawn_transformed = false;
            this.do__move(state, m, thrownFigure, pawn_transformed);
            
            int v0 = Math.max(v, -negamax(state, depth-1, -beta, -alpha));
           
            this.undo__move(state, m, thrownFigure, pawn_transformed);
           
            v = Math.max(v0 , v);
            
            if (v >= beta){
                return v;
            }
                
            
        }
        return v;    
    }
    
    private Move best_move(Board state, int depth){
        ArrayList<Move> moves = state.genMoves();
        int v = -this.INF;
        int a0 = -this.INF;
        Move m0 = null;
        
        for (Move m : moves){
        	this.move_depth = this.INF;
            Figure thrownFigure = null;
            boolean pawn_transformed = false;
            this.do__move(state, m, thrownFigure, pawn_transformed);
            
            int v0 = -negamax(state, depth, -this.INF, -a0);
            
            this.undo__move(state, m, thrownFigure, pawn_transformed);            
            
            a0 = Math.max(a0, v0);
            if (v0 >= v){
            	v = v0;
                if (this.move_depth <= this.end_depth){
                	end_depth = move_depth;
                	m0 = m;
                	System.out.println("BestMove: " + m0);
                }
                
            }
            
            if (this.timeover)
                return null;
        }
        return m0;
    }
}
