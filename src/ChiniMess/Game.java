package ChiniMess;

import java.util.ArrayList;

public class Game {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Board b = new Board(); // normal standard Board
        System.out.println(b);
        while(!State.gameOver(b)){
            ArrayList<Move> moves = b.genMoves();
            System.out.println(moves);
            Move m = randomPlayer(moves);
            System.out.println("picked Move:" + m);
            b.executeMove(m);
            System.out.println(b);
            System.out.println(State.calculateScore(b));
        }

    }
    
    
    public static Move randomPlayer(ArrayList<Move> moves){
        int rand = (int) (Math.random() * (moves.size() - 1));
        return moves.get(rand);
    }

}
