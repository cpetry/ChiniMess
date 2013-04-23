package ChiniMess;

import java.util.ArrayList;

public class Game {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Board b = new Board(); // normal standard Board
        System.out.println(b);
        while(!b.gameOver()){
            Move m;
            if (b.getPlayerOnTurn() == Board.BLACK)
                m = greedyPlayer(b);
            else //if (b.getPlayerOnTurn() == Board.BLACK)
                m = randomPlayer(b);
            
            System.out.println("picked Move:" + m);
            b.executeMove(m);
            System.out.println(b);
            System.out.println(b.calculateScore());
        }
        System.out.println(b);

    }
    
    
    public static Move randomPlayer(Board b){
        ArrayList<Move> moves = b.genMoves();
        int rand = (int) (Math.random() * (moves.size() - 1));
        return moves.get(rand);
    }
    
    public static Move greedyPlayer(Board b){
        ArrayList<Move> moves = b.genMoves();
        int maxScore = -100000;
        Move bestMove = null;
        
        for (Move m : moves){
            Board bTest = new Board();
            bTest.checkAndSetBoardFromInput(b.toString());
            bTest.executeMove(m);
            
            int score = -bTest.calculateScore();
            if (score > maxScore){
                maxScore = score;
                bestMove = m;
            }
        }
        System.out.println(maxScore);
        return bestMove;
    }

}
