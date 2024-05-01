package _06_class.exercise._06_VehicleCatalogue;

import java.util.List;

public class Vehicle {

	private String type;
	private String model;
	private String color;
	private int horsepower;

	public Vehicle() {

	}

	public Vehicle(String type, String model, String color, int horsepower) {
		this.type = type;
		this.model = model;
		this.color = color;
		this.horsepower = horsepower;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}

	public static int getTotalHorsePowerByType(List<Vehicle> vehiles, String type) {
		int sum = 0;

		for (Vehicle vehicle : vehiles) {
			if (vehicle	.getType()
						.equals(type)) {
				sum += vehicle.getHorsepower();
			}
		}

		return sum;
	}

	public static int countByType(List<Vehicle> vehiles, String type) {
		int count = 0;

		for (Vehicle vehicle : vehiles) {
			if (vehicle	.getType()
						.equals(type)) {
				count++;
			}
		}

		return count;
	}

	public static void printAverageHoursepowerByType(String type, double average) {
		System.out.printf("%s have average horsepower of: %.2f%n", type, average);
	}

	@Override
	public String toString() {
		return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d", type, model, color, horsepower);
	}

}
