package _04_method.exercise;

import java.util.Scanner;

public class _01_SmallestOfThreeNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] numbers = new int[3];
		numbers[0] = scanner.nextInt();
		numbers[1] = scanner.nextInt();
		numbers[2] = scanner.nextInt();
		scanner.close();

		int smallestNumber = getSmallestNumber(numbers);
		System.out.println(smallestNumber);
	}

	private static int getSmallestNumber(int[] numbers) {
		int minNumber = Integer.MAX_VALUE;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < minNumber) {
				minNumber = numbers[i];
			}
		}

		return minNumber;
	}
}
