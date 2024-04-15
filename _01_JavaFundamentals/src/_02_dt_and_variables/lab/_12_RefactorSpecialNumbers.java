package _02_dt_and_variables.lab;

import java.util.Scanner;

public class _12_RefactorSpecialNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());
		int sumOfDigits = 0;
		int digits = 0;
		boolean isSpecialNum = false;

		for (int num = 1; num <= n; num++) {
			digits = num;
			while (num > 0) {
				sumOfDigits += num % 10;
				num = num / 10;
			}

			isSpecialNum = (sumOfDigits == 5) || (sumOfDigits == 7) || (sumOfDigits == 11);
			System.out.printf("%d -> %b%n", digits, isSpecialNum);

			sumOfDigits = 0;
			num = digits;
		}

		scanner.close();
	}
}
