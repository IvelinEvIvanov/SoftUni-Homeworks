package interfaces_abstraction._4_FoodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	Map<String, Buyer> mapBuyers = new LinkedHashMap<>();
	int n = Integer.parseInt(reader.readLine());
	String input = "";
	String[] tokens = null;

	for (int i = 0; i < n; i++) {
	    input = reader.readLine();
	    tokens = input.split(" ");

	    String name = "";
	    int age = 0;

	    if (tokens.length == 4) {
		name = tokens[0];
		age = Integer.parseInt(tokens[1]);
		String id = tokens[2];
		String birthDay = tokens[3];
		mapBuyers.putIfAbsent(name, new Citizen(name, age, id, birthDay));
	    } else {
		name = tokens[0];
		age = Integer.parseInt(tokens[1]);
		String group = tokens[2];
		mapBuyers.putIfAbsent(name, new Rebel(name, age, group));
	    }
	} // for

	input = reader.readLine();
	while (!input.equals("End")) {
	    if (mapBuyers.containsKey(input)) {
		mapBuyers.get(input).buyFood();
	    }

	    input = reader.readLine();
	}

	int sum = 0;
	for (var itr : mapBuyers.entrySet()) {
	    sum += itr.getValue().getFood();
	}

	System.out.println(sum);

    }

}
