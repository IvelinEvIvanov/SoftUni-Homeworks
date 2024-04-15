package _01_statements_and_loops.lab;

import java.util.Scanner;

public class _11_MultiplicationTable2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int times = sc.nextInt();

		do {
			int product = number * times;
			System.out.printf("%d x %d = %d%n", number, times, product);
			times++;
		} while (times <= 10);

		sc.close();

	}

}
