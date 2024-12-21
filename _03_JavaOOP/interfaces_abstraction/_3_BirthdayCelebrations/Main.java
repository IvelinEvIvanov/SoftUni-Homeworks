package interfaces_abstraction._3_BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner reader = new Scanner(System.in);

	List<String> years = new ArrayList();

	String input = reader.nextLine();
	while (!input.equals("End")) {

	    String[] tokens = input.split(" ");
	    String command = tokens[0];

	    switch (command) {
	    case "Citizen":
		years.add(new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]).getBirthDate());
		break;
	    case "Pet":
		years.add(new Pet(tokens[1], tokens[2]).getBirthDate());
		break;
	    }

	    input = reader.nextLine();
	} // while

	String year = reader.nextLine();
	boolean flag = false;
	for (int i = 0; i < years.size(); i++) {
	    String current = years.get(i);

	    if (current.substring(current.length() - 4).equals(year)) {
		System.out.println(current);
		flag = true;
	    }
	}

	if (!flag) {
	    System.out.println("<no output>");
	}
    }

}
