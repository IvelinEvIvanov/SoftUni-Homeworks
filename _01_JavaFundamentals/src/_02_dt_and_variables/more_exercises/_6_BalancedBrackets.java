package _02_dt_and_variables.more_exercises;

import java.util.Scanner;

public class _6_BalancedBrackets {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < n; i++) {
			String line = scanner.nextLine();

			if (line.equals("(")) {
				String nextLine = scanner.nextLine();
				i++;

				while (i < n) {
					if (nextLine.equals("(")) {
						System.out.println("UNBALANCED");
						return;
					}
					if (nextLine.equals(")")) {
						break;
					}
					nextLine = scanner.nextLine();
					i++;
				}
			}

			if (line.equals(")")) {
				System.out.println("UNBALANCED");
				return;
			}
		}

		scanner.close();

		System.out.println("BALANCED");
	}
}
