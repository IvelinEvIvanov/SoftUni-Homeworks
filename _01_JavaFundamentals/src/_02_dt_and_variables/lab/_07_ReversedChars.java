package _02_dt_and_variables.lab;

import java.util.Scanner;

public class _07_ReversedChars {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		char firstChar = scanner.nextLine().charAt(0);
		char secondChar = scanner.nextLine().charAt(0);
		char thirdChar = scanner.nextLine().charAt(0);

		scanner.close();

		System.out.printf("%c %c %c", thirdChar, secondChar, firstChar);
	}
}
