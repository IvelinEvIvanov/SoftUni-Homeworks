package _04_methods.exercise;

import java.util.Scanner;

public class _07_NxNMatrix {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();

		printMatrix(n);
	}

	private static void printMatrix(int n) {
		for (int row = 0; row < n; row++) {
			printCols(n);
		}
	}

	private static void printCols(int n) {
		for (int col = 0; col < n; col++) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
}
