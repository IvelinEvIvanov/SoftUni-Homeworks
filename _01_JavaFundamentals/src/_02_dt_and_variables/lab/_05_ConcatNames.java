package _02_dt_and_variables.lab;

import java.util.Scanner;

public class _05_ConcatNames {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String firstName = sc.nextLine();
		String lastName = sc.nextLine();
		String delimiter = sc.nextLine();

		sc.close();

		String result = firstName + delimiter + lastName;
		System.out.println(result);

	}

}
