package _01_statements_and_loops.lab;

import java.util.Locale;
import java.util.Scanner;

public class _02_Passed {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);

		Double grade = sc.nextDouble();
		if (grade >= 3) {
			System.out.println("Passed!");
		}
		sc.close();
	}

}
