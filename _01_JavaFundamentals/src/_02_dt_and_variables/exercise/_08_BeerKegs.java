package _02_dt_and_variables.exercise;

import java.util.Scanner;

public class _08_BeerKegs {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int n = Integer.parseInt(scanner.nextLine());
		final double PI = Math.PI;

		String kegModel = "";
		double radius = 0.0;
		int height = 0;

		double biggestKegVolume = 0.0;
		double currentKegVolume = 0.0;
		String result = "";

		for (int i = 0; i < n; i++) {
			kegModel = scanner.nextLine();
			radius = Double.parseDouble(scanner.nextLine());
			height = Integer.parseInt(scanner.nextLine());
			currentKegVolume = PI * (radius * radius) * height;

			if (currentKegVolume > biggestKegVolume) {
				biggestKegVolume = currentKegVolume;
				result = kegModel;
			}
		}

		scanner.close();

		System.out.println(result);
	}
}
