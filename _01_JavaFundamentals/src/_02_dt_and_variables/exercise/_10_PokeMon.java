package _02_dt_and_variables.exercise;

import java.util.Scanner;

public class _10_PokeMon {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int pokePowerN = scanner.nextInt();
		int targetDistanceM = scanner.nextInt();
		int exhaustionFactorY = scanner.nextInt();

		int originalValue = pokePowerN;
		int totalPoked = 0;

		while (pokePowerN >= targetDistanceM) {
			pokePowerN -= targetDistanceM;
			totalPoked++;

			if (exhaustionFactorY > 1 && (((double) originalValue / pokePowerN) == 2)) {
				pokePowerN = pokePowerN / exhaustionFactorY;
			}
		}

		scanner.close();

		System.out.printf("%d%n%d%n", pokePowerN, totalPoked);
	}
}
