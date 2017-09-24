import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class LastOneStanding {
	
	private File file = new File("Data Resources/lastonestanding.dat");
	private Scanner readFile;
	
	private ArrayList<ArrayList<String>> jail = new ArrayList();
	private ArrayList<String> notJail = new ArrayList();
	
	public LastOneStanding(PrintWriter pr) throws FileNotFoundException {
		readFile = new Scanner(file);
		pr.println("==========Last-One-Standing==========");
		
		int repeat = readFile.nextInt();
		int lineNum = 0;
		
		String answer = "";
		
		for(int i = 0; i < repeat; i++) {
			
			lineNum = readFile.nextInt();
			readFile.nextLine();

			answer = playGame(lineNum);
			if(answer.equals("invalid")) {
				pr.println("INVALID GAME");
			}
			else if(answer.equals("unfinished")) {
				pr.println("VALID GAME\nUnfinished");
			}
			else  {
				pr.println("VALID GAME\n" + answer);
			}
			
			pr.println();
			
			if(answer.equals("invalid")) {
				String temp = readFile.nextLine();
				while(!readFile.hasNextInt()) {
					temp = readFile.nextLine();
					
				}
			}

			jail.clear();
			notJail.clear();

		}
	}
	
	private String playGame(int lineNum) {
		String line = "";
		String person1 = "";
		String person2 = "";
		String[] tokens;
		ArrayList<String> jailInput;
		
		for(int i = 0; i < lineNum; i++) {
			line = readFile.nextLine();
			tokens = line.split(" ");
			person1 = tokens[0];
			person2 = tokens[2];
			jailInput = new ArrayList();
			jailInput.add(person1);
			jailInput.add(person2);
			
			if(person1.equals(person2)) {
				return "invalid";
			}
			
			if(isInNotJail(person1) == false) {
				notJail.add(person1);
			}
			if(isInNotJail(person2)) {
				for(int j = 0; j < notJail.size(); j++) {
					if(notJail.get(j).equals(person2)) {
						notJail.remove(j);
						break;
					}
				}
			}
			if(isInJail(person1)) {
				return "invalid";
			}
			if(isInJail(person2) == false) {
				jail.add(jailInput);
			}
			else {
				return "invalid";
			}
			taggerTagged(person2);
			
			
		}
		if(notJail.size() != 1) {
			return "unfinished";
		}
		else {
			return notJail.get(0);
		}
	}
	
	private boolean isInNotJail(String name) {

		for(String s : notJail) {
			if(s.equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isInJail(String name) {
		
		for(ArrayList<String> s : jail) {
			if(s.get(1).equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	private void taggerTagged(String name) {
		
		for(int i = jail.size() - 1; i >= 0 ; i--) {
			if(jail.get(i).get(0).equals(name)) {
				notJail.add(jail.get(i).get(1));
				jail.remove(i);
				
			}
		}
	}
}

