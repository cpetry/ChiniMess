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
import Figures.Pawn;
import Figures.Queen;

public class NegamaxABPlayer extends NegamaxPlayer{

    long start_time, maximum_time, time_spent;
    int start_depth;
    int time_counter;
    int best_value;
    boolean timeover;
    boolean playerOnTurn;
    
    public NegamaxABPlayer(int maximum_time){
        this.maximum_time = maximum_time;
    }
    
    public Move chooseMove(Board b) {
        this.playerOnTurn = b.getPlayerOnTurn();
        //System.out.println(this.playerOnTurn);
        this.time_counter = 0;
        this.timeover = false;
        this.start_time = System.currentTimeMillis();
        this.start_depth = 2;
        this.best_value = -this.INF;
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
    	if (depth == 0){
    	    return state.calculateScore();
    	}
    	if (game_status != GameStatus.GAME_RUNNING){
            if ((game_status == GameStatus.GAME_BLACKWINS && this.playerOnTurn == Board.BLACK)
             || (game_status == GameStatus.GAME_WHITEWINS && this.playerOnTurn == Board.WHITE)){
                return state.calculateScore() + 100 - (this.start_depth - depth);
            }
            else if ((game_status == GameStatus.GAME_BLACKWINS && this.playerOnTurn == Board.WHITE)
                  || (game_status == GameStatus.GAME_WHITEWINS && this.playerOnTurn == Board.BLACK)){
                return state.calculateScore() + 100 - (this.start_depth - depth);
            }
            else
                return state.calculateScore() + 100 - (this.start_depth - depth);
        }
    	
        int v = -this.INF;
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
            
            int v0 = Math.max(v, -negamax(state, depth-1, -beta, -alpha));
           
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
            

            v = Math.max(v0 , v);
            
            
            
            if (this.timeover)
                return v;
            
            
            if (v >= beta){
                return v;
            }
        }
        return v;    
    }
    
    private Move best_move(Board state, int depth){
        Board start_board = new Board (state);
        ArrayList<Move> moves = state.genMoves();
        Move m0 = null;
        
        for (Move m : moves){
            Figure thrownFigure = null;
            boolean pawn_transformed = false;
            
            //start_board = this.do__move(start_board, m, thrownFigure, pawn_transformed);
            // do 
            /////////
            thrownFigure = start_board.getFigureFromField(m.getTo());
            Figure movingFigure = start_board.getFigureFromField(m.getFrom());
            start_board.executeMove(m);
            start_board.setTurn(!start_board.getPlayerOnTurn());
            Figure movedFigure = start_board.getFigureFromField(m.getTo());
            if (movingFigure instanceof Pawn && movedFigure instanceof Queen) // Pawn changed into Queen
                pawn_transformed = true;
            else
                pawn_transformed = false;
            ///////////////
            
            int v0 = -this.INF;
            //System.out.println(this.playerOnTurn);
            GameStatus status = start_board.gameOver();
            if (status != GameStatus.GAME_RUNNING){
                if ((status == GameStatus.GAME_BLACKWINS && this.playerOnTurn == Board.BLACK)
                 || (status == GameStatus.GAME_WHITEWINS && this.playerOnTurn == Board.WHITE)){
                    v0 = start_board.calculateScore() + 100;
                    //System.out.println(v0);
                }
                else if ((status == GameStatus.GAME_BLACKWINS && this.playerOnTurn == Board.WHITE)
                      || (status == GameStatus.GAME_WHITEWINS && this.playerOnTurn == Board.BLACK)){
                    v0 = start_board.calculateScore() + 100;
                    //System.out.println(v0);
                }
                else{
                    //System.out.println( "DRAW!");
                    v0 = start_board.calculateScore();
                }
            }
            else 
                v0 = -negamax(start_board, depth-1, -this.INF, this.INF);
            
            //start_board = this.undo__move(start_board, m, thrownFigure, pawn_transformed);
            // undo
            ///////////////
            Move move = new Move(m.getTo(), m.getFrom());
            start_board.executeMove(move);
            
            if (pawn_transformed)
                start_board.setFigureToField(m.getFrom(), new Pawn(start_board.getFigureFromField(m.getFrom()).getColor()));
            
            if (start_board.getPlayerOnTurn() == Board.BLACK)
                start_board.setMoveNumber(state.getMoveNumber() - 1);
            start_board.setFigureToField(m.getTo(), thrownFigure);
            start_board.setTurn(!start_board.getPlayerOnTurn());
            ///////////////
            
            if (v0 > this.best_value){
                this.best_value = v0;
                //if (this.move_depth <= this.end_depth){
                //	end_depth = move_depth;
                	m0 = m;
                	//System.out.println("BestMove: " + m0 + " Points: " + v0);
                //}
                
            }
            
            this.time_counter++;
            if (this.time_counter > 100){
                //System.out.println("time counter");
                this.time_counter = 0;
                this.time_spent = System.currentTimeMillis() - start_time;
                //System.out.println(time_spent);
                if (this.time_spent > this.maximum_time){
                    //System.out.println("Time over!");
                    this.timeover = true;
                }
            }
            
            if (this.timeover)
                return null;
        }
        return m0;
    }
}
