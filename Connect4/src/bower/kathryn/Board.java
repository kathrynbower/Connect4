package bower.kathryn;

public class Board {
	private Cell[][] board;
	private int numRows;
	private int numCols;

	public Board(int rows, int cols) {
		numRows = rows;
		setNumCols(cols);

		board = new Cell[rows][cols];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				board[i][j] = new Cell();
			}
		}

	}

	public int getNumCols() {
		return numCols;
	}

	public void setNumCols(int numCols) {
		this.numCols = numCols;
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
		if (isVerticalWinner(row, column, state)) {
			return true;
		} else if (isHorizontalWinner(row, column, state)) {
			return true;
		} else if (isDiagonalWinner(row, column, state)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isVerticalWinner(int row, int column, CellState state) {
		int length = 1;
		boolean end = false;

		while (!end) {
			if (row > 0 && row <= 5) {
				if (board[row + 1][column].getState() == state) {
					length++;
					row++;
				} else {
					end = true;
				}
			} else {
				end = true;
			}
		}

		if (length == 4) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isHorizontalWinner(int row, int column, CellState state) {
		int length = 1;
		boolean end = false;
		int i = 1;
		int j = 1;

		while (!end) {
			if ((j >= 0) && (i <= 5)) {
				// looking to the right
				if ((column + i) < 6 && (board[row][column + i].getState() == state)) {
					length++;
					i++;
					// looking to the left
				} else if ((column - j) >= 0 && (board[row][column - j].getState() == state)) {
					length++;
					j++;
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

	public boolean isDiagonalWinner(int row, int column, CellState state) {
		int length = 1;
		boolean end = false;
		int i = 1;
		int j = 1;

		while (!end) {
			if ((j >= 0) && (i <= 5)) {
				if ((column + i) < 6 && (board[row - 1][column + i].getState() == state)) {
					length++;
					i++;
					row--;
				} else if ((column - j) >= 0 && (board[row - 1][column - j].getState() == state)) {
					length++;
					j++;
					row--;
				} else {
					end = true;
				}
			}

		}
		System.out.println(length);
		if (length == 4) {
			return true;
		} else {
			return false;
		}

	}
}