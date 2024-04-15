package _01_statements_and_loops.exercise;

import java.util.Scanner;

public class _10_RageExpenses {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int lostGames = Integer.parseInt(scan.nextLine());
		double headsetPrice = Double.parseDouble(scan.nextLine());
		double mousePrice = Double.parseDouble(scan.nextLine());
		double keyboardPrice = Double.parseDouble(scan.nextLine());
		double displayPrice = Double.parseDouble(scan.nextLine());

		double headsetTrashedPrice = (lostGames / 2) * headsetPrice;
		double mouseTrashedPrice = (lostGames / 3) * mousePrice;
		double keyboardTrashedPrice = (lostGames / 6) * keyboardPrice;
		double displayTrashedPrice = (lostGames / 12) * displayPrice;

		double total = headsetTrashedPrice + mouseTrashedPrice + keyboardTrashedPrice + displayTrashedPrice;

		System.out.printf("Rage expenses: %.2f lv.", total);

		scan.close();
	}
}
