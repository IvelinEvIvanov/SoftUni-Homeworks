package encapsulation._3_ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	Map<String, Person> mapPerson = new LinkedHashMap<>();
	Map<String, Product> mapProduct = new LinkedHashMap<>();

	String personsLine = reader.readLine();
	String productsLine = reader.readLine();

	String[] personsTokens = personsLine.split(";");
	String[] productsTokens = productsLine.split(";");

	for (int i = 0; i < personsTokens.length; i++) {
	    String name = personsTokens[i].split("=")[0];
	    double money = Double.parseDouble(personsTokens[i].split("=")[1]);

	    try {
		mapPerson.put(name, new Person(name, money));
	    } catch (IllegalArgumentException ex) {
		System.out.println(ex.getMessage());
	    }

	}

	for (int i = 0; i < productsTokens.length; i++) {
	    String name = productsTokens[i].split("=")[0];
	    double cost = Double.parseDouble(productsTokens[i].split("=")[1]);

	    try {
		mapProduct.put(name, new Product(name, cost));
	    } catch (IllegalArgumentException ex) {
		System.out.println(ex.getMessage());
	    }

	    ;
	}

	String purchases = reader.readLine();
	while (!purchases.equals("END")) {
	    String personName = purchases.split(" ")[0];
	    String productName = purchases.split(" ")[1];

	    Person person = mapPerson.get(personName);
	    Product product = mapProduct.get(productName);

	    if (person != null && product != null) {
		try {
		    person.buyProduct(product);
		    System.out.println(personName + " bought " + productName);
		} catch (IllegalArgumentException ex) {
		    System.out.println(ex.getMessage());
		}
	    }

	    purchases = reader.readLine();

	}

	if (mapPerson.size() > 0) {
	    mapPerson.forEach((k, v) -> System.out.println(v));
	}
    }

}
