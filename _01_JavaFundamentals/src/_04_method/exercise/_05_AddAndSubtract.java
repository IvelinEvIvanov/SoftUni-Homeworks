package _04_method.exercise;

import java.util.Scanner;

public class _05_AddAndSubtract {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		scanner.close();

		int sum = sumIntegers(a, b);
		int result = substractInteger(sum, c);
		System.out.println(result);

	}

	private static int substractInteger(int sum, int c) {
		return sum - c;
	}

	private static int sumIntegers(int a, int b) {
		return a + b;
	}
}
