package _06_class.more_exercises._02_RawData;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());

		Car[] cars = new Car[n];

		for (int i = 0; i < n; i++) {
			String[] tokens = scanner	.nextLine()
										.split("\\s+");

			Engine engi = new Engine(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
			Cargo cargo = new Cargo(Integer.parseInt(tokens[3]), tokens[4]);
			Tier[] tiers = new Tier[4];

			int t1 = 5;
			int t2 = 6;
			for (int j = 0; j < tiers.length; j++) {
				tiers[j] = new Tier(Double.parseDouble(tokens[t1]), Integer.parseInt(tokens[t2]));
				t1 += 2;
				t2 += 2;
			}

			cars[i] = new Car(tokens[0], engi, cargo, tiers);
		}

		String nextLine = scanner.nextLine();

		if (nextLine.equals("fragile")) {
			for (int i = 0; i < cars.length; i++) {
				if (cars[i]	.getCargo()
							.getCargoType()
							.equals(nextLine)) {

					Tier[] tiers = cars[i].getTiers();

					for (int j = 0; j < tiers.length; j++) {
						if (tiers[i].getTirePressure() < 1) {
							System.out.println(cars[i]);
							break;
						}
					}
				}
			}
		} else if (nextLine.equals("flamable")) {
			for (int i = 0; i < cars.length; i++) {
				if (cars[i]	.getCargo()
							.getCargoType()
							.equals(nextLine)) {

					if (cars[i]	.getEngine()
								.getEnginePower() > 250) {
						System.out.println(cars[i]);
					}
				}
			}
		}

		scanner.close();
	}
}
