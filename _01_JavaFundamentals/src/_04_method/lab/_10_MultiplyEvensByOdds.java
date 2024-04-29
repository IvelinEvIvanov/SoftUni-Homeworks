package _04_method.lab;

import java.util.Scanner;

public class _10_MultiplyEvensByOdds {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = Integer.parseInt(scanner.nextLine());
		number = Math.abs(number);
		scanner.close();

		int sum = getMultipleOfEvensAndOdds(number);
		System.out.println(sum);
	}

	private static int getMultipleOfEvensAndOdds(int number) {
		int evenSum = getEvenSum(number);
		int oddSum = getOddSum(number);
		return evenSum * oddSum;
	}

	private static int getOddSum(int number) {
		int sum = 0;

		while (number != 0) {
			int lastNumber = number % 10;
			number /= 10;
			if (lastNumber % 2 != 0) {
				sum += lastNumber;
			}
		}

		return sum;
	}

	private static int getEvenSum(int number) {
		int sum = 0;

		while (number != 0) {
			int lastNumber = number % 10;
			number /= 10;
			if (lastNumber % 2 == 0) {
				sum += lastNumber;
			}
		}

		return sum;
	}
}
