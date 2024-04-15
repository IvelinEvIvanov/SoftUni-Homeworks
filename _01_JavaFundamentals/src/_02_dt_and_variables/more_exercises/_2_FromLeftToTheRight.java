package _02_dt_and_variables.more_exercises;

import java.math.BigInteger;
import java.util.Scanner;

public class _2_FromLeftToTheRight {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());

		BigInteger number1 = null;
		BigInteger number2 = null;
		BigInteger sum = new BigInteger("0");
		String[] numbers = null;

		for (int i = 0; i < n; i++) {
			numbers = scanner.nextLine().split(" ");

			number1 = new BigInteger(numbers[0]);
			number2 = new BigInteger(numbers[1]);
			int result = number1.compareTo(number2);

			if (result == 1 || result == 0) {
				number1 = number1.abs();

				while (!number1.equals(BigInteger.valueOf(0))) {
					sum = sum.add(number1.remainder(BigInteger.valueOf(10)));
					number1 = number1.divide(BigInteger.valueOf(10));
				}
			} else if (result == -1) {
				number2 = number2.abs();

				while (!number2.equals(BigInteger.valueOf(0))) {
					sum = sum.add(number2.remainder(BigInteger.valueOf(10)));
					number2 = number2.divide(BigInteger.valueOf(10));
				}
			}

			System.out.println(sum.toString());
			sum = BigInteger.valueOf(0);
		}

		scanner.close();
	}
}
