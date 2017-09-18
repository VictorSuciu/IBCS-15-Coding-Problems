import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class LastOneStanding {
	
	private File file = new File("Data Resources\\lastonestanding.dat");
	private Scanner readFile;
	
	private ArrayList<String> jail = new ArrayList();
	private ArrayList<String> notJail = new ArrayList();
	
	public LastOneStanding(PrintWriter pr) throws FileNotFoundException {
		readFile = new Scanner(file);
		readFile.nextLine();
	}
	
	private String playGame() {
		String line = "";
		while(readFile.next().length() > 1) {
			line = readFile.nextLine();
		}
		
	}
}

