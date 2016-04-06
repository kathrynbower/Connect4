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
			} else {
				System.out.println("Column full");
			}

			board.display();
			System.out.println("Where would you like to place your marker?");
			column = in.nextInt();
			column--;
			currentPlayer = changePlayer(currentPlayer);

			if (board.isWinner(board.getRowLocation(column), column, currentPlayer)) {
				board.updateCell(currentPlayer, board.getRowLocation(column), column);
				board.display();
				done = true;
				if (currentPlayer == CellState.P1) {
					System.out.println("Player 1 wins!");
				} else {
					System.out.println("Player 2 wins!");
				}
			}

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
