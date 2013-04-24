package Players;

import java.util.ArrayList;

import ChiniMess.Board;
import ChiniMess.GameStatus;
import ChiniMess.Move;

public class NegamaxPlayer extends Player{

    protected Move best_move = null;
    protected int start_depth;
    
    public NegamaxPlayer(){
        start_depth = 2;
    }
    
    public NegamaxPlayer(int depth){
        start_depth = depth;
    }
    
    @Override
    public Move chooseMove(Board b) {
        ArrayList<Move> moves = b.genMoves();
        System.out.println(moves);
        
        negamax(b, start_depth);
        
        return this.best_move;
    }
    
    private int negamax(Board state, int depth){
        
        if (depth <= 0 || state.gameOver() != GameStatus.GAME_RUNNING)
            return state.calculateScore();
        
        int value = 0;
        int best_value = -this.INF;
        
        ArrayList<Move> moves = state.genMoves();
        
        for (Move m : moves){
            Board next_state = new Board(state.toString());
            next_state.executeMove(m);
            
            value = -negamax(next_state, depth-1);
            if (value > best_value){
                if (depth == start_depth)
                    this.best_move = m;
                best_value = value;
            }
        }
        
        return best_value;
    }
    

}
