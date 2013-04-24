package Players;

import ChiniMess.Board;
import ChiniMess.Move;

public abstract class Player {
    public final int INF = 100000; 
    
	public abstract Move chooseMove(Board b);
}
