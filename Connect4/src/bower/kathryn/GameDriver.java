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

		CellState currentPlayer = CellState.P1;
		while (true) {
			if (!board.isColumnFull(column)) {
				board.updateCell(currentPlayer, board.getRowLocation(column), column);
			}
			board.display();
			System.out.println("Where would you like to place your marker?");
			column = in.nextInt();
			column--;
			currentPlayer = changePlayer(currentPlayer);
			// board.isWinner()

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
