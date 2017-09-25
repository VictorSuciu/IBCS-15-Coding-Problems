import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Chaseball {
	
	PrintWriter pr;
	File file = new File("Data Resources/chaseball.dat");
	Scanner readFile;
	int sideLength;
	
	public Chaseball(PrintWriter pr) throws FileNotFoundException {
		readFile = new Scanner(file);
		this.pr = pr;
		pr.println("==========Chaseball==========");
		
		int rep = readFile.nextInt();
		
		for(int i = 0; i < rep; i++) {
			sideLength = readFile.nextInt();
			drawField();
		}
	}
	
	private void drawField() {
		drawTop();
		drawBottom();
	}
	
	private void drawTop() {
		for(int i = 0; i < sideLength; i++) {
			for(int spaces = 0; spaces < (-1 - i) + sideLength; spaces++) {
				pr.print(" ");
			}
			pr.print("/");
			for(int spaces = 0; spaces < i * 2; spaces++) {
				pr.print(" ");
			}
			pr.print("\\");
			pr.println();
		}
	}
	
	private void drawBottom() {
		for(int i = sideLength - 1; i >= 0; i--) {
			for(int spaces = 0; spaces < (-1 - i) + sideLength; spaces++) {
				pr.print(" ");
			}
			pr.print("\\");
			for(int spaces = 0; spaces < i * 2; spaces++) {
				pr.print(" ");
			}
			pr.print("/");
			pr.println();
		}
		pr.println();
	}
}
