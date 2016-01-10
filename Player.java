package tictac;

public abstract class Player {
	FieldState symbol;
	public Player() {
	}
	public void setSymbol(FieldState symbol){
		this.symbol = symbol;
	}
	abstract  public void nextMove(Field field) throws  AbortException;
}
