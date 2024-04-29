package _03_array.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _08_MagicSum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String numbers = scan.nextLine();
		int n = Integer.parseInt(scan.nextLine());
		int[] arr = Arrays	.stream(numbers.split(" "))
							.mapToInt(e -> Integer.parseInt(e))
							.toArray();

		scan.close();

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == n) {
					System.out.print(arr[i] + " " + arr[j] + "\n");
				}
			}

		}
	}
}
