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
		
		int repeat = readFile.nextInt();
		int lineNum = 0;
		System.out.println("repeat = " + repeat);
		
		String answer = "";
		
		for(int i = 0; i < repeat; i++) {
			
			lineNum = readFile.nextInt();
			
			readFile.nextLine();

			answer = playGame(lineNum);
			System.out.println(answer);
			
			jail.clear();
			notJail.clear();

		}
	}
	
	private String playGame(int lineNum) {
		Scanner readLine;
		String line = "";
		String person1 = "";
		String person2 = "";
		
		for(int i = 0; i < lineNum; i++) {
			
			line = readFile.nextLine();
			System.out.println("Line = " + line);
			
			readLine = new Scanner(line);
			
			System.out.println(jail + " " +  notJail);
			
			person1 = readLine.next();
			readLine.next();
			person2 = readLine.next();
			
			if(person1.equals(person2)) {
				return "invalid";
			}
			
			boolean alreadyThere = false;
			
			for(String s : jail) {
				if(s.equals(person1) || s.equals(person2)) {
					return "invalid";
				}
				if(person1.equals(s)) {
					alreadyThere = true;
				}
			}
			
			if(alreadyThere == true) {
				return "invalid";
			}
			else {
				jail.add(person2);
				for(int j = 0; j < notJail.size(); j++) {
					if(notJail.get(j).equals(person2)) {
						notJail.remove(j);
						break;
					}
				}
			}
			
			alreadyThere = false;
			
			for(String s : notJail) {
				if(person1.equals(s)) {
					alreadyThere = true;
				}
			}
			
			if(alreadyThere == false) {
				
				notJail.add(person1);
			}
			
			
		}
		return(notJail.get(0));
	}
	
	
}

