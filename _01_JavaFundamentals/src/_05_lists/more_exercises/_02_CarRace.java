package _05_lists.more_exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_CarRace {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> numbers = Arrays	.stream(scanner	.nextLine()
														.split(" "))
										.map(Integer::parseInt)
										.collect(Collectors.toList());

		scanner.close();

		int middleIndex = numbers.size() / 2;
		double leftCarTime = 0;
		double rightCarTime = 0;

		int i, j;
		for (i = 0, j = numbers.size() - 1; i < middleIndex; i++, j--) {
			leftCarTime = calculateTime(numbers, leftCarTime, i);
			rightCarTime = calculateTime(numbers, rightCarTime, j);
		}

		if (leftCarTime < rightCarTime) {
			System.out.printf("The winner is %s with total time: %.1f", "left", leftCarTime);
		} else {
			System.out.printf("The winner is %s with total time: %.1f", "right", rightCarTime);
		}
	}

	private static double calculateTime(List<Integer> numbers, double carTime, int index) {
		if (numbers.get(index) == 0) {
			carTime = carTime - (carTime * 0.2);
		}

		carTime += numbers.get(index);
		return carTime;
	}
}
