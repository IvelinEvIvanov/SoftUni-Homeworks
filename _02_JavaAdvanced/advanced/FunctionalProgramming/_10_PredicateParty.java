package advanced.FunctionalProgramming;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class _10_PredicateParty {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	List<String> list = Arrays.stream(scanner.nextLine().split(" "))
		.collect(Collectors.toCollection(ArrayList::new));

	BiPredicate<String, String> startsWith = (name, prefix) -> name.startsWith(prefix);
	BiPredicate<String, String> endsWith = (name, sufix) -> name.endsWith(sufix);
	BiPredicate<String, Integer> isLength = (name, len) -> name.length() == len;

	while (true) {

	    String command = scanner.nextLine();

	    if (command.equals("Party!")) {
		break;
	    }

	    String[] tokens = command.split(" ");
	    int listSize = 0;

	    switch (tokens[0]) {
	    case "Double":
		if (tokens[1].equals("StartsWith")) {

		    listSize = list.size();
		    for (int i = 0; i < listSize; i++) {
			String name = list.get(i);

			if (startsWith.test(name, tokens[2])) {
			    list.add(name);
			}
		    }
		} else if (tokens[1].equals("EndsWith")) {

		    listSize = list.size();
		    for (int i = 0; i < listSize; i++) {
			String name = list.get(i);

			if (endsWith.test(name, tokens[2])) {
			    list.add(name);
			}
		    }
		} else if (tokens[1].equals("Length")) {

		    listSize = list.size();
		    int len = Integer.parseInt(tokens[2]);

		    for (int i = 0; i < listSize; i++) {
			String name = list.get(i);

			if (isLength.test(name, Integer.parseInt(tokens[2]))) {
			    list.add(name);
			}
		    }
		}
		break;

	    case "Remove":
		if (tokens[1].equals("StartsWith")) {

		    listSize = list.size();
		    for (int i = 0; i < listSize; i++) {
			String name = list.get(i);

			if (startsWith.test(name, tokens[2])) {
			    list.remove(name);
			    listSize--;
			}
		    }
		} else if (tokens[1].equals("EndsWith")) {

		    listSize = list.size();
		    for (int i = 0; i < listSize; i++) {
			String name = list.get(i);

			if (endsWith.test(name, tokens[2])) {
			    list.remove(name);
			    listSize--;
			}
		    }
		} else if (tokens[1].equals("Length")) {

		    listSize = list.size();
		    int len = Integer.parseInt(tokens[2]);

		    for (int i = 0; i < listSize; i++) {
			String name = list.get(i);

			if (isLength.test(name, Integer.parseInt(tokens[2]))) {
			    list.remove(name);
			    listSize--;
			}
		    }
		}
		break;

	    }

	    Collections.sort(list);

	} // while

	if (list.isEmpty()) {
	    System.out.println("Nobody is going to the party!");
	} else {
	    String result = "";
	    for (String person : list) {
		result += person + ", ";
	    }

	    result = result.substring(0, result.lastIndexOf(","));
	    System.out.println(result + " are going to the party!");
	}
    }

}
