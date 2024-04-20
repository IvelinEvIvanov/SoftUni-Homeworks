package _04_methods.exercise;

import java.util.Scanner;

public class _06_MiddleCharacters {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		scanner.close();

		int strLen = str.length();
		if (strLen % 2 != 0) {
			System.out.println(getMiddleOddChar(str, strLen));
		} else {
			System.out.println(getMiddleEvenChars(str, strLen));
		}
	}

	private static String getMiddleEvenChars(String str, int strLen) {
		int middle = strLen / 2;
		String result = "" + str.charAt(middle - 1);
		result += str.charAt(middle);

		return result;
	}

	private static String getMiddleOddChar(String str, int len) {
		int middle = len / 2;
		return "" + str.charAt(middle);
	}
}
