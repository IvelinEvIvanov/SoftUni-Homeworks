package _02_dt_and_variables.lab;

import java.util.Scanner;

public class _08_LowerOrUpper {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char character = sc.nextLine().charAt(0);
		String str = "" + character;

		if (str.equals(str.toLowerCase())) {
			System.out.println("lower-case");
		} else {
			System.out.println("upper-case");
		}

		sc.close();
	}

}
