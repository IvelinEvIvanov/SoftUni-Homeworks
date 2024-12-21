package abstraction._1_CardSuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	String input = reader.readLine();
	System.out.println(input + ":");

	for (Suits item : Suits.values()) {
	    System.out.print("Ordinal value: " + item.ordinal() + "; ");
	    System.out.print("Name value: " + item);
	    System.out.println();
	}

    }
}
