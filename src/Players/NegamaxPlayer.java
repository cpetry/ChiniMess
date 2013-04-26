package Players;

import java.util.ArrayList;

import ChiniMess.Board;
import ChiniMess.GameStatus;
import ChiniMess.Move;
import Figures.Figure;
import Figures.Pawn;
import Figures.Queen;

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
            Figure thrownFigure = null;
            boolean pawn_transformed = false;
            
            //state = this.do__move(state, m, thrownFigure, pawn_transformed);
            // do 
            /////////
            thrownFigure = state.getFigureFromField(m.getTo());
            Figure movingFigure = state.getFigureFromField(m.getFrom());
            state.executeMove(m);
            Figure movedFigure = state.getFigureFromField(m.getTo());
            if (movingFigure instanceof Pawn && movedFigure instanceof Queen) // Pawn changed into Queen
                pawn_transformed = true;
            else
                pawn_transformed = false;
            ///////////////
            
            if (state.gameOver() != GameStatus.GAME_RUNNING)
                return -state.calculateScore();
            
            int value = -negamax(state, depth - 1);
            
            //state = this.undo__move(state, m, thrownFigure, pawn_transformed);
            // undo
            ///////////////
            Move move = new Move(m.getTo(), m.getFrom());
            state.executeMove(move);
            
            if (pawn_transformed)
                state.setFigureToField(m.getFrom(), new Pawn(state.getFigureFromField(m.getFrom()).getColor()));
            
            if (state.getPlayerOnTurn() == Board.BLACK)
                state.setMoveNumber(state.getMoveNumber() - 1);
            state.setFigureToField(m.getTo(), thrownFigure);
            ///////////////


            //System.out.println(state);
            
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
    
    public Board do__move(Board b, Move m, Figure thrownFigure, boolean pawn_transformed){
        thrownFigure = b.getFigureFromField(m.getTo());
        Figure movingFigure = b.getFigureFromField(m.getFrom());
        
        b.executeMove(m);
        
        Figure movedFigure = b.getFigureFromField(m.getTo());
        if (movingFigure instanceof Pawn && movedFigure instanceof Queen) // Pawn changed into Queen
            pawn_transformed = true;
        else
            pawn_transformed = false;
        return new Board(b);
    }
    
    public Board undo__move(Board b, Move m, Figure thrownFigure, boolean pawn_transformed){
        Move move = new Move(m.getTo(), m.getFrom());
        b.executeMove(move);
        
        if (pawn_transformed)
            b.setFigureToField(m.getFrom(), new Pawn(b.getFigureFromField(m.getFrom()).getColor()));
        
        if (b.getPlayerOnTurn() == Board.BLACK)
            b.setMoveNumber(b.getMoveNumber() - 1);
        b.setFigureToField(m.getTo(), thrownFigure);
        return new Board(b);
    }
}
