//Player.java			Amy Liu
public class Player {

	private char symbol;
	
	/**
	 * Creates a player with 'symbol' symbol
	 * @param symbol
	 */
	public Player(char symbol) {
		this.symbol = symbol;
	}
	
	/**
	 * Placed a symbol on the board at the row column coordinate
	 * @param board the board
	 * @param row the row
	 * @param col the column
	 */
	public void place(char[][] board, int row, int col)
	{
		board[row][col] = symbol;
	}
	
	/**
	 * Returns the symbol
	 * @return the symbol
	 */
	public char getSymbol() {
		return symbol;
	}
	
	/**
	 * Returns the symbol followed by 'Player'
	 */
	public String toString() {
		return symbol + " Player";
	}

}
