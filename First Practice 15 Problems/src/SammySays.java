import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class SammySays {
	
	File file = new File("Data Resources/sammysays.dat");
	Scanner readFile;
	
	public SammySays(PrintWriter pr) throws FileNotFoundException {
		readFile = new Scanner(file);
		pr.println("==========Sammy-Says==========");
		
		int rep = readFile.nextInt();
		readFile.nextLine();
		
		String answer = "";
		
		for(int i = 0; i < rep; i++) {
			answer = action(readFile.nextLine());
			if(answer.length() > 0) {
				pr.println(answer);
			}
		}
		
	}
	
	private String action(String command) {
		Scanner readLine = new Scanner(command);
		String sammy = readLine.next();
		String says = readLine.next();
		
		String ret = "";
		
		if(sammy.equals("Sammy") && says.equals("says")) {
			
			while(readLine.hasNext()) {
				ret = ret + readLine.next() + " ";
			}
		}
		
		return ret;
	}
}
