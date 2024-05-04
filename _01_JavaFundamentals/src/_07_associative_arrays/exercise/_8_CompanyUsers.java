package _07_associative_arrays.exercise;

import java.util.*;

public class _8_CompanyUsers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		TreeMap<String, List<String>> companies = new TreeMap<String, List<String>>();

		String input = scanner.nextLine();
		while (!input.equals("End")) {

			String[] tokens = input.split("\\s+->\\s+");
			if (!companies.containsKey(tokens[0])) {
				companies.put(tokens[0], new ArrayList<String>());
				companies	.get(tokens[0])
							.add(tokens[1]);
			} else {
				if (!companies	.get(tokens[0])
								.contains(tokens[1])) {
					
					companies	.get(tokens[0])
								.add(tokens[1]);
				}
			}

			input = scanner.nextLine();
		}

		scanner.close();

		companies.forEach((k, v) -> {
			System.out.println(k);
			v.forEach(e -> System.out.println("-- " + e));
		});
	}
}
