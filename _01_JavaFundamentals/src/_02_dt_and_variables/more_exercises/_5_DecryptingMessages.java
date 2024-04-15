package _02_dt_and_variables.more_exercises;

import java.util.Scanner;

public class _5_DecryptingMessages {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int key = Integer.parseInt(scanner.nextLine());
		int lines = Integer.parseInt(scanner.nextLine());
		char[] letters = new char[lines];
		
		for (int i = 0; i < lines; i++) {
			letters[i] = scanner.nextLine().charAt(0);
		}

		for (int i = 0; i < letters.length; i++) {
			System.out.print((char) (letters[i] + key));
		}

		scanner.close();
	}
}
