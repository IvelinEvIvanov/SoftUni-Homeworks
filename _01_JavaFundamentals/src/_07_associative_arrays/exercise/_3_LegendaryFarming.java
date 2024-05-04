package _07_associative_arrays.exercise;

import java.util.*;

public class _3_LegendaryFarming {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String Dragonwrath = "Dragonwrath";
		String Shadowmourn = "Shadowmourne";
		String Valanyr = "Valanyr";

		Map<String, Integer> items = new LinkedHashMap<>();
		boolean end = false;
		while (!end) {

			String[] input = scanner.nextLine()
									.split("\\s+");

			for (int i = 0; i < input.length - 1; i++) {
				if (i % 2 == 0) {
					if (!items.containsKey(input[i + 1].toLowerCase())) {
						items.put(input[i + 1].toLowerCase(), Integer.parseInt(input[i]));
					} else {
						items.put(	input[i + 1].toLowerCase(),
									items.get(input[i + 1].toLowerCase()) + Integer.parseInt(input[i]));
					}

					String material = input[i + 1].toLowerCase();

					if (material.equals("fragments")) {
						int sum = items.get(material);
						if (sum >= 250) {
							items.put(material, sum - 250);
							System.out.println(Valanyr + " obtained!");

							end = true;
							break;
						}
					}

					if (material.equals("shards")) {
						int sum = items.get(material);
						if (sum >= 250) {
							items.put(material, sum - 250);
							System.out.println(Shadowmourn + " obtained!");

							end = true;
							break;
						}
					}

					if (material.equals("motes")) {
						int sum = items.get(material);
						if (sum >= 250) {
							items.put(material, sum - 250);
							System.out.println(Dragonwrath + " obtained!");

							end = true;
							break;
						}
					}
				}
			}
		}

		scanner.close();

		Map<String, Integer> legendaryMaterials = new LinkedHashMap<String, Integer>();
		if (items.containsKey("fragments")) {
			legendaryMaterials.put("fragments", items.get("fragments"));
			items.remove("fragments");
		} else {
			legendaryMaterials.put("fragments", 0);
		}

		if (items.containsKey("motes")) {
			legendaryMaterials.put("motes", items.get("motes"));
			items.remove("motes");
		} else {
			legendaryMaterials.put("motes", 0);
		}

		if (items.containsKey("shards")) {
			legendaryMaterials.put("shards", items.get("shards"));
			items.remove("shards");
		} else {
			legendaryMaterials.put("shards", 0);
		}

		legendaryMaterials	.entrySet()
							.stream()
							.sorted((entry1, entry2) -> {
								int result = entry2	.getValue()
													.compareTo(entry1.getValue());
								if (result == 0) {
									entry1	.getKey()
											.compareTo(entry2.getKey());
								}

								return result;
							})
							.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

		items	.entrySet()
				.stream()
				.sorted((entry1, entry2) -> entry1	.getKey()
													.compareTo(entry2.getKey()))
				.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
	}
}
