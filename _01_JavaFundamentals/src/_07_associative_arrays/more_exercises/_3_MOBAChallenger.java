package _07_associative_arrays.more_exercises;

import java.util.*;

public class _3_MOBAChallenger {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<String, Map<String, Integer>> playersMap = new HashMap<>();

		String input = scanner.nextLine();
		while (!input.equals("Season end")) {

			String[] tokensNewPlayer = input.split("\\s*->\\s*");
			String playerName = "";
			String playerPosition = "";
			Integer playerSkill = 0;
			if (tokensNewPlayer.length == 3) {
				playerName = tokensNewPlayer[0];
				playerPosition = tokensNewPlayer[1];
				playerSkill = Integer.parseInt(tokensNewPlayer[2]);
			}

			String[] tokensDuel = input.split("\\s*vs\\s*");
			String duelist1 = "";
			String duelist2 = "";
			if (tokensDuel.length == 2) {
				duelist1 = tokensDuel[0];
				duelist2 = tokensDuel[1];
			}

			if (tokensNewPlayer.length == 3) {
				Map<String, Integer> positionSkill = new HashMap<>();
				if (!playersMap.containsKey(playerName)) {
					positionSkill.put(playerPosition, playerSkill);
					playersMap.put(playerName, positionSkill);
				} else {
					if (playersMap	.get(playerName)
									.containsKey(playerPosition)) {
						Integer currentSkill = playersMap	.get(playerName)
															.get(playerPosition);
						if (playerSkill > currentSkill) {
							positionSkill.put(playerPosition, playerSkill);
							playersMap.put(playerName, positionSkill);
						}
					} else {
						playersMap	.get(playerName)
									.put(playerPosition, playerSkill);
					}

				}
			}

			if (tokensDuel.length == 2 && playersMap.size() > 1) {
				Map<String, Integer> duelist1Positions = playersMap.get(duelist1);
				Map<String, Integer> duelist2Positions = playersMap.get(duelist2);

				if (duelist1Positions != null && duelist2Positions != null) {
					boolean anyWinner = false;
					for (String itr1 : duelist1Positions.keySet()) {
						for (String itr2 : duelist2Positions.keySet()) {

							if (itr1.equals(itr2)) {
								if (duelist1Positions.get(itr1) > duelist2Positions.get(itr1)) {
									playersMap.remove(duelist2);
									anyWinner = true;
									break;
								} else if (duelist1Positions.get(itr1) < duelist2Positions.get(itr1)) {
									playersMap.remove(duelist1);
									anyWinner = true;
									break;
								}
							}

						}
						if (anyWinner) {
							break;
						}
					}
				}
			}

			input = scanner.nextLine();
		}

		scanner.close();

		// COMPARATOR
		Comparator<Map.Entry<String, Map<String, Integer>>> totalSkillComparator = (entry1, entry2) -> {
			Integer entry1Result = entry1	.getValue()
											.entrySet()
											.stream()
											.mapToInt(e -> e.getValue())
											.sum();
			
			Integer entry2Result = entry2	.getValue()
											.entrySet()
											.stream()
											.mapToInt(e -> e.getValue())
											.sum();

			int result = entry2Result.compareTo(entry1Result);
			if (result == 0) {
				return entry1	.getKey()
								.compareTo(entry2.getKey());
			} else {
				return result;
			}

		};

		playersMap	.entrySet()
					.stream()
					.sorted(totalSkillComparator)
					.forEach(entry -> {
						System.out.println(entry.getKey() + ": " + entry.getValue()
																		.values()
																		.stream()
																		.mapToInt(e -> e)
																		.sum()
								+ " skill");

						entry	.getValue()
								.entrySet()
								.stream()
								.sorted((e1, e2) -> {

									int n = Integer.compare(e2.getValue(), e1.getValue());
									if (n == 0) {
										return e1	.getKey()
													.compareTo(e2.getKey());
									} else {
										return n;
									}

								})
								.forEach(result -> {
									System.out.println("- " + result.getKey() + " <::> " + result.getValue());
								});

					});

	}
}
