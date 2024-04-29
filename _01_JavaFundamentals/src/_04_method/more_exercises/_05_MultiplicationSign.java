package _04_method.more_exercises;

import java.util.Scanner;

public class _05_MultiplicationSign {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] numArr = new int[3];

		numArr[0] = scanner.nextInt();
		numArr[1] = scanner.nextInt();
		numArr[2] = scanner.nextInt();
		scanner.close();

		boolean hasZero = hasAtLeastOneZero(numArr);
		
		if (hasZero) {
			System.out.println("zero");
			return;
		}

		int result = countNegativeNumbers(numArr);
		
		if (result % 2 == 0) {
			System.out.println("positive");
		} else {
			System.out.println("negative");
		}

	}

	private static boolean hasAtLeastOneZero(int[] numArr) {
		for (int i = 0; i < numArr.length; i++) {
			if (numArr[i] == 0) {
				return true;
			}
		}
		return false;
	}

	private static int countNegativeNumbers(int[] numArr) {
		int count = 0;
		for (int i = 0; i < numArr.length; i++) {
			if (numArr[i] < 0) {
				count++;
			}
		}
		return count;
	}
}
