package _01_statements_and_loops.lab;

import java.util.Scanner;

public class _07_TheatrePromotions {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String day = sc.nextLine().toLowerCase();
		int age = sc.nextInt();
		int price = 0;

		boolean isTeen = (age > 0 && age <= 18);
		boolean isAdult = (age > 18 && age <= 64);
		boolean isElder = (age > 64 && age <= 122);

		if (day.equals("weekday")) {
			if ((isTeen) || (isElder)) {
				price = 12;
			} else if (isAdult) {
				price = 18;
			}
		} else if (day.equals("weekend")) {
			if ((isTeen) || (isElder)) {
				price = 15;
			} else if (isAdult) {
				price = 20;
			}
		}

		if (price > 0) {
			System.out.println(price + "$");
		} else {
			System.err.println("Error!");
		}

		sc.close();
	}

}
