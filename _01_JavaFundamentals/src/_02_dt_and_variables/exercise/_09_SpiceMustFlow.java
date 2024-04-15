package _02_dt_and_variables.exercise;

import java.util.Scanner;

public class _09_SpiceMustFlow {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int yieldDrop = 10;
		final int consumedSpices = 26;

		int startingYield = scanner.nextInt();
		int totalSpices = 0;
		int days = 0;

		while (startingYield >= 100) {
			totalSpices += (startingYield - consumedSpices);
			startingYield -= yieldDrop;
			days++;
		}

		if (days > 0) {
			totalSpices -= consumedSpices;
		}

		scanner.close();

		System.out.printf("%d%n%d%n", days, totalSpices);
	}
}
