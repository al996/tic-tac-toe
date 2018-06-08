import java.util.Scanner;

//TicTacToe.java			Amy Liu
public class TicTacToe {

	private static final int X_PLAYER = 0;
	private static final int O_PLAYER = 1;

	private static int gridSize;
	private static char[][] board;

	private static Player[] players;

	private static int turn;
	private static int loser;

	private static int playerChoice;
	private static int ones, tens;

	private static boolean win;
	private static int xScore = 0;
	private static int oScore = 0;
	private static int tieCounter = 0;

	private static char replay;

	private static Scanner input;

	public static void main(String[] args) {

		players = new Player[2];
		players[X_PLAYER] = new Player('x');
		players[O_PLAYER] = new Player('o');

		turn = (int)(Math.random() * 2);
		loser = turn;

		xScore = 0;
		oScore = 0;
		tieCounter = 0;

		input = new Scanner(System.in);

		do {

			//Set win to false (no winner yet at beginning of game)
			win = false;

			//Enter grid size
			createBoard();

			spacing();

			//Instructions for placing symbols
			printInstructions();

			//Play game until a winner is decided
			play();

			//Start the next game with the last loser
			turn = loser;

			spacing();

			//Draw final board
			drawBoard(board);

			spacing();

			//Print Score
			printScore();

			spacing();

			//Prompt to play again
			promptReplay();

			spacing();

		} while(replay != 'n');

		System.out.println("Thank you for playing!  Goodbye...");


		input.close();

	}

	public static void spacing()
	{
		System.out.println();
	}

	public static void printInstructions()
	{
		System.out.println("Instructions to Place a Symbol:\n"
				+ "Enter an integer whose tens place represents the row \n"
				+ "and whose ones place represents the column of the \n"
				+ "space you would like to place your symbol.");
	}

	public static void printScore()
	{
		System.out.println("Score: (" + players[0] + " - " + xScore
				+ ")\t(" + players[1] + " - " + oScore
				+ ")\t(Tie - " + tieCounter + ")");
	}

	public static void promptReplay()
	{
		do {
			System.out.print("Enter 'y' to play again or 'n' to quit: ");
			replay = input.next().toLowerCase().charAt(0);
			if(replay != 'y' && replay != 'n')
				System.out.print("Invalid entry.  ");
		} while(replay != 'y' && replay != 'n');
	}

	public static void createBoard()
	{
		do {
			System.out.print("Enter the size (3 - 9) of the board: ");
			gridSize = input.nextInt();
			if(gridSize < 3 || gridSize > 9)
				System.out.print("Invalid entry.  ");
		} while(gridSize < 3 || gridSize > 9);

		board = new char[gridSize][gridSize];
	}

	public static void drawBoard(char[][] board)
	{
		for(int row = 0; row < board.length; row++)
		{
			System.out.print(" ");
			for(int col = 0; col < board[row].length; col++)
			{
				System.out.print("------- ");
			}
			System.out.println();
			System.out.print("|   ");
			for(int col = 0; col < board[row].length; col++)
			{
				System.out.print(board[row][col] + "\t|   ");
			}
			System.out.println();
		}

		System.out.print(" ");
		for(int col = 0; col < board[0].length; col++)
		{
			System.out.print("------- ");
		}

		System.out.println();
	}

	public static void play()
	{
		do {
			System.out.println();

			drawBoard(board);

			System.out.println();

			//Keep track of turns
			System.out.println(players[turn] + "'s Turn");

			placeSymbol();

			winTieOrContinue();

		} while(!win);
	}
	
	public static void winTieOrContinue()
	{
		//winner and stop playing
		if(hasWinner(board))
		{
			win = true;
			if(turn == X_PLAYER)
			{
				xScore++;
				loser = O_PLAYER;
			}
			else if(turn == O_PLAYER)
			{
				oScore++;
				loser = X_PLAYER;
			}
		}
		//tie and stop playing
		else if(hasTie(board))
		{
			win = true;
			tieCounter++;
		}
		//switch turns and continue playing
		else
		{
			if(turn == X_PLAYER)
				turn = O_PLAYER;
			else if(turn == O_PLAYER)
				turn = X_PLAYER;
		}
	}
	
	public static void placeSymbol()
	{
		do {
			do {
				System.out.print("Enter a space to place the symbol: ");
				playerChoice = input.nextInt();

				ones = playerChoice % 10;
				tens = playerChoice / 10;

				if(isValidPlacement(gridSize, ones, tens))
				{
					System.out.print("Inputed space is not on the board.  ");
				}

			} while(isValidPlacement(gridSize, ones, tens));

			if(isOccupied(board, tens, ones))
			{
				System.out.print("Inputed space is already occupied.  ");
			}

		} while(isOccupied(board, tens, ones));

		//Place symbol on board
		players[turn].place(board, tens, ones);
	}

	public static boolean isValidPlacement(int gridSize, int ones, int tens)
	{
		return ones > gridSize - 1 || tens > gridSize - 1;
	}

	/**
	 * Checks the board at a particular row column coordinate to see
	 * whether it is occupied
	 * @param board the board
	 * @param row the row
	 * @param col the column
	 * @return Returns true if the board is occupied at the row column coordinate
	 */
	public static boolean isOccupied(char[][] board, int row, int col)
	{		
		return board[row][col] != 0;
	}

	/**
	 * Checks the board for a tie
	 * @param board
	 * @return Returns true if the board is full and there is no winner
	 */
	public static boolean hasTie(char[][] board)
	{
		for(int row = 0; row < board.length; row++)
		{
			for(int col = 0; col < board[row].length; col++)
			{
				if(!isOccupied(board, row, col))
					return false;
			}
		}

		if(hasWinner(board))
		{
			return false;
		}

		return true;
	}


	/**
	 * Checks the board for a winner
	 * @param board the board
	 * @return Returns true if there is a vertical win, a horizontal win, or a diagonal win
	 */
	public static boolean hasWinner(char[][] board)
	{
		return isVerticalWin(board) || isHorizontalWin(board) || isDiagonalWin(board);
	}

	/**
	 * Checks the board for a vertical win
	 * @param board the board
	 * @return Returns true if all the elements are not null and the same in any particular column
	 */
	private static boolean isVerticalWin(char[][] board)
	{
		for(int col = 0; col < board[0].length; col++)
		{
			boolean colSame = true; 
			if(!isOccupied(board, 0, col))
				colSame = false;
			for(int row = 0; row < board.length - 1; row++)
			{
				if(!colSame || !isOccupied(board, row + 1, col) || board[row][col] != board[row + 1][col])
					colSame = false;
			}
			if(colSame)
				return true;
		}

		return false;
	}

	/**
	 * Checks the board for a horizontal win
	 * @param board the board
	 * @return Returns true if all the elements are not null and the same in any particular row
	 */
	private static boolean isHorizontalWin(char[][] board)
	{
		for(int row = 0; row < board.length; row++)
		{
			boolean rowSame = true;
			if(!isOccupied(board, row, 0))
				rowSame = false;
			for(int col = 0; col < board[row].length - 1; col++)
			{
				if(!rowSame || !isOccupied(board, row, col + 1) || board[row][col] != board[row][col + 1])
					rowSame = false;
			}
			if(rowSame)
				return true;
		}

		return false;
	}

	/**
	 * Checks the board for a diagonal win
	 * @param board the board
	 * @return Returns true if there is a major diagonal win or a minor diagonal win
	 */
	private static boolean isDiagonalWin(char[][] board)
	{
		return isMajorDiagWin(board) || isMinorDiagWin(board);
	}

	/**
	 * Checks the board for a major diagonal win
	 * @param board the board
	 * @return Returns true if all the elements are not null and 
	 * the same in 
	 */
	private static boolean isMajorDiagWin(char[][]board)
	{ 
		if(!isOccupied(board, 0, 0))
			return false;
		for(int i = 0; i < board.length - 1; i++)
		{
			if(!isOccupied(board, i + 1, i + 1) ||
					board[i][i] != board[i + 1][i + 1])
			{
				return false;
			}
		}

		return true;
	}

	/**
	 * Checks the board for a minor diagonal win
	 * @param board
	 * @return
	 */
	private static boolean isMinorDiagWin(char[][]board)
	{
		if(!isOccupied(board, 0, board.length - 1))
			return false;
		for(int i = 0; i < board.length - 1; i++)
		{
			if(!isOccupied(board, i + 1, board.length - i - 2) ||
					board[i][board.length - i - 1] != board[i + 1][board.length - i - 2])
			{
				return false;
			}
		}

		return true;
	}

}
