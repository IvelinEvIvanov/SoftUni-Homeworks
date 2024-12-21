package encapsulation._4_PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	String input = reader.readLine();
	Pizza pizza = null;
	while (!input.equals("END")) {

	    String[] tokens = input.split(" ");

	    try {
		switch (tokens[0]) {
		case "Pizza":
		    pizza = new Pizza(tokens[1], Integer.parseInt(tokens[2]));
		    break;
		case "Dough":
		    pizza.setDought(new Dough(tokens[1], tokens[2], Double.parseDouble(tokens[3])));
		    break;
		case "Topping":
		    pizza.addTopping(new Topping(tokens[1], Double.parseDouble(tokens[2])));
		    break;
		}

	    } catch (IllegalArgumentException e) {
		System.out.println(e.getMessage());
		return;
	    }

	    input = reader.readLine();
	} // while

	if (pizza != null) {
	    System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
	}
    }

}
