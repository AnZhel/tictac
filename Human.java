package tictac;

import java.io.IOException;
import java.util.Scanner;

public class Human extends Player{

	public Human() {
		super();
	}
	
	@Override
	public void nextMove(Field field) throws AbortException {
		int cell=-1;
		do{
			try {
				cell = selectCell(field.size*field.size);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} while (cell==-1);
		if (cell==0){
			throw new AbortException();
		}
		if(field.getCellState(cell) != FieldState.BLANK){
			System.out.println("This cell is occupated!");
			this.nextMove(field);
			return;
		}
		field.setCellState(cell,symbol);
		System.out.println("Your turn:");
		field.showField();
	}
	
	int selectCell(int size) throws IOException{
		int result;
		Scanner scan= new Scanner(System.in);
		System.out.print("Enter cell (from 1 to "+size+") or 0 - escape: ");
		result = scan.nextInt();
		if (result>=0&&result<size+1){
			return result;
		}
		else throw new IOException("Invalid number");
	}
}
