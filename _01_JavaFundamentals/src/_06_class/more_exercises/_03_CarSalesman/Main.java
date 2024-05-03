package _06_class.more_exercises._03_CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int nEngines = Integer.parseInt(br.readLine());

		Engine[] engines = new Engine[nEngines];

		for (int i = 0; i < nEngines; i++) {
			String[] tokens = br.readLine()
								.split("\\s+");

			if (tokens.length == 2) {
				engines[i] = new Engine(tokens[0], Integer.parseInt(tokens[1]));
			} else if (tokens.length == 3) {
				engines[i] = new Engine(tokens[0], Integer.parseInt(tokens[1]));
				try {
					Integer.parseInt(tokens[2]);
					engines[i].setDisplacement(tokens[2]);
				} catch (NumberFormatException e) {
					engines[i].setEfficiency(tokens[2]);
				}

			} else if (tokens.length == 4) {
				engines[i] = new Engine(tokens[0], Integer.parseInt(tokens[1]));
				engines[i].setDisplacement(tokens[2]);
				engines[i].setEfficiency(tokens[3]);
			}
		}

		int nCars = Integer.parseInt(br.readLine());

		Car[] cars = new Car[nCars];

		for (int i = 0; i < cars.length; i++) {
			String[] tokens = br.readLine()
								.split("\\s+");

			if (tokens.length == 2) {
				Engine engine = getEngine(engines, tokens[1]);
				cars[i] = new Car(tokens[0], engine);
			} else if (tokens.length == 3) {
				Engine engine = getEngine(engines, tokens[1]);
				cars[i] = new Car(tokens[0], engine);
				try {
					Integer.parseInt(tokens[2]);
					cars[i].setWeight(tokens[2]);
				} catch (NumberFormatException e) {
					cars[i].setColor(tokens[2]);
				}
			} else if (tokens.length == 4) {
				Engine engine = getEngine(engines, tokens[1]);
				cars[i] = new Car(tokens[0], engine);
				cars[i].setWeight(tokens[2]);
				cars[i].setColor(tokens[3]);
			}
		}

		for (Car car : cars) {
			System.out.println(car);
		}
	}

	private static Engine getEngine(Engine[] engines, String name) {
		for (int i = 0; i < engines.length; i++) {
			if (engines[i]	.getModel()
							.equals(name)) {
				return engines[i];
			}
		}

		return null;
	}
}
