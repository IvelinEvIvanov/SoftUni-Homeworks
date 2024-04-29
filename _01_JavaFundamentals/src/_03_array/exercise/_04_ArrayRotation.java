package _03_array.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _04_ArrayRotation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String numbers = scan.nextLine();
		int n = Integer.parseInt(scan.nextLine());

		int[] arr = Arrays	.stream(numbers.split(" "))
							.mapToInt(e -> Integer.parseInt(e))
							.toArray();

		scan.close();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				int swap = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = swap;
			}
		}

		for (int itr : arr) {
			System.out.print(itr + " ");
		}
	}
}
