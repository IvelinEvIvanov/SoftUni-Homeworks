package _04_methods.exercise;

import java.util.Scanner;

public class _03_CharactersInRange {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char charA = scanner.nextLine()
							.charAt(0);
		char charB = scanner.nextLine()
							.charAt(0);
		scanner.close();

		String result = getCharactersRange(charA, charB);

		System.out.println(result);
	}

	private static String getCharactersRange(char charA, char charB) {
		String result = "";
		if (charA < charB) {
			while (++charA < charB) {
				result += charA + " ";
			}
		} else {
			while (++charB < charA) {
				result += charB + " ";
			}
		}

		return result;
	}
}
