package _05_lists.more_exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05_DrumSet {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double savings = Double.parseDouble(scanner.nextLine());
		List<Integer> initialDrumSets = Arrays	.stream(scanner	.nextLine()
																.split("\\s+"))
												.map(Integer::parseInt)
												.collect(Collectors.toList());

		List<Integer> beatenDrumSets = new ArrayList<>(initialDrumSets);

		while (true) {
			String command = scanner.nextLine();
			if (command.equals("Hit it again, Gabsy!")) {
				break;
			}

			Integer hitPower = Integer.parseInt(command);

			if (hitPower > 0 && hitPower < 1000) {
				for (int i = 0; i < initialDrumSets.size(); i++) {
					Integer drumQuality = beatenDrumSets.get(i) - hitPower;

					if (drumQuality <= 0) {
						Integer intialQuality = initialDrumSets.get(i);
						savings -= (intialQuality * 3);

						if (savings < 0) {
							beatenDrumSets.remove(i);
							initialDrumSets.remove(i--);
							savings += (intialQuality * 3);
						} else {
							beatenDrumSets.set(i, intialQuality);
						}
					} else {
						beatenDrumSets.set(i, drumQuality);
					}

				}
			}
		}

		scanner.close();

		if (beatenDrumSets.size() > 0) {
			beatenDrumSets.forEach(e -> System.out.print(e + " "));
		}
		System.out.println();

		System.out.printf("Gabsy has %.2flv.", savings);
	}
}
