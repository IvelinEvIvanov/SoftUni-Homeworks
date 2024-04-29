package _04_method.exercise;

import java.util.Scanner;

public class _09_PalindromeIntegers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			String num = scanner.nextLine();

			if (num.equals("END")) {
				break;
			}

			String reversedNum = reverseNum(num);

			if (reversedNum.equals(num)) {
				System.out.println(true);
			} else {
				System.out.println(false);
			}
		}

		scanner.close();
	}

	private static String reverseNum(String num) {
		String reversedNum = "";
		for (int i = num.length() - 1; i >= 0; i--) {
			reversedNum += num.charAt(i);
		}
		return reversedNum;
	}
}
