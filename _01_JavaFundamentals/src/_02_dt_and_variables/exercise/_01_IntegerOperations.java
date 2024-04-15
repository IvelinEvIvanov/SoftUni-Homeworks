package _02_dt_and_variables.exercise;

import java.util.Scanner;

public class _01_IntegerOperations {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int result = scanner.nextInt();

		for (int i = 1; i <= 3; i++) {
			int number = scanner.nextInt();

			if (i == 2) {
				result = result / number;
			} else if (i == 3) {
				result = result * number;
			} else {
				result += number;
			}
		}

		System.out.println(result);

		scanner.close();
	}
}
