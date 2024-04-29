package _03_array.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _06_EqualSums {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String numbers = scan.nextLine();
		int[] arr = Arrays	.stream(numbers.split(" "))
							.mapToInt(e -> Integer.parseInt(e))
							.toArray();

		scan.close();

		boolean isIndex = false;
		for (int currentIndex = 0; currentIndex < arr.length; currentIndex++) {

			if (arr.length == 1) {
				System.out.println(0);
				break;
			}

			int leftSum = 0;
			int rightSum = 0;
			for (int left = 0; left < currentIndex; left++) {
				leftSum += arr[left];
			}

			for (int right = arr.length - 1; right > currentIndex; right--) {
				rightSum += arr[right];
			}

			if (rightSum == leftSum) {
				isIndex = true;
				System.out.print(currentIndex + " ");
			}
		}

		if (!isIndex) {
			System.out.println("no");
		}

	}
}
