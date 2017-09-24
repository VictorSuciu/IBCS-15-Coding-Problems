import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class ClockPaperScissors {
	
	File file = new File("Data Resources/clockpaperscissors.dat");
	Scanner readFile;
	
	public ClockPaperScissors(PrintWriter pr) throws FileNotFoundException {
		readFile = new Scanner(file);
		
		int lineNum = readFile.nextInt();
		pr.println("==========Clock-Paper-Scissors==========");
		
		readFile.nextLine();
		
		for(int i = 0; i < lineNum; i++) {
			pr.println("Player " + whoWins());
		}
	}
	
	
	private int whoWins() {
		
		String line = readFile.nextLine();
		Scanner readLine = new Scanner(line);
		
		int r1 = readLine.nextInt();
		int r2 = readLine.nextInt();
		int r3 = readLine.nextInt();
		
		if(r1 + r2 + r3 < 2) {
			return 2;
		}
		else {
			return 1;
		}
		
	}
}
