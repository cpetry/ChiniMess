package ChiniMess;

import java.io.IOException;
import java.util.ArrayList;

import Players.*;

public class Game {

    /**
     * @param args
     */
    public static void main(String[] args) {
    	//System.out.println(convertBlackMove(new Move("b6-c4")));
    	//playLocalGame();
    	//playNetworkGameAsServer();
    	playNetworkGameAsClient("6607");
    }  
    /**
     * @brief play ChiniMess local game
     */
    public static void playLocalGame() {
    
	    	Board b = new Board(); // normal standard Board
	        GameStatus status = GameStatus.GAME_RUNNING;
	        System.out.println(b);
	        
	        Player White_Player   = new HumanPlayer();
	        Player Black_Player   = new HumanPlayer();
	        
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
    public static void playNetworkGameAsServer() {

    	try {
	    		Client networkClient = new Client("imcs.svcs.cs.pdx.edu","3589","ChiniMess","bbp");
	    		networkClient.offer('B');

		    	Board b = new Board('W'); // normal standard Board
		        GameStatus status = GameStatus.GAME_RUNNING;

		        Player localPlayer   = new NegamaxPlayer(5);
		        
		        while(status == GameStatus.GAME_RUNNING){
		            Move m;
		            
		            if (b.getPlayerOnTurn() == Board.WHITE) {
		            	m = new Move(networkClient.getMove());	           		            	
		            }
		            else {  //if (b.getPlayerOnTurn() == Board.BLACK) 
		            	m = localPlayer.chooseMove(b);   
		            	networkClient.sendMove(m.toString());	
		            }		            
		            b.executeMove(m);
		            status = b.gameOver();
		            /*System.out.println(b);
		            System.out.println("picked Move:" + m);
		            System.out.println("Score: " + b.calculateScore()); */
		            //b.setTurn(!b.getPlayerOnTurn());
		            
		            System.out.println("local Board: \n");
		            System.out.println(b);
		            System.out.println("----------------------");
		            System.out.println("network Board: \n");
		            
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
    static void playNetworkGameAsClient(String id) {
	    try {
			Client networkClient = new Client("imcs.svcs.cs.pdx.edu","3589","ChiniMess","bbp");
			char turn  = networkClient.accept(id,'?');
			boolean localTurn = Board.WHITE;
			Move m = null;
	    	Board b = new Board(); // normal standard Board
	        GameStatus status = GameStatus.GAME_RUNNING;
	       
	        
	        if (turn == 'W') {
	        	localTurn = Board.WHITE;
	        }
	        else if (turn == 'B') {
	        	localTurn= Board.BLACK;
	        }
	        Player localPlayer   = new RandomPlayer();
	        
	        while(status == GameStatus.GAME_RUNNING){        
	            if (localTurn == b.getPlayerOnTurn()) {
	            	m = localPlayer.chooseMove(b);
	            	networkClient.sendMove(m.toString());	      		            	
	            }
	            else {  //if (b.getPlayerOnTurn() == Board.BLACK) 
	            	m = new Move(networkClient.getMove());	
	            }		            
	            b.executeMove(m);
	            status = b.gameOver();
	            /*System.out.println(b);
	            System.out.println("picked Move:" + m);
	            System.out.println("Score: " + b.calculateScore());
	            */
	            
	            System.out.println("local Board: \n");
	            System.out.println(b);
	            System.out.println("----------------------");
	            System.out.println("network Board: \n");
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
