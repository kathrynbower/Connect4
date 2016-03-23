package bower.kathryn;

public class Board {
	 private Cell[][] board;;

	 public Board () {
		 board = new Cell[7][7];
		 for (int i = 0; i < 7; i++) {
			 for (int j = 0; j <7; j++) {
				 board[i][j] = new Cell();
			 }
		 }
		 
	 }
	 
	 public void display () {
		 for (int i = 0; i < 7; i++) {
			 for (int j = 0; j <7; j++) {
				 if (board[i][j].getState() == CellState.EMPTY) {
					 System.out.print(" - ");
				 }
			 }
			System.out.println(); 
		 }
	 }
}
