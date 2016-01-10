package tictac;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Field field = new Field();
		field.showField();
		Player currentPlayer;
		Player human = new Human();
		Player comp  = new Computer();
		
		String result;
		int turn = 0;
		do {
			System.out.print("Choose your turn (1 - first; 2 - second; 0 - escape): ");
			Scanner scan = new Scanner(System.in);
			turn = scan.nextInt();
		} while (!(turn==0||turn==1||turn==2));
		if (turn==0) return;
		else if (turn==1){
			human.setSymbol(FieldState.CROSS);
			comp.setSymbol(FieldState.NOUGHT);
		}
		else {
			human.setSymbol(FieldState.NOUGHT);
			comp.setSymbol(FieldState.CROSS);
		}
		result="It's draw!";
		do {
			if(turn==1){
				currentPlayer = human;
				turn=2;
			}
			else{
				currentPlayer = comp;
				turn=1;
			}
			try {
				currentPlayer.nextMove(field);
			} catch (AbortException e) {
				result = e.getMessage();
				break;
			}
			if (field.hasWon(currentPlayer.symbol)){
				result = (turn==2) ? "You won!" : "Computer won!";
				break;
			}
		} while(!field.isFull());
		System.out.println(result);
	}

}
