import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Invaders {
	
	File file = new File("Data Resources/invaders.dat");
	Scanner readFile;
	HashMap<String, Integer> cityMap = new HashMap<String, Integer>();
	PrintWriter pr;
	
	String city;
	int milesToCity;
	int lineNum;
	int mileCount = 0;
	int spreadRate = 1000;
	int lastMileCount = 0;
	int fallenCityCount = 0;
	int dayCount = 1;
	
	public Invaders(PrintWriter pr) throws FileNotFoundException {
		readFile = new Scanner(file);
		this.pr = pr;
		pr.println("==========Invaders==========");
		
		lineNum = readFile.nextInt();
		readFile.nextLine();
		generateCityMap();
		simulateAliens();
	}
	
	private void generateCityMap() {
		
		String[] line = new String[3];
		
		for(int i = 0; i < lineNum; i++) {
			line = readFile.nextLine().split(" ");
			cityMap.put(line[0], Integer.parseInt(line[2]));
		}
	}
	
	private void simulateAliens() {
		while(fallenCityCount < lineNum) {
			pr.println("Day " + dayCount);
			lastMileCount = mileCount;
			mileCount += spreadRate;
			pr.println("     Rate: " + spreadRate + " Miles Per Day");
			
			for(String s : getFallenCities()) {
				pr.println("     " + s + " Has Fallen!");
				fallenCityCount++;
				spreadRate *= 2;
			}
			dayCount++;
		}
		pr.println("     The aliens have taken over!");
	}
	
	private ArrayList<String> getFallenCities() {
		ArrayList<String> ret = new ArrayList();
		for(String s : cityMap.keySet()) {
			if(cityMap.get(s) <= mileCount && cityMap.get(s) > lastMileCount) {
				ret.add(s);
			}
		}
		return ret;
	}
}
