import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;


public class GameReviews {
	
	File file = new File("Data Resources\\gamereviews.dat");
	Scanner readFile;
	HashMap<String, ArrayList<Integer>> gamesMap = new HashMap<String, ArrayList<Integer>>();
	
	public GameReviews(PrintWriter pr) throws FileNotFoundException {
		readFile = new Scanner(file);
		pr.println("==========Game-Reviews==========");
		int rep = readFile.nextInt();
		readFile.nextLine();
		String line = "";
		Scanner readLine;
		String temp = "";
		 
		boolean foundComma = false;
		 
		for(int i = 0; i < rep; i++) {
			 
			line = readFile.nextLine();
			readLine = new Scanner(line);
			readLine.next();
			temp = readLine.next();
			 
			while(temp.charAt(temp.length() - 1) != ',') {
				temp += " ";
				temp += readLine.next();
				
				
			}
			temp = temp.substring(0, temp.length() - 1);
			populateHashMap(temp, readLine.nextInt());
			
		 }
		 
		 for(String s : gamesMap.keySet()) {
			 pr.println(s + " gets " + round(getMean(s)) + " stars");
		 }
	}
	
	private void populateHashMap(String game, int review) {
		
		ArrayList<Integer> addList = new ArrayList();
		if(gamesMap.get(game) == null) {
			gamesMap.put(game, addList);
			gamesMap.get(game).add(review);
		}
		else {
			gamesMap.get(game).add(review);
		}

	}
	
	private double getMean(String game) {
		
		int count = 0;
		double mean = 0.0;
		
		for(int i : gamesMap.get(game)) {
			mean += (double)i;
			count++;
		}
		
		return mean / (double)count;
	}
	
	private double round(double num) {
		int noDec = (int)num;
		double allDec = num - (double)noDec;
		
		double count = 0.0;
		
		while(count < allDec - 0.1) {
			count += 0.1;
		}
		
		return (double)noDec + count;
		
	}
}
