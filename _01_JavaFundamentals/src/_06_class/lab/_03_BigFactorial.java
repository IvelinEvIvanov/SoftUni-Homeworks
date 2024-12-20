package _06_class.lab;

import java.math.BigInteger;
import java.util.Scanner;

public class _03_BigFactorial {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		scanner.close();

		BigInteger f = new BigInteger(String.valueOf(1));
		
		for (int i = 1; i <= n; i++) {
			f = f.multiply(BigInteger.valueOf(Integer.parseInt(String.valueOf(i))));
		}

		System.out.println(f);
	}
}
