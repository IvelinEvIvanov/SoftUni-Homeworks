package _07_associative_arrays.more_exercises;

import java.util.*;

public class _4_Snowwhite {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, Integer> mapDwarfs = new LinkedHashMap<>();

		String input = scanner.nextLine();
		while (!input.equals("Once upon a time")) {
			String[] tokens = input.split("\\s*<:>\\s*");
			String name = tokens[0];
			String hatColor = tokens[1];
			Integer physics = Integer.parseInt(tokens[2]);

			String theKey = name + " " + hatColor;
			if (!mapDwarfs.containsKey(theKey)) {
				mapDwarfs.put(theKey, physics);
			} else {
				if (physics > mapDwarfs.get(theKey)) {
					mapDwarfs.put(theKey, physics);
				}
			}

			input = scanner.nextLine();
		}

		scanner.close();

		mapDwarfs	.entrySet()
					.stream()
					.sorted((entry1, entry2) -> {
						int n = entry2	.getValue()
										.compareTo(entry1.getValue());
						if (n == 0) {
							String color1 = entry1	.getKey()
													.split(" ")[1];
							
							String color2 = entry2	.getKey()
													.split(" ")[1];

							long colorCount1 = mapDwarfs.entrySet()
														.stream()
														.filter(p -> p	.getKey()
																		.contains(color1))
														.count();
							
							long colorCount2 = mapDwarfs.entrySet()
														.stream()
														.filter(p -> p	.getKey()
																		.contains(color2))
														.count();

							int n1 = Integer.compare((int) colorCount2, (int) colorCount1);
							/*
							 * if (n1 == 0) { return entry1.getKey().substring(entry1.getKey().indexOf(" "))
							 * .compareTo(entry2.getKey().substring(entry2.getKey().indexOf(" "))); } else {
							 * return n1; }
							 */

							return n1;
						} else {
							return n;
						}

					})
					.forEach(e -> {
						String name = e	.getKey()
										.split(" ")[0];
						
						String hat = e	.getKey()
										.split(" ")[1];

						System.out.printf("(%s) %s <-> %d%n", hat, name, e.getValue());
					});
	}
}
