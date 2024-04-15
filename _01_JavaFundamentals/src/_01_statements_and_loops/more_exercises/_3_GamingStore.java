package _01_statements_and_loops.more_exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _3_GamingStore {

	private String name;
	private double price;

	public _3_GamingStore(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		List<_3_GamingStore> validGames = new ArrayList<>();
		validGames.add(new _3_GamingStore("OutFall 4", 39.99));
		validGames.add(new _3_GamingStore("CS: OG", 15.99));
		validGames.add(new _3_GamingStore("Zplinter Zell", 19.99));
		validGames.add(new _3_GamingStore("Honored 2", 59.99));
		validGames.add(new _3_GamingStore("RoverWatch", 29.99));
		validGames.add(new _3_GamingStore("RoverWatch Origins Edition", 39.99));

		double currentBalance = Double.parseDouble(scan.nextLine());
		double totalSum = 0;

		boolean gameExist = false;
		_3_GamingStore currentGame = null;
		String command = scan.nextLine();

		while (!command.equals("Game Time")) {

			for (int i = 0; i < validGames.size(); i++) {
				if (validGames.get(i).getName().equals(command)) {
					gameExist = true;
					currentGame = validGames.get(i);
					break;
				}
			}

			if (!gameExist) {
				System.out.println("Not Found");
			} else {
				if (currentGame.price > currentBalance) {
					System.out.println("Too Expensive");
				} else {
					currentBalance -= currentGame.getPrice();
					totalSum += currentGame.getPrice();
					gameExist = false;

					System.out.println("Bought " + currentGame.getName());
					if (currentBalance <= 0.0) {
						System.out.println("Out of mo-ney!");
						return;
					}
				}
			}
			command = scan.nextLine();
		}

		// double remainCash = totalSum - currentBalance;
		System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSum, currentBalance);
	}
}
