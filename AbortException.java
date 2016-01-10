package tictac;

public class AbortException extends Exception{
	public AbortException() {
		super("Game is aborted!");
	}
}
