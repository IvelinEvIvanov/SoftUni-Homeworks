package _05_list.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_Train {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> wagons = Arrays	.stream(scanner	.nextLine()
														.split(" "))
										.map(Integer::parseInt)
										.collect(Collectors.toList());

		int wagonMaxCapacity = Integer.parseInt(scanner.nextLine());

		while (true) {
			String line = scanner.nextLine();
			if (line.equals("end")) {
				break;
			}

			String[] tokens = line.split(" ");

			switch (tokens[0]) {
			case "Add":
				int wagonWithPassengers = Integer.parseInt(tokens[1]);
				wagons.add(wagonWithPassengers);
				break;
			default: {
				int passengers = Integer.parseInt(tokens[0]);

				for (int i = 0; i < wagons.size(); i++) {
					int currentWagon = wagons.get(i);
					currentWagon += passengers;

					if (currentWagon <= wagonMaxCapacity) {
						wagons.set(i, currentWagon);
						break;
					}
				}

				break;
			}
			}

		}

		scanner.close();

		System.out.println(wagons	.toString()
									.replaceAll("[\\[\\],]", ""));

	}
}
