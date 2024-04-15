package _01_statements_and_loops.exercise;

import java.util.Scanner;

public class _03_Vacation {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numberOfPeople = Integer.parseInt(scan.nextLine());
		String typeOfPeople = scan.nextLine();
		String weekDay = scan.nextLine();

		double totalPrice = 0.0;
		// Students
		if (typeOfPeople.equals("Students") && weekDay.equals("Friday")) {
			totalPrice = numberOfPeople * 8.45;
			if (numberOfPeople >= 30) {
				totalPrice = totalPrice - (totalPrice * 0.15);
			}
			System.out.printf("Total price: %.2f", totalPrice);
		} else if (typeOfPeople.equals("Students") && weekDay.equals("Saturday")) {
			totalPrice = numberOfPeople * 9.80;
			if (numberOfPeople >= 30) {
				totalPrice = totalPrice - (totalPrice * 0.15);
			}
			System.out.printf("Total price: %.2f", totalPrice);
		} else if (typeOfPeople.equals("Students") && weekDay.equals("Sunday")) {
			totalPrice = numberOfPeople * 10.46;
			if (numberOfPeople >= 30) {
				totalPrice = totalPrice - (totalPrice * 0.15);
			}
			System.out.printf("Total price: %.2f", totalPrice);
		}

		// Business
		if (typeOfPeople.equals("Business") && weekDay.equals("Friday")) {
			totalPrice = numberOfPeople * 10.90;
			if (numberOfPeople >= 100) {
				totalPrice = totalPrice - (10 * 10.90);
			}
			System.out.printf("Total price: %.2f", totalPrice);
		} else if (typeOfPeople.equals("Business") && weekDay.equals("Saturday")) {
			totalPrice = numberOfPeople * 15.60;
			if (numberOfPeople >= 100) {
				totalPrice = totalPrice - (10 * 15.60);
			}
			System.out.printf("Total price: %.2f", totalPrice);
		} else if (typeOfPeople.equals("Business") && weekDay.equals("Sunday")) {
			totalPrice = numberOfPeople * 16;
			if (numberOfPeople >= 100) {
				totalPrice = totalPrice - (10 * 16);
			}
			System.out.printf("Total price: %.2f", totalPrice);
		}

		// Regular
		if (typeOfPeople.equals("Regular") && weekDay.equals("Friday")) {
			totalPrice = numberOfPeople * 15.20;
			if (numberOfPeople >= 10 && numberOfPeople <= 20) {
				totalPrice = totalPrice - (totalPrice * 0.5);
			}
			System.out.printf("Total price: %.2f", totalPrice);
		} else if (typeOfPeople.equals("Regular") && weekDay.equals("Saturday")) {
			totalPrice = numberOfPeople * 20;
			if (numberOfPeople >= 10 && numberOfPeople <= 20) {
				totalPrice = totalPrice - (totalPrice * 0.5);
			}
			System.out.printf("Total price: %.2f", totalPrice);
		} else if (typeOfPeople.equals("Regular") && weekDay.equals("Sunday")) {
			totalPrice = numberOfPeople * 22.5;
			if (numberOfPeople >= 10 && numberOfPeople <= 20) {
				totalPrice = totalPrice - (totalPrice * 0.5);
			}
			System.out.printf("Total price: %.2f", totalPrice);
		}

		scan.close();
	}
}
