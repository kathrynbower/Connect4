package bower.kathryn;

public class Cell {
	private CellState state;
	
	Cell() {
		state = CellState.EMPTY;
	}
	
	public void setState(CellState state) {
		this.state = state;
	}
	
	public CellState getState() {
		return state;
	}
	
	
}
