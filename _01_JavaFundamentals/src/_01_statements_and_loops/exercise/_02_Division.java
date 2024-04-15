package _01_statements_and_loops.exercise;

import java.util.Scanner;

public class _02_Division {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = Integer.parseInt(scan.nextLine());
		int biggestDevision = 0;

		if (number % 2 == 0) {
			biggestDevision = 2;
		}
		if (number % 3 == 0) {
			biggestDevision = 3;
		}
		if (number % 6 == 0) {
			biggestDevision = 6;
		}
		if (number % 7 == 0) {
			biggestDevision = 7;
		}
		if (number % 10 == 0) {
			biggestDevision = 10;
		}

		if (biggestDevision == 0) {
			System.out.println("Not divisible");
		} else {
			System.out.printf("The number is divisible by %d", biggestDevision);
		}

		scan.close();
	}
}
