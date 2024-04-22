package _05_lists.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05_ListManipulationAdvanced {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> numbers = Arrays	.stream(scanner	.nextLine()
														.split(" "))
										.map(Integer::parseInt)
										.collect(Collectors.toList());

		while (true) {
			String line = scanner.nextLine();

			if (line.equals("end")) {
				break;
			}

			String[] tokens = line.split(" ");
			int commandNum = 0;

			switch (tokens[0]) {

			case "Contains":
				commandNum = Integer.parseInt(tokens[1]);
				if (numbers.contains(commandNum)) {
					System.out.println("Yes");
				} else {
					System.out.println("No such number");
				}
				break;

			case "Print":
				String commandStr = tokens[1];

				if (commandStr.equals("even")) {
					printOddOrEven("even", numbers);
				} else if (commandStr.equals("odd")) {
					printOddOrEven("odd", numbers);
				}
				break;

			case "Get":
				int sum = 0;
				for (Integer num : numbers) {
					sum += num;
				}
				System.out.println(sum);
				break;

			case "Filter":
				String condition = tokens[1];
				commandNum = Integer.parseInt(tokens[2]);
				printFilteredList(condition, commandNum, numbers);
				break;
			}
		}

		scanner.close();

	}

	private static void printFilteredList(String condition, int num, List<Integer> numbers) {
		for (Integer number : numbers) {

			switch (condition) {

			case ">":
				if (number > num) {
					System.out.print(number + " ");
				}
				break;

			case ">=":
				if (number >= num) {
					System.out.print(number + " ");
				}
				break;

			case "<":
				if (number < num) {
					System.out.print(number + " ");
				}
				break;

			case "<=":
				if (number <= num) {
					System.out.print(number + " ");
				}
				break;
			}
		}

		System.out.println();
	}

	private static void printOddOrEven(String evenOrOdd, List<Integer> numbers) {
		for (Integer num : numbers) {

			switch (evenOrOdd) {
			case "even":
				if (num % 2 == 0) {
					System.out.print(num + " ");
				}
				break;

			case "odd":
				if (num % 2 != 0) {
					System.out.print(num + " ");
				}
				break;

			}
		}
		System.out.println();
	}
}
