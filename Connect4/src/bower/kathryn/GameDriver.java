package bower.kathryn;

import java.util.Scanner;

public class GameDriver {

	public static void main(String[] args) {
		System.out.println("Welcome to Connect 4. This is a 2 player game.");
		System.out.println("To play, enter the column you wish to drop your marker in.");
		System.out.println("Player 1 is X and player 2 is O.");
		System.out.println("");

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

			// while input is not valid
			while ((column > 7 || column < 1) && (board.isColumnFull(column))) {
				if ((column > 7 || column < 1)) {
					System.out.println("Invalid response.");
					System.out.println("Where would you like to place your marker?");
					column = in.nextInt();
					column--;
				} else {
					System.out.println("Column is full.");
					System.out.println("Where would you like to place your marker?");
					column = in.nextInt();
					column--;
				}
			}
			board.updateCell(currentPlayer, board.getRowLocation(column), column);

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
			} else if (board.isTied()) {
				done = true;
				System.out.println("Tie.");
			}
		}

	}

	/**
	 * Changes the player
	 * 
	 * @param player
	 *            - current player in the game
	 * @returns the next player
	 */
	private static CellState changePlayer(CellState player) {
		if (player == CellState.P1) {
			player = CellState.P2;
		} else {
			player = CellState.P1;
		}
		return player;
	}

}
