package _04_methods.lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class _11_MathOperations {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = Integer.parseInt(scanner.nextLine());
		String operator = scanner.nextLine();
		int b = Integer.parseInt(scanner.nextLine());
		scanner.close();

		double result = calculate(a, operator, b);
		System.out.println(new DecimalFormat("0.##").format(result));
	}

	private static double calculate(int a, String operator, int b) {
		switch (operator) {
		case "+":
			return a + b;
		case "-":
			return a - b;
		case "*":
			return a * b;
		case "/":
			return a / b;
		}

		return 0.0;
	}
}
