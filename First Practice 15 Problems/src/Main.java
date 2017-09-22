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
		
		//new LastOneStanding(writeFile);
		
		new ClockPaperScissors(writeFile);
		writeFile.println();
		
		new SammySays(writeFile);
		writeFile.println();
		
		new GameReviews(writeFile);
		writeFile.println();
		
		
		
		writeFile.close();
	}
}
