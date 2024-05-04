package _07_associative_arrays.exercise;

import java.util.*;

public class _2_AMinerTask {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<String, Integer> result = new LinkedHashMap<>();

		String input = scanner.nextLine();
		int rows = 0;
		String key = "";
		while (!input.equals("stop")) {
			++rows;
			if (rows % 2 != 0) {
				result.putIfAbsent(input, 0);
				key = input;
			} else {
				int value = Integer.parseInt(input);
				result.put(key, result.get(key) + value);
			}

			input = scanner.nextLine();
		}

		scanner.close();

		for (Map.Entry<String, Integer> entry : result.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}
}
