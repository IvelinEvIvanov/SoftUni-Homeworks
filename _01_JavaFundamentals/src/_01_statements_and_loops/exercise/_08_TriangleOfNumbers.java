package _01_statements_and_loops.exercise;

import java.util.Scanner;

public class _08_TriangleOfNumbers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = 0;
		while (!(n >= 1 && n <= 20)) {
			n = Integer.parseInt(scan.nextLine());
		}

		for (int i = 1; i <= n; i++) {
			for (int j = i; j > 0; j--) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

		scan.close();
	}
}
