package encapsulation._1_ClassBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	double l = Double.parseDouble(reader.readLine());
	double w = Double.parseDouble(reader.readLine());
	double h = Double.parseDouble(reader.readLine());

	Box box = new Box(l, w, h);

	System.out.printf("Surface Area - %.2f%n", box.calculateSurfaceArea());
	System.out.printf("Lateral Surface Area - %.2f%n", box.calculateLateralSurfaceArea());
	System.out.printf("Volume – %.2f%n", box.calculateVolume());
    }

}
