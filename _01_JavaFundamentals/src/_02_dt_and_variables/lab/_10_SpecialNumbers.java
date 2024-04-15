package _02_dt_and_variables.lab;

import java.util.Scanner;

public class _10_SpecialNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		for (int num = 1; num <= n; num++) {
			int sumOfDigits = 0;
			int digits = num;

			while (digits > 0) {
				sumOfDigits += digits % 10;
				digits = digits / 10;
			}

			if (sumOfDigits == 5 || sumOfDigits == 7 || sumOfDigits == 11) {
				System.out.println(num + " -> " + "True");
			} else {
				System.out.println(num + " -> " + "False");
			}
		}

		sc.close();
	}

}
