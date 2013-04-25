package Players;

import java.util.ArrayList;

import ChiniMess.Board;
import ChiniMess.Move;

public class NegaMaxWikiPlayer extends Player {
	
	private Move save = null;
	private int depth = 4;
	private ArrayList<Move> moeglich;
	
	public NegaMaxWikiPlayer(){
	}
	
	public NegaMaxWikiPlayer(int depth){
		this.depth = depth;

	}
	
	public Move chooseMove(Board b) {
		

		moeglich = b.genMoves();
		miniMax(depth, new Board(b));
		return save;
	}
	
	private int miniMax(int depth, Board b){
			
		
		if(depth == 0 || moeglich == null){
			return b.calculateScore();
	}
		
		int max = -INF;
		moeglich = b.genMoves();
		
		for(Move m: moeglich){
			Board temp = new Board(b);
			temp.executeMove(m);
			int wert = depth * -miniMax(depth-1, temp);
			
			if( wert > max){
				max = wert;
				if(depth == this.depth){
					save = m;
			
				}
			}
		}
		return max;
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
