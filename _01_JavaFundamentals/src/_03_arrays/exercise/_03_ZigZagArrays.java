package _03_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _03_ZigZagArrays {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = Integer.parseInt(scan.nextLine());

		String numbers = "";
		for (int i = 0; i < n; i++) {
			numbers += scan.nextLine() + " ";
		}

		int[] arr = Arrays	.stream(numbers.split(" "))
							.mapToInt(e -> Integer.parseInt(e))
							.toArray();

		int firstRow[] = new int[(arr.length / 2)];
		int secondRow[] = new int[(arr.length / 2)];

		int firstRowIndex = 0;
		int secondRowIndex = 0;
		boolean flag = true;
		
		for (int i = 0; i < arr.length; i += 2) {
			if (flag) {
				firstRow[firstRowIndex] = arr[i];
				secondRow[secondRowIndex] = arr[i + 1];
				firstRowIndex++;
				secondRowIndex++;
				flag = false;
			} else {
				secondRow[secondRowIndex] = arr[i];
				firstRow[firstRowIndex] = arr[i + 1];
				firstRowIndex++;
				secondRowIndex++;
				flag = true;
			}
		}

		for (int itr : firstRow) {
			System.out.print(itr + " ");
		}
		
		System.out.println();
		
		for (int itr : secondRow) {
			System.out.print(itr + " ");
		}
		
		 scan.close();
		
		System.out.println();
	}

}
