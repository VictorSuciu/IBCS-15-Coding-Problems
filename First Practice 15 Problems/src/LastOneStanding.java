import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class LastOneStanding {
	
	File file = new File("Data Resources\\lastonestanding.dat");
	Scanner readFile;
	
	public LastOneStanding(PrintWriter pr) throws FileNotFoundException {
		readFile = new Scanner(file);
	}
}

