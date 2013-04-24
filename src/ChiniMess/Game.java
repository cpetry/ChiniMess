package ChiniMess;

import java.io.IOException;
import java.util.ArrayList;

import Players.*;

public class Game {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
    	//playLocalGame();
    	playNetworkGame();
    }  
    /**
     * @brief play ChiniMess local game
     */
    public static void playLocalGame() {
    
	    	Board b = new Board(); // normal standard Board
	        GameStatus status = GameStatus.GAME_RUNNING;
	        System.out.println(b);
	        
	        Player White_Player   = new NegamaxABPlayer(500);
	        Player Black_Player   = new NegamaxPlayer(2);
	        
	        while(status == GameStatus.GAME_RUNNING){
	            Move m;
	            if (b.getPlayerOnTurn() == Board.WHITE)
	                m = White_Player.chooseMove(b);
	            else //if (b.getPlayerOnTurn() == Board.BLACK)
	                m = Black_Player.chooseMove(b);
	            
	            
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
    
    /**
     * @brief play ChiniMess network game
     */
    public static void playNetworkGame() {

    	try {
	    		Client networkClient = new Client("imcs.svcs.cs.pdx.edu","3589","ChiniMess","bbp");
	    		networkClient.offer('W');

		    	Board b = new Board('W'); // normal standard Board
		        GameStatus status = GameStatus.GAME_RUNNING;
		        System.out.println(b);
		        
		        Player localPlayer   = new NegamaxPlayer(3);
		        
		        while(status == GameStatus.GAME_RUNNING){
		            Move m;
		            if (b.getPlayerOnTurn() == Board.WHITE)
		                m = localPlayer.chooseMove(b);
		            else //if (b.getPlayerOnTurn() == Board.BLACK)
		                m = new Move(networkClient.getMove());

		            b.executeMove(m);
		            
		            networkClient.sendMove(m.toString());
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
		        
		        networkClient.close();
    		
    	}
        catch (IOException e_ref) {
    		System.out.println("Connection closed!");
        }
    	
    }
    
    
}
