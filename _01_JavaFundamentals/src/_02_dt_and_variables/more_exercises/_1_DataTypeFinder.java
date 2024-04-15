package _02_dt_and_variables.more_exercises;

import java.util.Scanner;

public class _1_DataTypeFinder {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = "";

		while (!input.equals("END")) {
			input = scanner.nextLine();

			if (scanner.hasNextInt()) {
				System.out.println(input + " is integer type");
			} else if (scanner.hasNextFloat()) {
				System.out.println(input + " is floating point type");
			} else if (scanner.hasNextDouble()) {
				System.out.println(input + " is floating point type");
			} else if (scanner.hasNextBoolean()) {
				System.out.println(input + " is boolean type");
			} else if (input.length() == 1) {
				System.out.println(input + " is character type");
			} else if (scanner.hasNextLine()) {
				System.out.println(input + " is string type");
			}
		}
		
		scanner.close();
	}

}
