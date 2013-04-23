package Players;

import java.util.ArrayList;

import ChiniMess.Board;
import ChiniMess.Move;

public class greedyPlayer extends Player {

	
	private int maxScore;
	
	public greedyPlayer() {
		maxScore = -10000;
		
	}
	
	public Move chooseMove(Board b) {
		ArrayList<Move> moves = b.genMoves();
        Move bestMove = null;
        
        for (Move m : moves){
            Board bTest = new Board();
            bTest.checkAndSetBoardFromInput(b.toString());
            bTest.executeMove(m);
            
            int score = -bTest.calculateScore();
            if (score > this.maxScore){
                this.maxScore = score;
                bestMove = m;
            }
        }
        System.out.println(this.maxScore);
        return bestMove;
	}

}
