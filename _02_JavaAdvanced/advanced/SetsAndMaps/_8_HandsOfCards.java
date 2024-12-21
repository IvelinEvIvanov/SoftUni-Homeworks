package advanced.SetsAndMaps;

import java.util.*;

public class _8_HandsOfCards {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	Map<Character, Integer> mapPower = new HashMap<>();
	mapPower.put('J', 11);
	mapPower.put('Q', 12);
	mapPower.put('K', 13);
	mapPower.put('A', 14);

	Map<Character, Integer> mapType = new HashMap<>();
	mapType.put('S', 4);
	mapType.put('H', 3);
	mapType.put('D', 2);
	mapType.put('C', 1);

	Map<String, Set<String>> mapPlayersCards = new LinkedHashMap<>();
	Map<String, Integer> mapPlayersScore = new LinkedHashMap<>();

	while (true) {
	    String input = scanner.nextLine();

	    if (input.equals("JOKER")) {
		break;
	    }

	    input = input.replace(" ", "");

	    String[] tokens = input.split(":");
	    String name = tokens[0];
	    String[] cards = tokens[1].split(",");

	    Set<String> nextCards = new HashSet<>(Arrays.asList(cards));

	    // make cards unique
	    if (!mapPlayersCards.containsKey(name)) {
		mapPlayersCards.put(name, new HashSet<String>(nextCards));
	    } else {
		Set<String> updatedMap = mapPlayersCards.get(name);
		updatedMap.addAll(nextCards);
		mapPlayersCards.put(name, updatedMap);
	    }

	} // end while

	for (Map.Entry<String, Set<String>> entry : mapPlayersCards.entrySet()) {

	    int sum = 0;
	    String name = "";
	    // sum cards
	    for (String card : entry.getValue()) {

		char power = 0;
		char type = 0;
		int digit = 0;

		char letter = card.charAt(0);
		if (Character.isDigit(letter)) {

		    if (letter == '1') {
			type = card.charAt(2);
			sum += (10 * mapType.get(type));
		    } else {
			digit = Integer.parseInt("" + card.charAt(0));
			type = card.charAt(1);
			sum += (digit * mapType.get(type));
		    }
		} else {
		    power = card.charAt(0);
		    type = card.charAt(1);
		    sum += (mapPower.get(power) * mapType.get(type));
		}

	    }

	    name = entry.getKey();
	    // add sum of cards to player
	    if (!mapPlayersScore.containsKey(name)) {
		mapPlayersScore.put(name, sum);
	    } else {
		mapPlayersScore.put(name, mapPlayersScore.get(name) + sum);
	    }

	}

	// print result
	mapPlayersScore.forEach((k, v) -> System.out.printf("%s: %d%n", k, v));

    }

}
