package _07_associative_arrays.more_exercises;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Map.Entry;

public class _2_Judge {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<String, Map<String, Integer>> contestMap = new LinkedHashMap<>();
		String input = scanner.nextLine();
		while (!input.equals("no more time")) {
			String[] tokens = input.split("\\s*->\\s*");

			String username = tokens[0];
			String contest = tokens[1];
			Integer points = Integer.parseInt(tokens[2]);

			Map<String, Integer> usernamePoints = new HashMap<String, Integer>();
			if (!contestMap.containsKey(contest)) {
				usernamePoints.put(username, points);
				contestMap.put(contest, usernamePoints);
			} else {
				if (contestMap	.get(contest)
								.containsKey(username)) {
					if (points > contestMap	.get(contest)
											.get(username)) {
						contestMap	.get(contest)
									.put(username, points);
					}
				} else {
					Integer cuurentPoint = contestMap	.get(contest)
														.get(username);
					contestMap	.get(contest)
								.put(username, points);
				}
			}

			input = scanner.nextLine();
		}

		Comparator<Entry<String, Integer>> comparator = (o1, o2) -> {
			int n = o2	.getValue()
						.compareTo(o1.getValue());
			if (n == 0) {
				return o1	.getKey()
							.compareTo(o2.getKey());
			} else {
				return n;
			}
		};

		Integer participantsCount = 0;
		int i = 0;
		for (Entry<String, Map<String, Integer>> entry : contestMap.entrySet()) {
			participantsCount = entry	.getValue()
										.size();
			System.out.printf("%s: %d participants%n", entry.getKey(), participantsCount);

			Map<String, Integer> sortedUsers = entry.getValue()
													.entrySet()
													.stream()
													.sorted(comparator)
													.collect(Collectors.toMap(	e -> e.getKey(), e -> e.getValue(),
																				(e1, e2) -> e1, LinkedHashMap::new));

			for (Map.Entry<String, Integer> itr : sortedUsers.entrySet()) {
				System.out.println(++i + ". " + itr.getKey() + " <::> " + itr.getValue());
			}
			i = 0;
		}

		Map<String, Integer> standings = new HashMap<>();
		int sum = 0;
		for (Map.Entry<String, Map<String, Integer>> entry : contestMap.entrySet()) {

			for (Map.Entry<String, Integer> itr : entry	.getValue()
														.entrySet()) {
				if (!standings.containsKey(itr.getKey())) {
					standings.put(itr.getKey(), itr.getValue());
				} else {
					sum = standings.get(itr.getKey());
					standings.put(itr.getKey(), sum + itr.getValue());
				}
			}
		}

		System.out.println("Individual standings:");
		Map<String, Integer> result = standings	.entrySet()
												.stream()
												.sorted(comparator)
												.collect(Collectors.toMap(	e -> e.getKey(), e -> e.getValue(),
																			(e1, e2) -> e1, LinkedHashMap::new));

		int n = 0;
		for (Map.Entry<String, Integer> itr : result.entrySet()) {
			System.out.println(++n + ". " + itr.getKey() + " -> " + itr.getValue());
		}

	}
}
