package bower.kathryn;

import java.util.Scanner;

public class GameDriver {

	public static void main(String[] args) {
		Board board = new Board(7, 7);
		board.display();
		int column;

		Scanner in = new Scanner(System.in);
		System.out.println("Where would you like to place your marker?");
		column = in.nextInt();
		column--;
		
		boolean done = false;
		CellState currentPlayer = CellState.P1;
		while (!done) {
			if (!board.isColumnFull(column)) {
				board.updateCell(currentPlayer, board.getRowLocation(column), column);
			} // else condition
			board.display();
			System.out.println("Where would you like to place your marker?");
			column = in.nextInt();
			column--;
			
			boolean win = board.isWinner(board.getRowLocation(column), column, currentPlayer);
			System.out.println(win);
			currentPlayer = changePlayer(currentPlayer);

		}
	}

	private static CellState changePlayer(CellState player) {
		if (player == CellState.P1) {
			player = CellState.P2;
		} else {
			player = CellState.P1;
		}
		return player;
	}

}
