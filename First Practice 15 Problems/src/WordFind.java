import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class WordFind {
	
	File file = new File("Data Resources\\wordfind.dat");
	Scanner readFile;
	ArrayList<String> words = new ArrayList();
	char[][] letterArray = new char[10][10];
	
	public WordFind(PrintWriter pr) throws FileNotFoundException {
		pr.println("==========Word-Find==========");
		readFile = new Scanner(file);
		getWords();
		buildLetterArray();
		for(String s : words) {
			Point point = new Point(findWord(s));
			pr.println((int)point.getX() + " " + (int)point.getY());
		}
		
	}
	
	private void getWords() {
		int rep = readFile.nextInt();
		for(int i = 0; i < rep; i++) {
			words.add(readFile.next());
		}
	}
	
	private void buildLetterArray() {
		int row = 0;
		int col = 0;
		while(readFile.hasNextLine()) {
			for(int i = 0; i < 10; i++) {
				letterArray[row][col] = readFile.next().charAt(0);
				col++;
			}
			col = 0;
			row++;
		}
	}
	private Point findWord(String word) {
		char currentChar = ' ';
		int x = 0;
		int y = 0;
		int wordIndex = 0;
		Point wordLoc = new Point();
		for(int row = 0; row < letterArray.length; row++) {
			for(int col = 0; col < letterArray[row].length; col++) {
				currentChar = letterArray[row][col];
				
				if(currentChar == word.charAt(0)) {
					
					int index = col;
					
					while(index < letterArray[row].length - 1 && wordIndex != word.length() - 1) {
						index++;
						wordIndex++;
						if(letterArray[row][index] != word.charAt(wordIndex)) {
							break;
								
						}		
					}
					
					if(wordIndex < word.length() - 1) {
						wordIndex = 0;
						index = row;
						while(index < letterArray.length - 1 && wordIndex != word.length() - 1) {
							index++;
							wordIndex++;
							if(letterArray[index][col] != word.charAt(wordIndex)) {
								break;
									
							}		
						}
						
						
					}
					
					if(wordIndex == word.length() - 1) {
						x = col;
						y = row;
						return new Point(x, y);
					}
					
					
				}
				wordIndex = 0;
				
			}
			System.out.println();
		}
		return new Point();
	}
}
