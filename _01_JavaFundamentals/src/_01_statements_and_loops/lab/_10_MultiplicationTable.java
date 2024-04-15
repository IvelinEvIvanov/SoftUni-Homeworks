package _01_statements_and_loops.lab;

import java.util.Scanner;

public class _10_MultiplicationTable {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();

		int times = 1;

		while (times <= 10) {
			int product = number * times;
			System.out.printf("%d x %d = %d%n", number, times, product);
			times++;
		}

		sc.close();
	}

}
