package _04_method.lab;

import java.util.Scanner;

public class _07_RepeatString {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		int n = Integer.parseInt(scanner.nextLine());
		scanner.close();

		String result = repeatString(input, n);
		System.out.println(result);
	}

	private static String repeatString(String str, int n) {
		String result = "";
		for (int i = 0; i < n; i++) {
			result += str;
		}

		return result;
	}
}
