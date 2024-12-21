package advanced.SetsAndMaps;

import java.util.*;

public class _6_AMinerTask {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	Map<String, Integer> mapResources = new LinkedHashMap();
	int counter = 1;

	while (true) {
	    String input = scanner.nextLine();

	    if (input.equals("stop")) {
		break;
	    }

	    String resource = input;
	    int quantity = Integer.parseInt(scanner.nextLine());

	    if (!mapResources.containsKey(resource)) {
		mapResources.put(resource, quantity);

	    } else {
		mapResources.put(resource, mapResources.get(resource) + quantity);
	    }
	}

	for (String key : mapResources.keySet()) {
	    System.out.printf("%s -> %d%n", key, mapResources.get(key));
	}

    }

}
