package _01_statements_and_loops.lab;

import java.util.Scanner;

public class _09_SumOfOddNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int sum = 0;
		for (int i = 1; i <= n; i++) {
			int oddNumber = (2 * i) - 1;
			System.out.println(oddNumber);
			sum += oddNumber;
		}

		System.out.println("Sum = " + sum);

		sc.close();

	}

}
