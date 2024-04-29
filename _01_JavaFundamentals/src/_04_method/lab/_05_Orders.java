package _04_method.lab;

import java.util.Scanner;

public class _05_Orders {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String product = scanner.nextLine();
		int quantity = Integer.parseInt(scanner.nextLine());
		scanner.close();

		printOrder(product, quantity);
	}

	private static void printOrder(String product, int quantity) {
		switch (product) {
		case "coffee":
			System.out.println(quantity * 1.50);
			break;
		case "water":
			System.out.println(quantity * 1.00);
			break;
		case "coke":
			System.out.println(quantity * 1.40);
			break;
		case "snacks":
			System.out.println(quantity * 2.00);
			break;
		}
	}
}
