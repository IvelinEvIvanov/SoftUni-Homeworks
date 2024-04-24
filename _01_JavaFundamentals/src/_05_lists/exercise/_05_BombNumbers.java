package _05_lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05_BombNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> numbers = Arrays	.stream(scanner	.nextLine()
														.split(" "))
										.map(Integer::parseInt)
										.collect(Collectors.toList());

		Integer specialNumber = scanner.nextInt();
		int power = scanner.nextInt();
		scanner.close();

		while (true) {
			int specialNumberIndex = numbers.indexOf(specialNumber);
			if (specialNumberIndex == -1) {
				break;
			}

			for (int left = specialNumberIndex; left >= (specialNumberIndex - power) && (left >= 0); left--) {
				numbers.set(left, -1);
			}

			for (int right = specialNumberIndex; right <= (specialNumberIndex + power)
					&& (right <= numbers.size() - 1); right++) {
				numbers.set(right, -1);
			}
		}

		int sum = 0;
		for (Integer number : numbers) {
			if (number != -1) {
				sum += number;
			}
		}

		System.out.println(sum);
	}
}
