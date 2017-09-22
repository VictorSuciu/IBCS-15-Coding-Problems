import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Gorf {
	
	File file = new File("Data Resources\\gorf.dat");
	Scanner readFile;
	double x;
	double a;
	double b;
	double c;
	
	public Gorf(PrintWriter pr) throws FileNotFoundException {
		pr.println("==========GORF==========");
		readFile = new Scanner(file);
		
		readFile.nextLine();
		
		while(readFile.hasNextLine()) {
			a = readFile.nextDouble();
			b = readFile.nextDouble();
			c = readFile.nextDouble();
			x = calculateDistance();
			System.out.println(a + " " + b + " " + c + " " + x);
			pr.println(x);
			
		}
	}
	
	private double calculateDistance() {
		double p1 = ((0 - b) - (Math.sqrt((b * b) - (4 * a * c)))) / (2 * a);
		double p2 = ((0 - b) + (Math.sqrt((b * b) - (4 * a * c)))) / (2 * a);
		return round(p2 - p1);
	}
	
	private double round(double d) {
		
		boolean isPositive;
		if(d < 0) {
			isPositive = false;
		}
		else {
			isPositive = true;
		}
		d = Math.abs(d);
		double tempD = (double)((int)d);
		double testNum = d - tempD;
		double low = 0.0;
		double high = 0.0;
		while(low < testNum - 0.1) {
			low += 0.1;
		}
		while(high < testNum) {
			high += 0.1;
		}
		
		if(testNum - low < high - testNum) {
			d = tempD + low;
		}
		else {
			d = tempD + high;
		}
		
		if(isPositive == true) {
			return d;
		}
		else {
			return 0 - d;
		}
		
				
		
	}
}
