package ChiniMess;

import java.util.ArrayList;

public class Game {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Board b = new Board(); // normal standard Board
        GameStatus status = GameStatus.GAME_RUNNING;
        System.out.println(b);
        
        while(status == GameStatus.GAME_RUNNING){
            Move m;
            if (b.getPlayerOnTurn() == Board.BLACK)
                m = randomPlayer(b);
            else //if (b.getPlayerOnTurn() == Board.BLACK)
                m = randomPlayer(b);
            
            
            b.executeMove(m);
            status = b.gameOver();
            System.out.println(b);
            System.out.println("picked Move:" + m);
            System.out.println("Score: " + b.calculateScore() + "Moves: " + b.getMoveNumber());
        }
        
        // Determine the winning player
        if (status == GameStatus.GAME_WHITEWINS)
            System.out.println("White wins!");
        
        else if (status == GameStatus.GAME_BLACKWINS)
            System.out.println("Black wins!");
        
        else
            System.out.println("Draw!");

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
