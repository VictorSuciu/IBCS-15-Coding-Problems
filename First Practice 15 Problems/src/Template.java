import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Template {
	
	File file = new File("Data Resources\\gorf.dat");
	Scanner readFile;
	
	public Template(PrintWriter pr) throws FileNotFoundException {
		readFile = new Scanner(file);
	}
}
