package _07_associative_arrays.exercise;

import java.util.*;

public class _4_Orders {
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<String, Map<Double, Integer>> products = new HashMap<String, Map<Double, Integer>>();

		String input = scanner.nextLine();
		List<String> orders = new ArrayList<>();

		while (!input.equals("buy")) {

			String[] tokens = input.split("\\s+");
			String kName = tokens[0];
			Double price = Double.parseDouble(tokens[1]);
			Integer quantity = Integer.parseInt(tokens[2]);

			if (!products.containsKey(kName)) {
				products.put(kName, new HashMap<Double, Integer>() {
					{
						put(price, quantity);
					}
				});

				orders.add(kName);
			} else {
				Map<Double, Integer> value = products.get(kName);
				int oldQuant = 0;
				for (Map.Entry<Double, Integer> entry : value.entrySet()) {
					oldQuant = entry.getValue();
				}

				int newQuant = oldQuant + quantity;
				products.remove(kName);
				products.put(kName, new HashMap<Double, Integer>() {
					{
						put(price, newQuant);
					}
				});
			}

			input = scanner.nextLine();
		}

		scanner.close();

		for (int i = 0; i < orders.size(); i++) {
			Map<Double, Integer> current = products.get(orders.get(i));
			System.out.print(orders.get(i) + " -> ");
			for (Map.Entry<Double, Integer> entry : current.entrySet()) {
				System.out.printf("%.2f%n", entry.getKey() * entry.getValue());
			}
		}
	}
}
