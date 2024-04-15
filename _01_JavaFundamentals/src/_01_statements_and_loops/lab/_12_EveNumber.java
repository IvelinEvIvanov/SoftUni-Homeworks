package _01_statements_and_loops.lab;

import java.util.Scanner;

public class _12_EveNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();

		while (number % 2 != 0) {
			System.out.println("Please write a even number.");
			number = sc.nextInt();
		}

		System.out.printf("The number is: %d%n", Math.abs(number));

		sc.close();
	}

}
