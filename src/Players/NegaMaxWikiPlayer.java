package Players;

import java.util.ArrayList;

import ChiniMess.Board;
import ChiniMess.Move;
import Figures.Figure;

public class NegaMaxWikiPlayer extends Player {
	
	private Move save = null;
	private int depth = 4;
	private ArrayList<Move> moeglich;
	private Board board;
	
	public NegaMaxWikiPlayer(){
	}
	
	public NegaMaxWikiPlayer(int depth){
		this.depth = depth;

	}
	
	public Move chooseMove(Board b) {
		
		board = b;
		moeglich = b.genMoves();
		miniMax(depth);
		return save;
	}
	
	private int miniMax(int depth){
			

		if(depth == 0 || moeglich == null){
			return board.calculateScore();
	}
		
		int max = -INF;
		moeglich = board.genMoves();
		
		for(Move m: moeglich){

			Figure figure_from = board.getFigureFromField(m.getFrom());
			Figure figure_to = board.getFigureFromField(m.getTo());
			int movenumber = board.getMoveNumber();
			boolean onmove = board.onMove;
			doMove(m, movenumber, onmove);
			
			int wert = depth * -miniMax(depth-1);
			
			undoMove(m, figure_from, figure_to, onmove, movenumber);
			if( wert > max){
				max = wert;
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

/*int miniMax(int spieler, int tiefe) {
if (tiefe == 0 or keineZuegeMehr(spieler))
   return bewerten(spieler);
int maxWert = -unendlich;
generiereMoeglicheZuege(spieler);
while (noch Zug da) {
   fuehreNaechstenZugAus();
   int wert = -miniMax(-spieler, tiefe-1);
   macheZugRueckgaengig();
   if (wert > maxWert) {
      maxWert = wert;
      if (tiefe == anfangstiefe)
         gespeicherterZug = Zug;
   }
}
return maxWert;
}
*/
