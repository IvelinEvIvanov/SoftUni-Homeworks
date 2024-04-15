package _02_dt_and_variables.exercise;

import java.util.Scanner;

public class _04_SumOfChars {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int sum = 0;

		int n = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < n; i++) {
			String character = scanner.nextLine();
			sum += character.charAt(0);
		}

		System.out.println("The sum equals: " + sum);

		scanner.close();
	}
}
