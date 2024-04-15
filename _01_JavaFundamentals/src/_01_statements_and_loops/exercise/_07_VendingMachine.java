package _01_statements_and_loops.exercise;

import java.util.Scanner;

public class _07_VendingMachine {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		double sum = 0.0;
		String start = "";
		// Insert Coins
		while (!start.equals("Start")) {
			String coin = scan.nextLine();

			switch (coin) {
			case "0.1":
				sum += Double.parseDouble(coin);
				break;
			case "0.2":
				sum += Double.parseDouble(coin);
				break;
			case "0.5":
				sum += Double.parseDouble(coin);
				break;
			case "1":
				sum += Double.parseDouble(coin);
				break;
			case "2":
				sum += Double.parseDouble(coin);
				break;
			case "Start":
				start = coin;
				break;

			default:
				System.out.printf("Cannot accept %.2f%n", Double.parseDouble(coin));
				break;
			}
		}

		// Purchase Products
		String end = "";
		while (!end.equals("End")) {
			String product = scan.nextLine();

			switch (product) {
			case "Nuts":
				sum -= 2.0;
				if (sum < 0) {
					System.out.println("Sorry, not enough money");
					sum += 2.0;
					break;
				}
				System.out.println("Purchased " + product);
				break;
			case "Water":
				sum -= 0.7;
				if (sum < 0) {
					System.out.println("Sorry, not enough money");
					sum += 0.7;
					break;
				}
				System.out.println("Purchased " + product);

				break;
			case "Crisps":
				sum -= 1.5;
				if (sum < 0) {
					System.out.println("Sorry, not enough money");
					sum += 1.5;
					break;
				}
				System.out.println("Purchased " + product);

				break;
			case "Soda":
				sum -= 0.8;
				if (sum < 0) {
					System.out.println("Sorry, not enough money");
					sum += 0.8;
					break;
				}
				System.out.println("Purchased " + product);
				break;
			case "Coke":

				sum -= 1.0;
				if (sum < 0) {
					System.out.println("Sorry, not enough money");
					sum += 1.0;
					break;
				}
				System.out.println("Purchased " + product);
				break;
			case "End":
				end = "End";
				break;

			default:
				System.out.println("Invalid product");
				break;
			}
		}

		scan.close();

		System.out.printf("Change: %.2f%n", sum);
	}
}
