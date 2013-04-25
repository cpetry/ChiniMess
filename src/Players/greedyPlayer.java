package Players;

import java.util.ArrayList;

import ChiniMess.Board;
import ChiniMess.Move;

public class GreedyPlayer extends Player {	
	public GreedyPlayer() {}
	
	public Move chooseMove(Board b) {
	    int max_score = -100001;
		ArrayList<Move> moves = b.genMoves();
        Move bestMove = null; // = moves.get(0);       // at least (if no better move is found) take the first one
        int score = -b.calculateScore();
        
        for (Move m : moves){
            Board bTest = new Board(b.toString());
            bTest.executeMove(m);
            
            score = bTest.calculateScore();
            if (score > max_score){
                System.out.println("better move :) ");
                max_score = score;
                bestMove = m;              
            }
        }
        return bestMove;
	}

}
