package advanced.StacksAndQueues;

import java.util.*;

public class _7_RecursiveFibonacci {

    private static long[] memoization;

    static long fib(int n) {
	if (n <= 1) {
	    return 1;
	}

	if (memoization[n] != 0) {
	    return memoization[n];
	}

	memoization[n] = fib(n - 1) + fib(n - 2);

	return memoization[n];
    }

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	int n = Integer.parseInt(scan.nextLine());

	if (n >= 1 && n <= 49) {

	    memoization = new long[n + 1];

	    System.out.println(fib(n));
	}

    }

}
