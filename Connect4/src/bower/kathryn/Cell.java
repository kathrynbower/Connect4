package bower.kathryn;

public class Cell {
	private CellState state;
	
	Cell() {
		state = CellState.EMPTY;
	}
	
	public void setP1() {
		state = CellState.P1;
	}
	
	public void setP2() {
		state = CellState.P2;
	}
	
	public CellState getState() {
		return state;
	}
	
	
}
