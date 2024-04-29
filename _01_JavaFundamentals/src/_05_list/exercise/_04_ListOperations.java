package _05_list.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04_ListOperations {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> numberList = Arrays	.stream(scanner	.nextLine()
															.split(" "))
											.map(Integer::parseInt)
											.collect(Collectors.toList());

		while (true) {
			String line = scanner.nextLine();
			if (line.equals("End")) {
				break;
			}

			String[] tokens = line.split("\\s+");

			Integer number = 0;
			int index = 0;
			int numberListSize = numberList.size();

			switch (tokens[0]) {
			case "Add":
				number = Integer.parseInt(tokens[1]);
				numberList.add(number);
				break;
			case "Insert":
				number = Integer.parseInt(tokens[1]);
				index = Integer.parseInt(tokens[2]);

				if (isInvalidIndex(index, numberListSize)) {
					System.out.println("Invalid index");
					break;
				}

				numberList.add(index, number);
				break;
			case "Remove":
				index = Integer.parseInt(tokens[1]);

				if (isInvalidIndex(index, numberListSize)) {
					System.out.println("Invalid index");
					break;
				}

				numberList.remove(index);
				break;
			case "Shift":
				String shiftDirection = tokens[1];
				int count = Integer.parseInt(tokens[2]);
				Integer removedNumber = 0;

				if (shiftDirection.equals("left")) {
					for (int i = 0; i < count; i++) {
						removedNumber = numberList.remove(0);
						numberList.add(removedNumber);
					}
				} else if (shiftDirection.equals("right")) {
					for (int i = 0; i < count; i++) {
						removedNumber = numberList.remove(numberList.size() - 1);
						numberList.add(0, removedNumber);
					}
				}

				break;

			}
		}

		scanner.close();

		System.out.println(numberList	.toString()
										.replaceAll("[\\[\\],]", ""));
	}

	private static boolean isInvalidIndex(int index, int listSize) {
		if (index < 0 || index >= listSize) {
			return true;
		}

		return false;
	}
}
