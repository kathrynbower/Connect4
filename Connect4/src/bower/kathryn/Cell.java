package bower.kathryn;

/**
 * Class sets state for the game grid - Player 1, player 2 or empty
 */
public class Cell {
	private CellState state;
	
	/**
	 * Initializes CellState variable state
	 */
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
