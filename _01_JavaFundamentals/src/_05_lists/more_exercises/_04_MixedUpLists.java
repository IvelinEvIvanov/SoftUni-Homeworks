package _05_lists.more_exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04_MixedUpLists {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> numbersOne = Arrays	.stream(scanner	.nextLine()
															.split(" "))
											.map(Integer::parseInt)
											.collect(Collectors.toList());

		List<Integer> numbersTwo = Arrays	.stream(scanner	.nextLine()
															.split(" "))
											.map(Integer::parseInt)
											.collect(Collectors.toList());
		scanner.close();

		int minLength = numbersOne.size();
		int secondListLength = numbersTwo.size();

		int[] lastTwoNumbers = new int[2];

		if (minLength > secondListLength) {
			lastTwoNumbers[0] = numbersOne.remove(minLength - 1);
			lastTwoNumbers[1] = numbersOne.remove(minLength - 2);

			minLength = secondListLength;
		} else {
			lastTwoNumbers[0] = numbersTwo.remove(0);
			lastTwoNumbers[1] = numbersTwo.remove(0);
		}

		List<Integer> mixedList = new ArrayList<>();

		for (int i = 0; i < minLength; i++) {
			Integer numberOne = numbersOne.get(i);
			Integer numberTwo = numbersTwo.get(i);

			mixedList.add(numberOne);
			mixedList.add(numberTwo);
		}

		Arrays.sort(lastTwoNumbers);

		List<Integer> resultList = new ArrayList<>();

		for (Integer number : mixedList) {
			if ((number > lastTwoNumbers[0]) && (number < lastTwoNumbers[1])) {
				resultList.add(number);
			}
		}

		Collections.sort(resultList);

		resultList.forEach(number -> System.out.print(number + " "));

	}
}
