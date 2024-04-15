package _02_dt_and_variables.exercise;

import java.util.Scanner;

public class _07_WaterOverflow {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		final int tankCapacity = 255;
		int tank = 0;

		for (int i = 0; i < n; i++) {
			int littersOfWatter = scanner.nextInt();
			tank += littersOfWatter;
			
			if (tank > tankCapacity) {
				System.out.println("Insufficient capacity!");
				tank -= littersOfWatter;
			}
		}
		scanner.close();

		System.out.println(tank);
	}
}
