import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		File fileOut = new File("Output File.txt");
		PrintWriter writeFile = new PrintWriter(fileOut);
		
		new Gorf(writeFile);
		
		
		writeFile.close();
	}
}
