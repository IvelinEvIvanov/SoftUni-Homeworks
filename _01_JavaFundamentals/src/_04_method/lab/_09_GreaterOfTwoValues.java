package _04_method.lab;

import java.util.Scanner;

public class _09_GreaterOfTwoValues {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String argType = scanner.nextLine();

		Object first, second, result = null;
		
		if (argType.equals("int")) {

			first = Integer.parseInt(scanner.nextLine());
			second = Integer.parseInt(scanner.nextLine());

			result = getMax((int) first, (int) second);
			System.out.println(result);
		} else if (argType.equals("char")) {

			first = scanner	.nextLine()
							.charAt(0);
			second = scanner.nextLine()
							.charAt(0);

			result = getMax((char) first, (char) second);
			System.out.println(result);
		} else if (argType.equals("string")) {

			first = scanner.nextLine();
			second = scanner.nextLine();

			result = getMax((String) first, (String) second);
			System.out.println(result);
		}
		scanner.close();
	}

	private static String getMax(String first, String second) {
		if (first.compareTo(second) >= 0) {
			return first;
		}

		return second;
	}

	private static char getMax(char first, char second) {
		if (first > second) {
			return first;
		}

		return second;
	}

	private static int getMax(int first, int second) {
		if (first > second) {
			return first;
		}

		return second;
	}
}
