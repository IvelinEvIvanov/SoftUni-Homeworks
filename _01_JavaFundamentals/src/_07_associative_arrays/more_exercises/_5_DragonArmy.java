package _07_associative_arrays.more_exercises;

import java.util.*;

public class _5_DragonArmy {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<String, List<Integer>> mapDragons = new LinkedHashMap<>();

		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < n; i++) {
			String input = scanner.nextLine();
			String[] tokens = input.split("\\s+");

			String type = tokens[0];
			String name = tokens[1];
			Integer damage = 0;
			Integer health = 0;
			Integer armor = 0;

			if (tokens[2].equals("null")) {
				damage = 45;
			} else {
				damage = Integer.parseInt(tokens[2]);
			}

			if (tokens[3].equals("null")) {
				health = 250;
			} else {
				health = Integer.parseInt(tokens[3]);
			}

			if (tokens[4].equals("null")) {
				armor = 10;
			} else {
				armor = Integer.parseInt(tokens[4]);
			}

			String theKey = type + " " + name;
			List<Integer> listStats = new ArrayList<>();
			if (!mapDragons.containsKey(theKey)) {
				mapDragons.put(theKey, listStats);

				mapDragons	.get(theKey)
							.add(damage);
				mapDragons	.get(theKey)
							.add(health);
				mapDragons	.get(theKey)
							.add(armor);
			} else {
				mapDragons	.get(theKey)
							.add(damage);
				mapDragons	.get(theKey)
							.add(health);
				mapDragons	.get(theKey)
							.add(armor);
			}

		}

		scanner.close();

		Map<String, TreeMap<String, String>> result = new LinkedHashMap<>();
		mapDragons	.entrySet()
					.stream()
					.forEach(entry -> {
						String color = entry.getKey()
											.split(" ")[0];
						String name = entry	.getKey()
											.split(" ")[1];
						String stats = "" + entry	.getValue()
													.get(0);
						stats += " " + entry.getValue()
											.get(1);
						stats += " " + entry.getValue()
											.get(2);

						Long colorCount = mapDragons.entrySet()
													.stream()
													.filter(f -> f	.getKey()
																	.contains(color))
													.count();
						stats += " " + colorCount;

						TreeMap<String, String> dragonNames = new TreeMap<>();
						if (!result.containsKey(color)) {
							result.put(color, dragonNames);
							result	.get(color)
									.put(name, stats);
						} else {
							result	.get(color)
									.put(name, stats);
						}
					});

		for (Map.Entry<String, TreeMap<String, String>> entry : result.entrySet()) {
			double damage = 0;
			double health = 0;
			double armor = 0;
			double colorCount = 0;

			for (Map.Entry<String, String> value : entry.getValue()
														.entrySet()) {
				damage += Integer.parseInt(value.getValue()
												.split(" ")[0]);
				health += Integer.parseInt(value.getValue()
												.split(" ")[1]);
				armor += Integer.parseInt(value	.getValue()
												.split(" ")[2]);

				colorCount = Integer.parseInt(value	.getValue()
													.split(" ")[3]);
			}

			System.out.printf(	"%s::(%.2f/%.2f/%.2f)%n", entry.getKey(), damage / colorCount, health / colorCount,
								armor / colorCount);

			for (Map.Entry<String, String> value : entry.getValue()
														.entrySet()) {
				int iDamage = Integer.parseInt(value.getValue()
													.split(" ")[0]);
				int iHealth = Integer.parseInt(value.getValue()
													.split(" ")[1]);
				int iArmor = Integer.parseInt(value	.getValue()
													.split(" ")[2]);

				System.out.printf(	"-%s -> damage: %d, health: %d, armor: %d%n", value.getKey(), iDamage, iHealth,
									iArmor);
			}
		}
	}
}
