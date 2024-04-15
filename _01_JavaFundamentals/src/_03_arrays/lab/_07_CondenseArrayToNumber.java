package _03_arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class _07_CondenseArrayToNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] numbers = Arrays	.stream(scanner	.nextLine()
												.split(" "))
								.mapToInt(e -> Integer.parseInt(e))
								.toArray();

		int arrLastIndex = numbers.length - 1;
		int[] condensed = new int[arrLastIndex];

		for (int i = 0; i < arrLastIndex; i++) {
			for (int j = 0; j < arrLastIndex - i; j++) {
				condensed[j] = numbers[j] + numbers[j + 1];
			}
			
			numbers = condensed;
		}

		scanner.close();

		System.out.println(numbers[0]);
	}
}
