package _04_method.exercise;

import java.util.Scanner;

public class _08_FactorialDivision {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		scanner.close();

		double factorialA = getFactorial(a);
		double factorialB = getFactorial(b);

		double division = factorialA / factorialB;

		System.out.printf("%.2f", division);
	}

	private static long getFactorial(int num) {
		long factorial = 1;

		for (int i = 1; i <= num; i++) {
			factorial *= i;
		}

		return factorial;
	}
}
