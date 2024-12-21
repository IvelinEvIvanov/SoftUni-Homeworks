package abstraction._6_GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);
	long bagCapacity = Long.parseLong(scanner.nextLine());
	String[] input = scanner.nextLine().split("\\s+");

	var bag = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
	long gold = 0;
	long gems = 0;
	long cash = 0;

	for (int i = 0; i < input.length; i += 2) {
	    String name = input[i];
	    long quantity = Long.parseLong(input[i + 1]);

	    String item = "";

	    item = getItemName(name);

	    if (item.equals("")) {
		continue;
	    } else if (bagCapacity < bag.values().stream().map(Map::values).flatMap(Collection::stream)
		    .mapToLong(e -> e).sum() + quantity) {
		continue;
	    }

	    switch (item) {
	    case "Gem":
		if (!bag.containsKey(item)) {
		    if (bag.containsKey("Gold")) {
			if (quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
			    continue;
			}
		    } else {
			continue;
		    }
		} else if (bag.get(item).values().stream().mapToLong(e -> e).sum() + quantity > bag.get("Gold").values()
			.stream().mapToLong(e -> e).sum()) {
		    continue;
		}
		break;
	    case "Cash":
		if (!bag.containsKey(item)) {
		    if (bag.containsKey("Gem")) {
			if (quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
			    continue;
			}
		    } else {
			continue;
		    }
		} else if (bag.get(item).values().stream().mapToLong(e -> e).sum() + quantity > bag.get("Gem").values()
			.stream().mapToLong(e -> e).sum()) {
		    continue;
		}
		break;
	    }

	    if (!bag.containsKey(item)) {
		bag.put((item), new LinkedHashMap<String, Long>());
	    }

	    if (!bag.get(item).containsKey(name)) {
		bag.get(item).put(name, 0L);
	    }

	    bag.get(item).put(name, bag.get(item).get(name) + quantity);
	    if (item.equals("Gold")) {
		gold += quantity;
	    } else if (item.equals("Gem")) {
		gems += quantity;
	    } else if (item.equals("Cash")) {
		cash += quantity;
	    }
	}

	for (var x : bag.entrySet()) {
	    Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

	    System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

	    x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
		    .forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

	}
    }

    private static String getItemName(String name) {
	if (name.length() == 3) {
	    return "Cash";
	} else if (name.toLowerCase().endsWith("gem")) {
	    return "Gem";
	} else if (name.toLowerCase().equals("gold")) {
	    return "Gold";
	}

	return "";
    }

}
