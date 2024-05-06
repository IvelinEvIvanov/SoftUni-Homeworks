package _07_associative_arrays.exercise._09_ForceBook;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();

		Map<String, ForceSide> treeMap = new TreeMap<String, ForceSide>();

		while (!line.equals("Lumpawaroo")) {
			String user = "";
			String side = "";
			String[] tokens = null;

			if (line.contains("|")) {
				tokens = line.split(" \\| ");
				side = tokens[0];
				user = tokens[1];

				ForceSide existedForeUser = treeMap.putIfAbsent(side, new ForceSide(side, user));
				if (existedForeUser != null) {
					existedForeUser.addForceUser(user);
				}

			} else if (line.contains("->")) {
				tokens = line.split(" -> ");
				user = tokens[0];
				side = tokens[1];

				boolean forceUserExist = false;

				for (Entry<String, ForceSide> entry : treeMap.entrySet()) {
					ForceSide forceUser = entry.getValue();

					forceUserExist = forceUser.isForceUserExist(user);
					if (forceUserExist) {
						forceUser.removeForceUser(user);

						treeMap	.get(side)
								.addForceUser(user);
						System.out.printf("%s joins the %s side!%n", user, side);
						break;
					}
				}

				if (!forceUserExist) {
					treeMap	.get(side)
							.addForceUser(user);

					System.out.printf("%s joins the %s side!%n", user, side);
				}
			}

			line = scanner.nextLine();
		}

		scanner.close();

		// Sort by Members Count and then by SideName
		Stream<Entry<String, ForceSide>> sorted = treeMap	.entrySet()
															.stream()
															.sorted((a1, a2) -> {
																ForceSide fs1 = a1.getValue();
																ForceSide fs2 = a2.getValue();
																int result = fs2.getUsersCount() - fs1.getUsersCount();

																if (result == 0) {
																	result = fs1.getSideName()
																				.compareTo(fs2.getSideName());
																}

																return result;
															});

		sorted.forEach(entry -> {

			// Sort Users by name
			Collections.sort(entry	.getValue()
									.getForceUsers(),
								(user1, user2) -> user1.compareTo(user2));

			if (entry	.getValue()
						.getUsersCount() > 0) {
				System.out.println(entry.getValue()
										.toString());
			}
		});
	}
}
