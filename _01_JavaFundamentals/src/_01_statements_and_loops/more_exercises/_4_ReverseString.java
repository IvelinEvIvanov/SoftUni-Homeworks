package _01_statements_and_loops.more_exercises;

import java.util.Scanner;

public class _4_ReverseString {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String text = scan.nextLine();
		for (int i = text.length() - 1; i >= 0; i--) {
			System.out.print(text.charAt(i));
		}

		scan.close();
	}

}
