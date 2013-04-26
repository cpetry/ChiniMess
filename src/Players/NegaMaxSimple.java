package Players;

import java.util.ArrayList;

import ChiniMess.Board;
import ChiniMess.Move;
import Figures.Figure;

public class NegaMaxSimple extends Player {
	
	private Move save = null;
	private int depth = 4;
	private ArrayList<Move> move_list;
	private Board board;
	
	public NegaMaxSimple(){
	}
	
	public NegaMaxSimple(int depth){
		this.depth = depth;

	}
	
	public Move chooseMove(Board b) {
		
		board = b;
		move_list = b.genMoves();
		miniMax(depth);
		return save;
	}
	
	private int miniMax(int depth){
			

		if(depth == 0 || move_list == null){
			return board.calculateScore();
	}
		
		int max = -INF;
		move_list = board.genMoves();
		
		for(Move m: move_list){

			Figure figure_from = board.getFigureFromField(m.getFrom());
			Figure figure_to = board.getFigureFromField(m.getTo());
			int movenumber = board.getMoveNumber();
			boolean onmove = board.onMove;
			doMove(m, movenumber, onmove);
			
			int value = depth * -miniMax(depth-1);
			
			undoMove(m, figure_from, figure_to, onmove, movenumber);
			if( value > max){
				max = value;
				if(depth == this.depth){
					save = m;
			
				}
			}
		}
		return max;
	}
	
	private void doMove(Move m, int movenumber, boolean color){
		
		board.executeMove(m);
	}
	
	private void undoMove(Move m, Figure figure_from, Figure figure_to, boolean moveon, int movenumber){
		
		board.onMove = moveon;
		board.setMoveNumber(movenumber);
		board.setFigureToField(m.getFrom(), figure_from);
		board.setFigureToField(m.getTo(), figure_to);
	}
}

