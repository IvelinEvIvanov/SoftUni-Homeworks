package _07_associative_arrays.more_exercises;

import java.util.*;

public class _1_Ranking {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<String, String> contestCollection = new LinkedHashMap<>();
		String input = scanner.nextLine();
		while (!input.equals("end of contests")) {
			String[] tokens = input.split(":");

			if (!contestCollection.containsKey(tokens[0])) {
				contestCollection.put(tokens[0], tokens[1]);
			}

			input = scanner.nextLine();
		}

		TreeMap<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();

		input = scanner.nextLine();
		while (!input.equals("end of submissions")) {
			String[] tokens = input.split("=>");
			String contest = tokens[0];
			String password = tokens[1];
			String username = tokens[2];
			Integer points = Integer.parseInt(tokens[3]);

			if (contestCollection.containsKey(contest) && contestCollection	.get(contest)
																			.equals(password)) {
				if (!users.containsKey(username)) {
					users.put(username, new LinkedHashMap<String, Integer>());
					users	.get(username)
							.put(contest, points);
				} else {
					if (users	.get(username)
								.containsKey(contest)) {
						int currentPoint = users.get(username)
												.get(contest);
						if (points > currentPoint) {
							users	.get(username)
									.put(contest, points);
						}
					} else {
						users	.get(username)
								.put(contest, points);
					}
				}
			}

			input = scanner.nextLine();
		}

		scanner.close();

		int totalPoints = 0;
		for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : users.entrySet()) {
			int sum = entry	.getValue()
							.values()
							.stream()
							.mapToInt(e -> e)
							.sum();
			if (sum > totalPoints) {
				totalPoints = sum;
			}
		}

		for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : users.entrySet()) {
			if (entry	.getValue()
						.values()
						.stream()
						.mapToInt(e -> e)
						.sum() == totalPoints) {
				System.out.printf("Best candidate is %s with total %d points.%n", entry.getKey(), totalPoints);
			}
		}

		System.out.println("Ranking: ");
		for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : users.entrySet()) {
			System.out.println(entry.getKey());
			entry	.getValue()
					.entrySet()
					.stream()
					.sorted((entry1, entry2) -> entry2.getValue() - entry1.getValue())
					.forEach(resultEntry -> {
						System.out.printf("#  %s -> %d%n", resultEntry.getKey(), resultEntry.getValue());
					});
		}
	}
}
