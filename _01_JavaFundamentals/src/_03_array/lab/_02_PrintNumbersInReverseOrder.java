package _03_array.lab;

import java.util.Scanner;

public class _02_PrintNumbersInReverseOrder {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());
		int[] numbers = new int[n];

		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(scanner.nextLine());
			numbers[i] = number;
		}

		// Print the elements from the last to the first
		for (int i = n - 1; i >= 0; i--) {
			System.out.print(numbers[i] + " ");
		}

		scanner.close();

		System.out.println();
	}
}
