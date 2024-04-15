package _01_statements_and_loops.exercise;

import java.util.Scanner;

public class _06_StrongNumber {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int strongNumber = Integer.parseInt(scan.nextLine());
		int number = strongNumber;
		int sum = 0;
		
		do {
			int lastDigit = number;
			lastDigit %= 10;

			switch (lastDigit) {
			case 0:
				sum += 1;
				break;
			case 1:
				sum += 1;
				break;
			case 2:
				sum += 2;
				break;
			case 3:
				sum += 6;
				break;
			case 4:
				sum += 24;
				break;
			case 5:
				sum += 120;
				break;
			case 6:
				sum += 720;
				break;
			case 7:
				sum += 5040;
				break;
			case 8:
				sum += 40320;
				break;
			case 9:
				sum += 362880;
				break;
			}

			number /= 10;
		} while (number > 0);

		if (strongNumber == sum) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}

		scan.close();
	}
}
