import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Bopscotch {
	
	File file = new File("Data Resources/bopscotch.dat");
	Scanner readFile;
	ArrayList<ArrayList<Integer>> pattern = new ArrayList();
	int rep;
	int startNum;
	
	public Bopscotch(PrintWriter pr) throws FileNotFoundException {
		readFile = new Scanner(file);
		pr.println("==========Bopscotch==========");
		
		rep = readFile.nextInt();
		
		for(int i = 0; i < rep; i++) {
			
			startNum = readFile.nextInt();
			generatePattern();
			//System.out.println(pattern);
			printPattern(pr);
			pattern.clear();
		}
	}
	
	private void generatePattern() {
		ArrayList<Integer> patInput;
		int count = 1;
		boolean addTwo = false;
		
		while(count <= startNum) {
			patInput = new ArrayList();
			patInput.add(count);
			
			if(addTwo == false && count > 2 && startNum - count > 1) {
				addTwo = true;
			}
			else {
				addTwo = false;
			}
			if(addTwo == true) {
				count++;
				patInput.add(count);
			}
			pattern.add(patInput);
			count++;
		}
	}
	
	private void printPattern(PrintWriter pr) {
		
		for(int i = pattern.size() - 1; i >= 0; i--) {
			if(i == 0) {
				pr.println("\\ " + pattern.get(i).get(0) + " /");
			}
			else if(i == pattern.size() - 1) {
				pr.println("/ " + pattern.get(i).get(0) + " \\");
			}
			else {
				if(pattern.get(i).size() == 1) {
					pr.println(" [" + pattern.get(i).get(0) + "]");
				}
				else {
					for(int j = 0; j < 2; j++) {
						pr.print("[" + pattern.get(i).get(j) + "]");
					}
					pr.println();
				}
			}
		}
		pr.println();
	}
}
