package _04_method.more_exercises;

import java.util.Scanner;

public class _01_DataTypes {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String type = scanner.nextLine();
		String value = scanner.nextLine();
		scanner.close();

		if (type.equals("int")) {
			printValue(Integer.parseInt(value));
		} else if (type.equals("real")) {
			printValue(Double.parseDouble(value));
		} else if (type.equals("string")) {
			printValue(value);
		}
	}

	private static void printValue(int value) {
		System.out.println(value * 2);
	}

	private static void printValue(double value) {
		System.out.printf("%.2f", value * 1.5);
	}

	private static void printValue(String value) {
		System.out.printf("$%s$", value);
	}
}
