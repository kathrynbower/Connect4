package bower.kathryn;

public class Board {
	private Cell[][] board;
	private int numRows;
	private int numCols;
	
	//Constructor
	public Board(int rows, int cols) {
		numRows = rows;
		numCols = cols;

		board = new Cell[rows][cols];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				board[i][j] = new Cell();
			}
		}

	}

	public void display() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (board[i][j].getState() == CellState.EMPTY) {
					System.out.print(" - ");
				} else if (board[i][j].getState() == CellState.P1) {
					System.out.print(" X ");
				} else if (board[i][j].getState() == CellState.P2) {
					System.out.print(" O ");
				}
			}
			System.out.println();
		}
	}

	public boolean isColumnFull(int column) {
		return board[0][column].getState() != CellState.EMPTY;
	}

	public int getRowLocation(int column) {
		boolean found = false;
		int rowPos = numRows - 1;
		while (!found) {
			if (board[rowPos][column].getState() == CellState.EMPTY) {
				found = true;
			} else {
				rowPos--;
			}
		}
		return rowPos;
	}

	public void updateCell(CellState state, int row, int column) {
		board[row][column].setState(state);
	}

	public boolean isWinner(int row, int column, CellState state) {
		// isVertical
		// isHorizontal
		// isDiagonal
	}

	public boolean isVerticalWinner(int row, int column, CellState state) {
		int length = 1;
		boolean end = false;

		while (!end) {
			if (row > 0) {
				if (board[row - 1][column].getState() == state) {
					length++;
					row--;
				} else {
					end = true;
				}
			}
		}

		if (length == 4) {
			return true;
		} else {
			return false;
		}
	}

}
