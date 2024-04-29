package _04_method.exercise;

import java.util.Scanner;

public class _04_PasswordValidator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String password = scanner.nextLine();
		scanner.close();

		String message = validatePassword(password);
		System.out.println(message);
	}

	private static String validatePassword(String password) {
		String result = "";
		boolean has6To10Chars = hasBetween6And10Chars(password);
		boolean hasLettersAndDigits = hasOnlyLettersAndDigits(password);
		boolean hasTwoDigits = hasLeast2Digits(password);

		if (has6To10Chars && hasLettersAndDigits && hasTwoDigits) {
			return "Password is valid";
		}

		if (!has6To10Chars) {
			result += "Password must be between 6 and 10 characters\n";
		}

		if (!hasLettersAndDigits) {
			result += "Password must consist only of letters and digits\n";
		}

		if (!hasTwoDigits) {
			result += "Password must have at least 2 digits\n";
		}

		return result;
	}

	private static boolean hasLeast2Digits(String password) {
		int count = 0;
		for (int i = 0; i < password.length(); i++) {
			char nextChar = password.charAt(i);

			if (Character.isDigit(nextChar) == true) {
				count++;
			}

			if (count == 2) {
				return true;
			}
		}

		return false;
	}

	private static boolean hasOnlyLettersAndDigits(String password) {
		for (int i = 0; i < password.length(); i++) {
			char nextChar = password.charAt(i);
			if (Character.isLetterOrDigit(nextChar) == false) {
				return false;
			}
		}
		return true;
	}

	private static boolean hasBetween6And10Chars(String password) {
		if (password.length() >= 6 && password.length() <= 10) {
			return true;
		}
		return false;
	}
}
