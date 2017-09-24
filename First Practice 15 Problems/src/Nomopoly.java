import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Nomopoly {
	
	File file = new File("Data Resources/nomopoly.dat");
	Scanner readFile;
	Scanner getRent;
	
	int rep;
	int numOfHouses;
	double rent;
	String propertyName;
	String tempRent;
	public Nomopoly(PrintWriter pr) throws FileNotFoundException {
		readFile = new Scanner(file);
		pr.println("==========Nomopoly==========");
		rep = readFile.nextInt();
		readFile.nextLine();
		
		for(int i = 0; i < rep; i++) {
			
			propertyName = readFile.nextLine();
			tempRent = readFile.nextLine();
			tempRent = tempRent.substring(1, tempRent.length() - 1);
			getRent = new Scanner(tempRent);
			rent = getRent.nextDouble();
			numOfHouses = Integer.parseInt(readFile.nextLine());
			
			pr.println("If someone lands on " + propertyName 
								+ ", they will owe me $" + getMoneyOwed() + "0.");
		}
	}
	
	private double getMoneyOwed() {
		
		double ret = rent;
		
		for(int i = 0; i < numOfHouses; i++) {
			ret = ret * 2.25;
		}
		
		return (double)((int)ret);
	}
}
