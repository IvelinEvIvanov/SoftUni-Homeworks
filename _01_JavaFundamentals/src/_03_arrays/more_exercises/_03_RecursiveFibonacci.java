package _03_arrays.more_exercises;

import java.util.Scanner;

public class _03_RecursiveFibonacci {

	public static long fibonacciMemo(int n, long[] fibArray) {
		long fibValue = 0;

		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (fibArray[n] != 0) {
			return fibArray[n];
		} else {
			fibValue = fibonacciMemo(n - 1, fibArray) + fibonacciMemo(n - 2, fibArray);
			fibArray[n] = fibValue;
			return fibValue;
		}
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int fibonacciNumber = scanner.nextInt();
		scanner.close();

		long fibArray[] = new long[fibonacciNumber + 1];

		fibArray[0] = 1;
		fibArray[1] = 1;

		System.out.println(fibonacciMemo(fibonacciNumber, fibArray));
	}
}
