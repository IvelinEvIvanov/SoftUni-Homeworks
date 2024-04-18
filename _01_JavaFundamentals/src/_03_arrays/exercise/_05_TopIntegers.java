package _03_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _05_TopIntegers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String numbers = scan.nextLine();
		int[] arr = Arrays	.stream(numbers.split(" "))
							.mapToInt(e -> Integer.parseInt(e))
							.toArray();

		scan.close();

		String result = "";
		for (int i = 0; i < arr.length; i++) {
			int max = arr[i];
			for (int j = i; j < arr.length; j++) {

				if (j == arr.length - 1) {
					if (max > arr[arr.length - 1] || max == arr[arr.length - 1]) {
						result += max + " ";
					}

					break;
				}

				if (max < arr[j + 1]) {
					break;
				}

			}
		}

		int[] arrResult = Arrays.stream(result.split(" "))
								.mapToInt(e -> Integer.parseInt(e))
								.toArray();

		for (int itr : arrResult) {
			System.out.print(itr + " ");
		}
	}
}
