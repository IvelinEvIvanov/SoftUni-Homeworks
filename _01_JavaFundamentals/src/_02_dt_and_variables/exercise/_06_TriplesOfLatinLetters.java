package _02_dt_and_variables.exercise;

import java.util.Scanner;

public class _06_TriplesOfLatinLetters {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					char firstChar = (char) ('a' + i);
					char secondChar = (char) ('a' + j);
					char thirdChar = (char) ('a' + k);

					System.out.printf("%c%c%c%n", firstChar, secondChar, thirdChar);
				}
			}
		}
	}
}
