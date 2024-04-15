package _02_dt_and_variables.more_exercises;

import java.util.Scanner;

public class _3_FloatingEquality {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double d1 = Double.parseDouble(scanner.nextLine());
		double d2 = Double.parseDouble(scanner.nextLine());
		double esp = 0.000001;

		d1 = Math.abs(d1);
		d2 = Math.abs(d2);

		int result = Double.compare(d1, d2);
		if (result == 1) {
			if ((d1 - d2) > esp) {
				System.out.println("False");
			} else if ((d1 - d2) <= esp) {
				System.out.println("True");
			}
		} else if (result == -1) {
			if ((d2 - d1) > esp) {
				System.out.println("False");
			} else if ((d2 - d1) <= esp) {
				System.out.println("True");
			}
		} else if (result == 0) {
			if ((d1 - d2) > esp) {
				System.out.println("False");
			} else if ((d1 - d2) <= esp) {
				System.out.println("True");
			}
		}

		scanner.close();
	}
}
