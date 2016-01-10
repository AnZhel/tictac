package tictac;

public enum FieldState {
	BLANK, CROSS, NOUGHT;

	static public FieldState oppositeState(FieldState state){
		switch (state){
		case CROSS: return NOUGHT;
		case NOUGHT: return CROSS;
		default: return BLANK;
		}
	}
}
