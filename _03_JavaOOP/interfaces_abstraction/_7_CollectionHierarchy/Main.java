package interfaces_abstraction._7_CollectionHierarchy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner reader = new Scanner(System.in);

	String[] items = reader.nextLine().split(" ");
	int itemsToBeRemoved = Integer.parseInt(reader.nextLine());

	AddCollection addCollection = new AddCollection();
	AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
	MyListImpl myListCollection = new MyListImpl();

	StringBuilder result = new StringBuilder();

	// Add
	for (String item : items) {
	    result.append(addCollection.add(item) + " ");
	}

	System.out.println(result.toString().trim());
	result.delete(0, result.length());

	for (String item : items) {
	    result.append(addRemoveCollection.add(item) + " ");
	}

	System.out.println(result.toString().trim());
	result.delete(0, result.length());

	for (String item : items) {
	    result.append(myListCollection.add(item) + " ");
	}

	System.out.println(result.toString().trim());
	result.delete(0, result.length());

	// Remove
	for (int i = 0; i < itemsToBeRemoved; i++) {
	    result.append(addRemoveCollection.remove() + " ");
	}

	System.out.println(result.toString().trim());
	result.delete(0, result.length());

	for (int i = 0; i < itemsToBeRemoved; i++) {
	    result.append(myListCollection.remove() + " ");
	}

	System.out.println(result.toString().trim());
	result.delete(0, result.length());

    }

}
