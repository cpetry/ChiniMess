package Players;

import java.util.ArrayList;

import ChiniMess.Board;
import ChiniMess.GameStatus;
import ChiniMess.Move;

public class NegamaxPlayer extends Player{

    protected Move best_move;
    protected int start_depth;
    
    public NegamaxPlayer(){
        start_depth = 2;
    }
    
    public NegamaxPlayer(int depth){
        start_depth = depth;
    }
    
    @Override
    public Move chooseMove(Board b) {        
        int v = this.negamax(b, start_depth);
        return this.best_move;
    }
    
    private int negamax(Board state, int depth){
        
        if (depth <= 0 || state.gameOver() != GameStatus.GAME_RUNNING)
            return state.calculateScore();
        
        int best_value = -this.INF;
        
        ArrayList<Move> moves = state.genMoves();
       
        Board b2 = new Board(state);
        b2.executeMove(moves.get(0));
        this.best_move = moves.get(0);
        best_value =  b2.calculateScore();
        
        for (Move m : moves){
            Board next_state = new Board(state); 
            next_state.executeMove(m);
            
            int value = -negamax(next_state, depth-1);
            if (value > best_value){
                best_value = value;
            }
            
            if (depth == start_depth)
                this.best_move = m;
        }
        
        return best_value;
    }
    

}
