package _07_associative_arrays.exercise;

import java.util.*;

public class _1_CountCharsInAString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();

		Map<Character, Integer> result = new LinkedHashMap<>();
		Character key = null;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ' ') {
				continue;
			}

			if (!result.containsKey(input.charAt(i))) {
				result.put(input.charAt(i), 1);
			} else {
				key = input.charAt(i);
				result.put(key, result.get(key) + 1);
			}
		}

		if (!result.isEmpty()) {
			for (Map.Entry<Character, Integer> entry : result.entrySet()) {
				System.out.println(entry.getKey() + " -> " + entry.getValue());
			}
		}

	}
}
