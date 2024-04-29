package _04_method.lab;

import java.util.Scanner;

public class _01_SignOfInteger {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		printSign(Integer.parseInt(scanner.nextLine()));
		scanner.close();
	}

	public static void printSign(int number) {
		if (number > 0)
			System.out.printf("The number %d is positive.", number);
		else if (number < 0)
			System.out.printf("The number %d is negative.", number);
		else
			System.out.printf("The number %d is zero.", number);
	}
}
