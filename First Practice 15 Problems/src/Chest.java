import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Chest {
	
	File file = new File("Data Resources/chest.dat");
	Scanner readFile;
	String letterOrder = "ABCDEFGH";
	
	char letter;
	int number;
	int rep;
	String line;
	
	char[][] board = new char[8][8];
	int[] point = new int[2];
	
	public Chest(PrintWriter pr) throws FileNotFoundException {
		readFile = new Scanner(file);
		pr.println("==========Chest==========");
		
		rep = readFile.nextInt();
		readFile.nextLine();
		
		for(int i = 0; i < rep; i++) {
			resetBoard();
			
			line = readFile.nextLine();
			letter = line.charAt(0);
			number = Character.getNumericValue(line.charAt(1));		
			point = getKnightCoordinate();
			
			board[point[1]][point[0]] = 'K';
			
			tryAllMoves();
			
			printBoard(pr);
		}
	}
	
	private int[] getKnightCoordinate() {
		int[] point = new int[2];
		int index = 0;
		
		while(letter != letterOrder.charAt(index)) {
			index++;
		}
		point[0] = index;
		point[1] = (0 - number) + 8;
		
		return point;
	}
	
	private void printBoard(PrintWriter pr) {
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++) {
				pr.print(board[row][col] + " ");
			}
			pr.println();
		}
		pr.println();
	}
	
	private void resetBoard() {
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++) {
				board[row][col] = '-';
				
			}
		}
	}
	
	private void tryMove(int horizontal, int vertical) {
		int row = point[1];
		int col = point[0];
		
		col += horizontal;
		row += vertical;
		if(row >= 0 && row <= 7 && col >= 0 && col <= 7) {
			board[row][col] = '?';
		}
	}
	
	private void tryAllMoves() {
		tryMove(-2, 1);
		tryMove(2, 1);
		tryMove(-2, -1);
		tryMove(2, -1);
		tryMove(-1, 2);
		tryMove(1, 2);
		tryMove(1, -2);
		tryMove(-1, -2);
	}
}
