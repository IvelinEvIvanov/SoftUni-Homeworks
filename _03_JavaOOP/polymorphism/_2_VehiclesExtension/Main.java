package polymorphism._2_VehiclesExtension;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner reader = new Scanner(System.in);

	String[] input = reader.nextLine().split(" ");
	Vehicle car = new Car(Double.parseDouble(input[1]), Double.parseDouble(input[2]), Double.parseDouble(input[3]));

	input = reader.nextLine().split(" ");
	Vehicle truck = new Truck(Double.parseDouble(input[1]), Double.parseDouble(input[2]),
		Double.parseDouble(input[3]));

	input = reader.nextLine().split(" ");
	Vehicle bus = new Bus(Double.parseDouble(input[1]), Double.parseDouble(input[2]), Double.parseDouble(input[3]));

	int n = Integer.parseInt(reader.nextLine());

	DecimalFormat df = new DecimalFormat("#.##");

	for (int i = 0; i < n; i++) {
	    String[] nextLine = reader.nextLine().split(" ");

	    double distance = Double.parseDouble(nextLine[2]);
	    double litters = distance;

	    if (nextLine[0].equals("Drive") && nextLine[1].equals("Car")) {

		if (car.calculateFuel(distance) >= 0) {
		    System.out.println("Car travelled " + df.format(distance) + " km");
		} else if (car.calculateFuel(distance) < 0) {
		    System.out.println("Car needs refueling");
		}
	    } else if (nextLine[0].equals("Drive") && nextLine[1].equals("Truck")) {

		if (truck.calculateFuel(distance) >= 0) {
		    System.out.println("Truck travelled " + df.format(distance) + " km");
		} else if (truck.calculateFuel(distance) < 0) {
		    System.out.println("Truck needs refueling");
		}
	    } else if (nextLine[0].equals("Drive") && nextLine[1].equals("Bus")) {
		if (bus.calculateFuel(distance) >= 0) {
		    System.out.println("Bus travelled " + df.format(distance) + " km");
		} else if (bus.calculateFuel(distance) < 0) {
		    System.out.println("Bus needs refueling");
		}
	    } else if (nextLine[0].equals("DriveEmpty") && nextLine[1].equals("Bus")) {
		if (((Bus) bus).driveEmpty(distance) >= 0) {
		    System.out.println("Bus travelled " + df.format(distance) + " km");
		} else if (((Bus) bus).driveEmpty(distance) < 0) {
		    System.out.println("Bus needs refueling");
		}
	    } else if (nextLine[0].equals("Refuel") && nextLine[1].equals("Car")) {
		car.setRefueledLiters(litters);
	    } else if (nextLine[0].equals("Refuel") && nextLine[1].equals("Truck")) {
		truck.setRefueledLiters(litters);
	    } else if (nextLine[0].equals("Refuel") && nextLine[1].equals("Bus")) {
		bus.setRefueledLiters(litters);

	    }

	}

	System.out.println(car);
	System.out.println(truck);
	System.out.println(bus);
    }
}
