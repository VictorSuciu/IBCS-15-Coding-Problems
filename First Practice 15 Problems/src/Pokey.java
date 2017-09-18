import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Pokey {
	
	File file = new File("Data Resources\\pokey.dat");
	Scanner readFile;
	
	ArrayList<String> cards = new ArrayList();
	ArrayList<String> difCards = new ArrayList();
	String[] cardOrder = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

	int[] counter;
	
	public Pokey(PrintWriter pr) throws FileNotFoundException {
		readFile = new Scanner(file);
		
		readFile.nextLine();
		
		pr.println("==========Pokey==========");
		while(readFile.hasNext()) {
			populateCardsList();
			pr.println(findBestHand());
			cards.clear();
			difCards.clear();
		}
		
		
	}
	
	private void populateCardsList() {

		for(int i = 0; i < 5; i++) {
			
			cards.add(readFile.next());
		}

	}
	
	private String findBestHand() {
		
		boolean duplicate = false;
		
		for(String s : cards) {
			for(String s2 : difCards) {
				if(s2.equals(s)) {
					duplicate = true;
				}
			}
			if(duplicate == false) {
				difCards.add(s);
			}
			duplicate = false;
		}
		
		counter = new int[difCards.size()];
		
		int count = 0;
		for(int i = 0; i < difCards.size(); i++) {
			for(String s2 : cards) {
				if(s2.equals(difCards.get(i))) {
					count++;
				}
			}
			counter[i] = count;
			count = 0;
		}
		
		System.out.println(cards);
		
		
		if(hasFullHouse() == true) {
			return "Full House";
		}
		else if(hasStraight() == true) {
			return "Straight";
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
	
	private boolean hasStraight() {
		
		int startIndex = 0;
		
		while(!cardOrder[startIndex].equals(cards.get(0))) {
			startIndex++;
			if(startIndex == 14) {
				return false;
			}
		}

		
		for(int i = 1; i < cards.size() - 1; i++) {
			if(!cards.get(i).equals(cardOrder[startIndex + i])) {
				return false;
			}
		}
		return true;
	}
}
