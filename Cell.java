package tictac;

public class Cell {
		FieldState state;
		public Cell() {
			this.state = FieldState.BLANK;
		}
		public void setState(FieldState state) {
			this.state = state;
		}
		public FieldState getState() {
			return state;
		}
		
		public String toString() {
			switch (this.state){
			case BLANK: return " ";
			case CROSS: return "X";
			case NOUGHT: return "O";
			default: return " ";
			}
		};
		
}
