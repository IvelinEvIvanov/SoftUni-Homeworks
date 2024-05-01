package _06_class.exercise._06_VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();

		List<Vehicle> vehiles = new ArrayList<>();

		while (!line.equals("End")) {
			String[] tokens = line.split("\\s+");

			String type = tokens[0];
			String model = tokens[1];
			String color = tokens[2];
			int hoursepower = Integer.parseInt(tokens[3]);

			vehiles.add(new Vehicle(type, model, color, hoursepower));

			line = scanner.nextLine();
		}

		line = scanner.nextLine();

		while (!line.equals("Close the Catalogue")) {

			for (Vehicle vehicle : vehiles) {
				if (vehicle	.getModel()
							.equals(line)) {

					System.out.println(vehicle.toString());
					System.out.println();
				}
			}

			line = scanner.nextLine();
		}

		scanner.close();

		int carCount = Vehicle.countByType(vehiles, "car");
		int trcukCount = Vehicle.countByType(vehiles, "truck");

		int carTotalHorsepower = Vehicle.getTotalHorsePowerByType(vehiles, "car");
		int truckTotalHorsepower = Vehicle.getTotalHorsePowerByType(vehiles, "truck");

		double carAverageHoursepower = carTotalHorsepower / carCount;
		double truckAverageHoursepower = truckTotalHorsepower / trcukCount;

		Vehicle.printAverageHoursepowerByType("Car", carAverageHoursepower);
		Vehicle.printAverageHoursepowerByType("Truck", truckAverageHoursepower);
	}
}
