package _04_methods.exercise;

import java.util.Scanner;

public class _10_TopNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		scanner.close();

		printTopNumbers(num);
	}

	private static void printTopNumbers(int number) {
		int len = number;
		for (int currNum = 1; currNum <= len; currNum++) {
			if (hasOddDigit(currNum) && isDevisibleBy8(currNum)) {
				System.out.println(currNum);
			}
		}
	}

	private static boolean isDevisibleBy8(int num) {
		int sum = 0;
		while (num != 0) {
			int lastDigit = num % 10;
			num /= 10;
			sum += lastDigit;
		}

		if (sum % 8 == 0) {
			return true;
		}

		return false;
	}

	private static boolean hasOddDigit(int num) {
		while (num != 0) {
			int lastDigit = num % 10;

			if (lastDigit % 2 != 0) {
				return true;
			}

			num /= 10;
		}
		return false;
	}
}
