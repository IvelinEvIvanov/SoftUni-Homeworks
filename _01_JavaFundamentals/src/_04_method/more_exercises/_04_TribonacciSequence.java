package _04_method.more_exercises;

import java.util.Scanner;

public class _04_TribonacciSequence {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();

		int[] triboArr = new int[n];

		for (int i = 0; i < n; i++) {
			triboArr[i] = getTriboSum(triboArr, i);
			System.out.print(triboArr[i] + " ");
		}
	}

	private static int getTriboSum(int[] triboArr, int i) {
		switch (i) {
		case 0:
			return 1;
		case 1:
			return 1;
		case 2:
			return 2;
		default: {

			int sum = 0;
			for (int j = i - 1; j >= i - 3; j--) {
				sum += triboArr[j];
			}
			return sum;
		}
		}
	}
}
