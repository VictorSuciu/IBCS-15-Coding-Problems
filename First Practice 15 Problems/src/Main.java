import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		File fileOut = new File("Output File.txt");
		PrintWriter writeFile = new PrintWriter(fileOut);
		
		new Gorf(writeFile);
		writeFile.println();
		
		new WordFind(writeFile);
		writeFile.println();
		
		new Pokey(writeFile);
		writeFile.println();
		
		new LastOneStanding(writeFile);
		writeFile.println();
		
		new ClockPaperScissors(writeFile);
		writeFile.println();
		
		new SammySays(writeFile);
		writeFile.println();
		
		new GameReviews(writeFile);
		writeFile.println();
		
		new Nomopoly(writeFile);
		writeFile.println();
		
		new Bopscotch(writeFile);
		writeFile.println();
		
		new Chaseball(writeFile);
		writeFile.println();
		
		new Invaders(writeFile);
		writeFile.println();
		
		new CardSort(writeFile);
		writeFile.println();
		
		new Chest(writeFile);
		writeFile.println();
		
		writeFile.close();
	}
}
