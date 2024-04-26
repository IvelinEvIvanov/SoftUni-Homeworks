package _05_lists.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _09_PokemonDontGo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> numbers = Arrays	.stream(scanner	.nextLine()
														.split("\\s+"))
										.map(Integer::parseInt)
										.collect(Collectors.toList());

		List<Integer> removedNumbers = new ArrayList<>();

		while (true) {
			int index = Integer.parseInt(scanner.nextLine());
			int lastIndex = numbers.size() - 1;
			Integer removedNumber = null;

			if (lastIndex == 0) {
				removedNumber = numbers.remove(0);
				removedNumbers.add(removedNumber);
				break;
			}

			if (index < 0) {
				Integer lastNumber = numbers.get(lastIndex);
				removedNumber = numbers.remove(0);
				numbers.add(0, lastNumber);

				updateNumbers(numbers, removedNumber);

				removedNumbers.add(removedNumber);
			} else if (index > lastIndex) {
				Integer firstNumber = numbers.get(0);
				removedNumber = numbers.remove(lastIndex);
				numbers.add(firstNumber);

				updateNumbers(numbers, removedNumber);

				removedNumbers.add(removedNumber);
			} else {
				removedNumber = numbers.remove(index);
				updateNumbers(numbers, removedNumber);
				
				removedNumbers.add(removedNumber);
			}
		}

		scanner.close();

		int sum = 0;
		for (Integer number : removedNumbers) {
			sum += number;
		}

		System.out.println(sum);
	}

	private static void updateNumbers(List<Integer> numbers, Integer removedNumber) {
		int index = 0;
		Integer updatedNumber = null;

		for (Integer number : numbers) {
			if (number <= removedNumber) {
				updatedNumber = number + removedNumber;
				numbers.set(index++, updatedNumber);
			} else {
				updatedNumber = number - removedNumber;
				numbers.set(index++, updatedNumber);
			}
		}
	}
}
