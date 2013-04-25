package Players;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import ChiniMess.Board;
import ChiniMess.Move;

public class HumanPlayer extends Player{

	private ArrayList<Move> move_list;
	private BufferedReader console;
	private String move_string = "Move:\t";
	private Integer numbers = 0;
	private String number_string = "Number:\t";
	
	@Override
	public Move chooseMove(Board b) {

		numbers = input(b);
		
		while((numbers >= 0 && numbers < move_list.size()) == false){
			System.out.println("Wrong Input!!! Try again");
			numbers = input(b);
		}
		
		return move_list.get(numbers);
	
	}
	
	private Integer input(Board b){
		
		move_list = b.genMoves();
		console = new BufferedReader(new InputStreamReader(System.in));
		numbers = 0;
		move_string   = "";
		number_string = "";
		
		for(Move m: move_list){
			number_string += numbers+"\t";
			move_string += m.toString()+"\t";
			numbers++;
		}
		
		System.out.print("Choose a move\n"+number_string+"\n"+move_string+"\nyour move number: ");
		
		try {
			return Integer.parseInt(console.readLine());
		} catch (Exception e) {
			return -1;
		}
	}
}
