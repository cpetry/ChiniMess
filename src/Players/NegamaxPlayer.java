package Players;

import java.util.ArrayList;

import ChiniMess.Board;
import ChiniMess.GameStatus;
import ChiniMess.Move;
import Figures.Figure;

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
        int v = -this.negamax(b, start_depth);
        return this.best_move;
    }
    
    private int negamax(Board state, int depth){
        
        // depth == 0 or game over
        if (depth <= 0 || state.gameOver() != GameStatus.GAME_RUNNING)
            return state.calculateScore();
                
        ArrayList<Move> moves = state.genMoves();   // get possible moves from state
       
        int best_value = -this.INF;
        
        for (Move m : moves){
            //Board next_state = new Board(state); 
            //next_state.executeMove(m);
            
            System.out.println(state);
            Figure thrownFigure = this.do__move(state, m);
            
            
            int value = -negamax(state, depth-1);
            //value = -negamax(next_state, depth-1);
            
            this.undo__move(state, m, thrownFigure);
            
            System.out.println(state);
            
            if (value > best_value){
                best_value = value;
                if (depth == start_depth){
                    //System.out.println("Value: " + best_value + ", Move" + m);
                    this.best_move = m;
                }
            }
        }
        
        return best_value;
    }
    
    protected Figure do__move(Board b, Move m){
        Figure thrownFigure = b.getFigureFromField(m.getTo());
        b.executeMove(m);
        return thrownFigure;
    }
    
    protected void undo__move(Board b, Move m, Figure f){
        b.executeMove(new Move(m.getTo(), m.getFrom()));
        b.setFigureToField(m.getTo(), f);
    }
}
