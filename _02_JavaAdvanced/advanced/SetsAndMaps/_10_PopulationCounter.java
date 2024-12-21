package advanced.SetsAndMaps;

import java.util.*;
import java.util.stream.Collectors;

public class _10_PopulationCounter {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	Map<String, Map<String, Integer>> mapCountries = new LinkedHashMap<>();
	Map<String, Integer> mapPopulation = new LinkedHashMap<>();

	while (true) {
	    String input = scanner.nextLine();
	    if (input.equals("report")) {
		break;
	    }

	    String[] tokens = input.split("\\|");

	    String country = tokens[1];
	    String city = tokens[0];
	    int population = Integer.parseInt(tokens[2]);

	    Map<String, Integer> mapCity = new LinkedHashMap<>();
	    if (!mapCountries.containsKey(country)) {
		mapCity.put(city, population);
		mapCountries.put(country, mapCity);

		mapPopulation.put(country, population);
	    } else {
		mapCity = mapCountries.get(country);
		mapCity.put(city, population);
		mapCountries.put(country, mapCity);

		mapPopulation.put(country, mapPopulation.get(country) + population);
	    }

	} // while

	// sort by population
	mapPopulation = mapPopulation.entrySet().stream()
		.sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue())).collect(Collectors.toMap(
			Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

	// print result
	for (Map.Entry<String, Integer> entry : mapPopulation.entrySet()) {

	    System.out.printf("%s (total population: %d)%n", entry.getKey(), entry.getValue());

	    mapCountries.get(entry.getKey()).entrySet().stream()
		    .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
		    .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
	}

    }

}
