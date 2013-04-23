package Players;

import java.util.ArrayList;

import ChiniMess.Board;
import ChiniMess.Move;

public class RandomPlayer extends Player {

	public Move chooseMove(Board b) {
		ArrayList<Move> moves = b.genMoves();
		int rand = (int) (Math.random() * (moves.size() - 1));
		return moves.get(rand);
	}

}
