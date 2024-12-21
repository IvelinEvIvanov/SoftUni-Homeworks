package advanced.SetsAndMaps;

import java.util.*;

public class _5_Phonebook {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	Map<String, String> phonebook = new HashMap<String, String>();
	while (true) {
	    String input = scanner.nextLine();

	    if (!input.equals("search")) {
		String[] tokens = input.split("-");
		String name = tokens[0];
		String phone = tokens[1];
		if (!phonebook.containsKey(name)) {
		    phonebook.put(name, phone);
		} else {
		    phonebook.put(name, phone);
		}
	    } else if (input.equals("search")) {
		String name = scanner.nextLine();
		while (!name.equals("stop")) {
		    if (phonebook.containsKey(name)) {
			String phone = phonebook.get(name);
			System.out.println(name + " -> " + phone);
		    } else {
			System.out.println("Contact " + name + " does not exist.");
		    }

		    name = scanner.nextLine();
		}

		if (name.equals("stop")) {
		    break;
		}

	    }
	}
    }

}
