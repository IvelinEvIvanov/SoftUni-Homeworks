package _01_statements_and_loops.lab;

import java.util.Scanner;

public class _13_RefactorSumOfOddNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int sum = 1; // sum = 0;

		for (int i = 0; i <= n; i++) { // i < n;
			System.out.print(2 * i + 1); // System.out.println(2 * i + 1);
			sum += 2 * i; // sum += 2 * i + 1;
		}
		System.out.printf("Sum: %d%n", sum);

		sc.close();
	}

}
