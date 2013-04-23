package ChiniMess;

import java.util.ArrayList;

public class Game {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Board b = new Board(); // normal standard Board
        b.toString();
        while(!State.gameOver(b)){
            ArrayList<Move> moves = b.genMoves();
            Move m = randomPlayer(moves);
            b.executeMove(m);
            b.toString();
        }

    }
    
    
    public static Move randomPlayer(ArrayList<Move> moves){
        int rand = (int) (Math.random() * (moves.size() - 0));
        return moves.get(rand);
    }

}
