package _03_array.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _07_MaxSequenceOfEqualElements {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String numbers = scan.nextLine();
		int[] arr = Arrays	.stream(numbers.split(" "))
							.mapToInt(e -> Integer.parseInt(e))
							.toArray();

		scan.close();

		int count = 1;
		int longest = 1;
		int startIndex = 0;
		int endIndex = 0;
		
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				count++;
				if (count == arr.length) {
					for (int j = 0; j < arr.length - 1; j++) {
						System.out.print(arr[j] + " ");
					}
				}
				continue;
			}

			if (count > longest) {
				longest = count;
				startIndex = (i - count) + 1;
				endIndex = i;
			}
			count = 1;

		}

		for (int i = startIndex; i <= endIndex; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
