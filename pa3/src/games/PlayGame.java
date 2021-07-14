package games;
import java.util.Scanner;

public class PlayGame {
	public PlayGame() {
		g = new TicTacToe4();
	}

	public void doComputerMove() {
		boolean legal;
		printBoard();
		Best compMove = g.chooseMove(Game.COMPUTER, 0);  // depth 0 call
		System.out.println("Computer plays ROW = " + compMove.row + " COL = " + compMove.column);
		g.makeMove(Game.COMPUTER, compMove.row, compMove.column);
		
	}

	public void doHumanMove() {
		boolean legal;
		printBoard();
		do {
			System.out.println("row: ");
			int row = scan.nextInt();
			System.out.println("column: ");
			int col = scan.nextInt();
			legal = g.makeMove(Game.HUMAN, row, col);
			if (!legal)
				System.out.println("Illegal move, try again");
		} while (!legal);
	}
	
	// return true if game is continuing, false if done
	boolean checkAndReportStatus() {
		if (g.isWin(Game.COMPUTER)) {
			System.out.println("Computer says: I WIN!!");
			return false; // game is done
		}
		if (g.isWin(Game.HUMAN)) {
			System.out.println("Computer says: You WIN!!");
			return false; // game is done
		}
		if (g.isADraw()) {
			System.out.println(" Game is a DRAW");
			return false;
		}
		
		System.out.println("game continuing");
		return true;
	}

	// do one round of playing the game, return true at end of game
	public boolean getAndMakeMoves() {
		// let computer go first...
		doComputerMove();
		System.out.println("back from doComputerMove");
		// System.out.println("count = " + t.getCount());
		if (!checkAndReportStatus())
			return false; // game over
		doHumanMove();
		if (!checkAndReportStatus())
			return false; // game over
		return true;
	}

	void printBoard() {
		String game = g.toString();
		System.out.println(game);
		
	}

	void playOneGame() {
		boolean continueGame = true;
		g.init();
		while (continueGame) {
			continueGame = getAndMakeMoves();
		}
	}

	public static void main(String[] args) {
		PlayGame ui = new PlayGame();
		ui.playOneGame();
	}

	private Game g; // g for game
	private Scanner scan = new Scanner(System.in);
	

}
