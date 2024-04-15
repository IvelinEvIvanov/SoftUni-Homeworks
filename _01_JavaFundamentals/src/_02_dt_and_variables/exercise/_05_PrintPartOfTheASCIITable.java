package _02_dt_and_variables.exercise;

import java.util.Scanner;

public class _05_PrintPartOfTheASCIITable {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int nextCharIndex = Integer.parseInt(scanner.nextLine());
		int lastCharIndex = Integer.parseInt(scanner.nextLine());
		scanner.close();

		String result = "";

		for (; nextCharIndex <= lastCharIndex; nextCharIndex++) {
			result += (char) nextCharIndex;
			result += " ";
		}

		System.out.println(result.substring(0, result.length() - 1));
	}
}
