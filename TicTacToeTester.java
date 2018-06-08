//TicTacToeTester.java			Amy Liu
public class TicTacToeTester {

	public static void main(String[] args) {
		
		char[][] size3Test = new char[3][3];
		TicTacToe.drawBoard(size3Test);
		System.out.println("Testing 3 x 3 Board"
				+ "\nExpected Result: 3 x 3 board");
		char[][] size6Test = new char[6][6];
		TicTacToe.drawBoard(size6Test);
		System.out.println("Testing 6 x 6 Board"
				+ "\nExpected Result: 6 x 6 board");
		char[][] size9Test = new char[9][9];
		TicTacToe.drawBoard(size9Test);
		System.out.println("Testing 9 x 9 Board"
				+ "\nExpected Result: 9 x 9 board");
		
		System.out.println();
		
		Player xPlayer = new Player('x');
		Player oPlayer = new Player('o');
		char[][] placeTest = new char[3][3];
		TicTacToe.drawBoard(placeTest);
		System.out.println("Testing Placing Symbols"
				+ "\nExpected Result: Empty table");
		xPlayer.place(placeTest, 0, 1);
		TicTacToe.drawBoard(placeTest);
		System.out.println("Expected Result: New '" + xPlayer.getSymbol() + "' symbol at 01");
		oPlayer.place(placeTest, 1, 2);
		TicTacToe.drawBoard(placeTest);
		System.out.println("Expected Result: New '" + oPlayer.getSymbol() + "' symbol at 12");
		xPlayer.place(placeTest, 2, 0);
		TicTacToe.drawBoard(placeTest);
		System.out.println("Expected Result: New '" + xPlayer.getSymbol() + "' symbol at 20");
		spacing();
		System.out.println("Testing Occupied at 01"
				+ "\nExpected Result: true");
		System.out.println("Result: " + TicTacToe.isOccupied(placeTest, 0, 1));
		spacing();
		System.out.println("Testing Occupied at 21"
				+ "\nExpected Result: false");
		System.out.println("Result: " + TicTacToe.isOccupied(placeTest, 2, 1));
		
		System.out.println();
		
		char[][] tie3Test = {
				{'x', 'o', 'x'},
				{'o', 'o', 'x'},
				{'o', 'x', 'o'}};
		TicTacToe.drawBoard(tie3Test);
		System.out.println("Testing Win"
				+ "\nExpected Result: false");
		System.out.println("Result: " + TicTacToe.hasWinner(tie3Test));
		spacing();
		System.out.println("Testing Tie"
				+ "\nExpected Result: true");
		System.out.println("Result: " + TicTacToe.hasTie(tie3Test));
		spacing();
		System.out.println("Testing Occuppied at 02"
				+ "\nExpected Result: true");
		System.out.println("Result: " + TicTacToe.isOccupied(tie3Test, 0, 2));
		char[][] tie6Test = {
				{'x', 'o', 'x', 'x', 'o', 'x'},
				{'o', 'o', 'x', 'o', 'o', 'x'},
				{'o', 'x', 'o', 'o', 'x', 'o'},
				{'x', 'o', 'x', 'x', 'o', 'x'},
				{'o', 'o', 'x', 'o', 'o', 'x'},
				{'o', 'x', 'o', 'o', 'x', 'o'}};
		TicTacToe.drawBoard(tie6Test);
		System.out.println("Testing Win"
				+ "\nExpected Result: false");
		System.out.println("Result: " + TicTacToe.hasWinner(tie6Test));
		spacing();
		System.out.println("Testing Tie"
				+ "\nExpected Result: true");
		System.out.println("Result: " + TicTacToe.hasTie(tie6Test));
		spacing();
		System.out.println("Testing Occuppied at 02"
				+ "\nExpected Result: true");
		System.out.println("Result: " + TicTacToe.isOccupied(tie6Test, 0, 2));
		char[][] tie9Test = {
				{'x', 'o', 'x', 'x', 'o', 'x', 'x', 'o', 'x'},
				{'o', 'o', 'x', 'o', 'o', 'x', 'o', 'o', 'x'},
				{'o', 'x', 'o', 'o', 'x', 'o', 'o', 'x', 'o'},
				{'x', 'o', 'x', 'x', 'o', 'x', 'x', 'o', 'x'},
				{'o', 'o', 'x', 'o', 'o', 'x', 'o', 'o', 'x'},
				{'o', 'x', 'o', 'o', 'x', 'o', 'o', 'x', 'o'},
				{'x', 'o', 'x', 'x', 'o', 'x', 'x', 'o', 'x'},
				{'o', 'o', 'x', 'o', 'o', 'x', 'o', 'o', 'x'},
				{'o', 'x', 'o', 'o', 'x', 'o', 'o', 'x', 'o'}};
		TicTacToe.drawBoard(tie9Test);
		System.out.println("Testing Win"
				+ "\nExpected Result: false");
		System.out.println("Result: " + TicTacToe.hasWinner(tie9Test));
		spacing();
		System.out.println("Testing Tie"
				+ "\nExpected Result: true");
		System.out.println("Result: " + TicTacToe.hasTie(tie9Test));
		spacing();
		System.out.println("Testing Occuppied at 02"
				+ "\nExpected Result: true");
		System.out.println("Result: " + TicTacToe.isOccupied(tie9Test, 0, 2));
		
		System.out.println();
		
		char[][] vertical3WinTest= {
				{'x', 'o',  0 },
				{'o', 'o', 'x'}, 
				{'x', 'o',  0 }};
		TicTacToe.drawBoard(vertical3WinTest);
		System.out.println("Testing Vertical Win"
				+ "\nExpected Result: true");
		System.out.println("Result: " + TicTacToe.hasWinner(vertical3WinTest));
		spacing();
		System.out.println("Testing Tie"
				+ "\nExpected Result: false");
		System.out.println("Result: " + TicTacToe.hasTie(vertical3WinTest));
		char[][] vertical6WinTest= {
				{'x', 'o',  0 , 'x', 'o',  0 },
				{'o', 'o', 'x', 'o', 'o', 'x'}, 
				{'x', 'o',  0 , 'x', 'o',  0 },
				{'x', 'o',  0 , 'x', 'o',  0 },
				{'o', 'o', 'x', 'o', 'o', 'x'}, 
				{'x', 'o',  0 , 'x', 'o',  0 }};
		TicTacToe.drawBoard(vertical6WinTest);
		System.out.println("Testing Vertical Win"
				+ "\nExpected Result: true");
		System.out.println("Result: " + TicTacToe.hasWinner(vertical6WinTest));
		spacing();
		System.out.println("Testing Tie"
				+ "\nExpected Result: false");
		System.out.println("Result: " + TicTacToe.hasTie(vertical6WinTest));
		
		System.out.println();

		char[][] horizontal3WinTest = {
				{'o', 'x', 'o'},
				{ 0 , 'o',  0 }, 
				{'x', 'x', 'x'}};
		TicTacToe.drawBoard(horizontal3WinTest);
		System.out.println("Testing Horizontal Win"
				+ "\nExpected Result: true");
		System.out.println(TicTacToe.hasWinner(horizontal3WinTest));
		char[][] horizontal9WinTest = {
				{'o', 'x', 'o'},
				{ 0 , 'o',  0 }, 
				{'x', 'x', 'x'}};
		TicTacToe.drawBoard(horizontal9WinTest);
		System.out.println("Testing Horizontal Win"
				+ "\nExpected Result: true");
		System.out.println(TicTacToe.hasWinner(horizontal9WinTest));
		
		System.out.println();

		char[][] diagonal3WinTest = {
				{'o', 'x', 'o'},
				{'x', 'o',  0 }, 
				{'x', 'x', 'o'}};
		TicTacToe.drawBoard(diagonal3WinTest);
		System.out.println("Testing Diagonal Win"
				+ "\nExpected Result: true");
		System.out.println(TicTacToe.hasWinner(diagonal3WinTest));

		
		char[][] diagonal9WinTest = {
		{'o', 'x', 'o', 'o', 'x', 'o', 'o', 'x', 'o'},
		{'x', 'o',  0 , 'x', 'o',  0 , 'x', 'o',  0 }, 
		{'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'o'},
		{'o', 'x', 'o', 'o', 'x', 'o', 'o', 'x', 'o'},
		{'x', 'o',  0 , 'x', 'o',  0 , 'x', 'o',  0 }, 
		{'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'o'},
		{'o', 'x', 'o', 'o', 'x', 'o', 'o', 'x', 'o'},
		{'x', 'o',  0 , 'x', 'o',  0 , 'x', 'o',  0 }, 
		{'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'o'}};
		TicTacToe.drawBoard(diagonal9WinTest);
		System.out.println("Testing Diagonal Win"
				+ "\nExpected Result: true");
		System.out.println(TicTacToe.hasWinner(diagonal9WinTest));
		
		System.out.println();
		
		char[][] majorDiag3WinTest = {
				{'o', 'x', 'o'},
				{'x', 'o', 'x'}, 
				{ 0 , 'x', 'o'}};
		TicTacToe.drawBoard(majorDiag3WinTest);
		System.out.println("Testing Major Diagonal Win"
				+ "\nExpected Result: true");
		System.out.println(TicTacToe.hasWinner(majorDiag3WinTest));

		System.out.println();

		char[][] minorDiag3WinTest = {
				{'o', 'x', 'o'},
				{'x', 'o',  0 }, 
				{'o', 'x', 'x'}};
		TicTacToe.drawBoard(minorDiag3WinTest);
		System.out.println("Testing Minor Diagonal Win"
				+ "\nExpected Result: true");
		System.out.println(TicTacToe.hasWinner(minorDiag3WinTest));


	}

	/**
	 * Prints dashes for spacing
	 */
	public static void spacing() {
		System.out.println("----------");
	}
	
}
