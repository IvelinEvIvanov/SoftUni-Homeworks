package _05_list.exercise;

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

			for (int iLeft = specialNumberIndex; iLeft >= (specialNumberIndex - power) && (iLeft >= 0); iLeft--) {
				numbers.set(iLeft, -1);
			}

			for (int iRight = specialNumberIndex; iRight <= (specialNumberIndex + power)
					&& (iRight <= numbers.size() - 1); iRight++) {
				numbers.set(iRight, -1);
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
