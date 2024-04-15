package _02_dt_and_variables.exercise;

import java.util.Scanner;

public class _11_Snowballs {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int numberOfSnowballs = scanner.nextInt();

		int bestSnowballSnow = 0;
		int bestSnowballTime = 0;
		int bestSnowballQuality = 0;

		long bestSnowballValue = 0L;

		for (int i = 0; i < numberOfSnowballs; i++) {
			int snowballSnow = scanner.nextInt();
			int snowballTime = scanner.nextInt();
			int snowballQuality = scanner.nextInt();

			if ((snowballSnow > 0) && (snowballQuality > 0)) {
				long currentSnowballValue = (long) Math.pow((snowballSnow/snowballTime), snowballQuality);

				if (currentSnowballValue > bestSnowballValue) {
					bestSnowballValue = currentSnowballValue;
					bestSnowballSnow = snowballSnow;
					bestSnowballTime = snowballTime;
					bestSnowballQuality = snowballQuality;
				}
			}
		}

		scanner.close();

		System.out.printf("%d : %d = %d (%d)", bestSnowballSnow, bestSnowballTime, bestSnowballValue,
				bestSnowballQuality);
	}
}
