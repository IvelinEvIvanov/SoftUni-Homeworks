package _03_array.more_exercises;

import java.util.Scanner;

public class _02_PascalTriangle {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();

		long arr[] = new long[n];

		for (int i = 0; i < n; i++) {
			arr[i] = 1;

			for (int j = 0; j <= i; j++) {
				System.out.print(arr[i] + " ");
				arr[i] = arr[i] * (i - j) / (j + 1);
			}
			System.out.println();
		}
	}
}
