package _01_statements_and_loops.exercise;

import java.util.Scanner;

public class _04_PrintAndSum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int start = Integer.parseInt(scan.nextLine());
		int end = Integer.parseInt(scan.nextLine());
		int sum = 0;
		
		for (int i = start; i <= end; i++) {
			System.out.printf("%d ", i);
			sum += i;
		}
		scan.close();
		
		System.out.println("\nSum: " + sum);
	}
}
