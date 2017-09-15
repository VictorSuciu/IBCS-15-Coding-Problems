import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Pokey {
	
	File file = new File("Data Resources\\pokey.dat");
	Scanner readFile;
	
	ArrayList<Character> cards = new ArrayList();
	ArrayList<Character> difCards = new ArrayList();
	int[] counter;
	
	public Pokey(PrintWriter pr) throws FileNotFoundException {
		readFile = new Scanner(file);
		
		readFile.nextLine();
		
		while(readFile.hasNext()) {
			populateCardsList();
			System.out.println(findBestHand());
		}
		
		
	}
	
	private void populateCardsList() {

		for(int i = 0; i < 5; i++) {
			cards.add(readFile.next().charAt(0));
		}

	}
	
	private String findBestHand() {
		
		boolean duplicate = false;
		
		for(char c : cards) {
			for(char c2 : difCards) {
				if(c2 == c) {
					duplicate = true;
				}
			}
			if(duplicate == false) {
				difCards.add(c);
			}
			duplicate = false;
		}
		
		counter = new int[difCards.size()];
		
		int count = 0;
		for(int i = 0; i < difCards.size(); i++) {
			for(char c2 : cards) {
				if(c2 == difCards.get(i)) {
					count++;
				}
			}
			counter[i] = count;
			count = 0;
		}
		
		
		
		if(hasFullHouse() == true) {
			return "Full House";
		}
		else if(hasTriple() == true) {
			return "Triple";
		}
		else if(hasPair() == true) {
			return "Pair";
		}
		else {
			return "Zilch";
		}
		
	}
	
	private boolean hasFullHouse() {
		
		if(counter.length == 2 && (counter[0] == 2 || counter[0] == 3)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean hasTriple() {
		for(int i : counter) {
			if(i == 3 || i == 4) {
				return true;
			}
		}
		return false;
	}
	
	private boolean hasPair() {
		for(int i : counter) {
			if(i == 2) {
				return true;
			}
		}
		return false;
	}
}
