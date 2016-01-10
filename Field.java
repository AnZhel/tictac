package tictac;


public class Field {
	final int size = 3;
	Cell[][] cells;
	public Field() {
		cells = new Cell[size][size];
		for(int i=0; i<size; i++){
			for(int j=0;j<size;j++){
				cells[i][j]=new Cell();
			}
		}
	}
	
	public void setCellState(int number, FieldState state){
		cells[(number-1)/size][(number-1)%size].setState(state);
	}

	public void setCellState(int i, int j, FieldState state){
		cells[i][j].setState(state);
	}
	
	public FieldState getCellState(int number){
		return cells[(number-1)/size][(number-1)%size].getState();
	}

	public FieldState getCellState(int i, int j){
		return cells[i][j].getState();
	}
	
	public void showField() {
		int k=0;
		for (int i=0;  i<size; i++)
		{
			for(int j=0; j<size; j++){
				k++;
				System.out.print("|"+(getCellState(i, j)==FieldState.BLANK ? k : cells[i][j]));
			}
			System.out.println("|");
		}
	}
	
	public boolean isFull(){
		for(int i=1; i<=(size*size);i++){
			if(getCellState(i)==FieldState.BLANK) return false;
		}
		return true;
	} 

	public boolean isBlank(){
		for(int i=1; i<=(size*size);i++){
			if(getCellState(i)!=FieldState.BLANK) return false;
		}
		return true;
	} 
	
	
	public boolean hasWon(FieldState symbol){
		boolean resultH;
		boolean resultV;
		boolean resultD1 = true;
		boolean resultD2 = true;
		for (int i=0; i<size; i++){
			resultV = true; resultH = true;
			for (int j=0; j<size; j++){
				resultV = resultV&&getCellState(i,j)==symbol;
				resultH = resultH&&getCellState(j,i)==symbol;
				if(i==j){
					resultD1 = resultD1&&getCellState(i,j)==symbol;
				}
				if(i==(size-1)-j){
					resultD2 = resultD2&&getCellState(i,j)==symbol;
				}
			}
			if (resultV) return resultV;
			if (resultH) return resultH;
		}
		if (resultD1||resultD2) return true;
		else return false;
	}

}
