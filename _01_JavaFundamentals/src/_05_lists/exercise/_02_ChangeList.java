package _05_lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_ChangeList {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> numbers = Arrays	.stream(scanner	.nextLine()
														.split("\\s+"))
										.map(Integer::parseInt)
										.collect(Collectors.toList());

		while (true) {
			String line = scanner.nextLine();
			if (line.equals("end")) {
				break;
			}

			String[] tokens = line.split("\\s+");
			Integer element = 0;

			switch (tokens[0]) {
			case "Delete":
				element = Integer.parseInt(tokens[1]);

				while (numbers.contains(element)) {
					numbers.remove(element);
				}

				break;

			case "Insert":
				element = Integer.parseInt(tokens[1]);
				int positon = Integer.parseInt(tokens[2]);

				numbers.add(positon, element);
				break;
			}
		}

		scanner.close();

		System.out.println(numbers	.toString()
									.replaceAll("[\\[\\],]", ""));
	}
}
