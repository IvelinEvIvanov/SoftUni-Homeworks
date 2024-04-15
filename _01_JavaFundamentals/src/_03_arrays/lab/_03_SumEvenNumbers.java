package _03_arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class _03_SumEvenNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
		int sum = 0;

		for (int num : numbers) {
			if (num % 2 == 0) {
				sum += num;
			}
		}

		scanner.close();

		System.out.println(sum);
	}
}
