package _02_dt_and_variables.lab;

import java.util.Scanner;

public class _06_CharsToString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char firstChar = sc.nextLine().charAt(0);
		char secondChar = sc.nextLine().charAt(0);
		char thirdChar = sc.nextLine().charAt(0);

		sc.close();

		String result = "" + firstChar + secondChar + thirdChar;
		System.out.println(result);
	}

}
