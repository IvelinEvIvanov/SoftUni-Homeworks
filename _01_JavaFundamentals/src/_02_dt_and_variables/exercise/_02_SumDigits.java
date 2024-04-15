package _02_dt_and_variables.exercise;

import java.util.Scanner;

public class _02_SumDigits {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String number = scanner.nextLine();
		int result = 0;

		for (int i = 0; i < number.length(); i++) {
			result += Integer.parseInt("" + number.charAt(i));
		}

		scanner.close();

		System.out.println(result);
	}
}
