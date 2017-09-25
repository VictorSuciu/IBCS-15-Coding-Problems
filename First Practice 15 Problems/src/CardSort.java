import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class CardSort {
	
	File file = new File("Data Resources/cardsort.dat");
	Scanner readFile;
	
	ArrayList<String> clubs = new ArrayList();
	ArrayList<String> diamonds = new ArrayList();
	ArrayList<String> hearts = new ArrayList();
	ArrayList<String> spades = new ArrayList();
	
	ArrayList<String> mainList = new ArrayList();
	int lineNum;
	String line;
	
	public CardSort(PrintWriter pr) throws FileNotFoundException {
		readFile = new Scanner(file);
		pr.println("==========Card-Sort==========");
		
		lineNum = readFile.nextInt();
		readFile.nextLine();
		for(int i = 0; i < lineNum; i++) {
			line = readFile.nextLine();
			populateLists();
			populateMainList();
			pr.println(mainList);
			clearLists();
		}
		
	}
	
	private void populateLists() {
		String[] cardArray = line.split(", ");
		
		for(String s : cardArray) {
			if(s.split(" ")[0].equals("club")) {
				clubs.add(s);
			}
			else if(s.split(" ")[0].equals("diamond")) {
				diamonds.add(s);
			}
			else if(s.split(" ")[0].equals("heart")) {
				hearts.add(s);
			}
			else if(s.split(" ")[0].equals("spade")) {
				spades.add(s);
			}
		}
		
		clubs = sortList(clubs);
		diamonds = sortList(diamonds);
		hearts = sortList(hearts);
		spades = sortList(spades);
	}
	
	private ArrayList<String> sortList(ArrayList<String> list) {
		String[] cardOrder = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		int minIndex = 0;
		int min = 13;
		int orderIndex = 0;
		String temp = "";
		String tempCard;
		String[] cardArray;
		
		for(int i = 0; i < list.size(); i++) {
			for(int j = i; j < list.size(); j++) {
				temp = list.get(j).split(" ")[1];
				while(!cardOrder[orderIndex].equals(temp)) {
					orderIndex++;
				}
				if(min > orderIndex) {
					min = orderIndex;
					minIndex = j;
				}
				orderIndex = 0;
			}
			tempCard = list.get(minIndex);
			list.remove(minIndex);
			list.add(i, tempCard);
			
			min = 13;
			minIndex = 0;
		}
		
		return list;
	}
	
	private void populateMainList() {
		for(String s : clubs) {
			mainList.add(s);
		}
		for(String s : diamonds) {
			mainList.add(s);
		}
		for(String s : hearts) {
			mainList.add(s);
		}
		for(String s : spades) {
			mainList.add(s);
		}
	}
	
	private void clearLists() {
		clubs.clear();
		diamonds.clear();
		hearts.clear();
		spades.clear();
		mainList.clear();
	}
}
