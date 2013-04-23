package ChiniMess;

import java.util.ArrayList;

import Players.RandomPlayer;

public class Game {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Board b = new Board(); // normal standard Board
        GameStatus status = GameStatus.GAME_RUNNING;
        System.out.println(b);
        RandomPlayer randPlayer1 = new RandomPlayer();
        RandomPlayer randPlayer2 = new RandomPlayer();
        while(status == GameStatus.GAME_RUNNING){
            Move m;
            if (b.getPlayerOnTurn() == Board.WHITE)
                m = randPlayer1.chooseMove(b);
            else //if (b.getPlayerOnTurn() == Board.BLACK)
                m = randPlayer2.chooseMove(b);
            
            
            b.executeMove(m);
            status = b.gameOver();
            System.out.println(b);
            System.out.println("picked Move:" + m);
            System.out.println("Score: " + b.calculateScore());
        }
        
        // Determine the winning player
        if (status == GameStatus.GAME_WHITEWINS)
            System.out.println("White wins!");
        
        else if (status == GameStatus.GAME_BLACKWINS)
            System.out.println("Black wins!");
        
        else
            System.out.println("Draw!");

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
