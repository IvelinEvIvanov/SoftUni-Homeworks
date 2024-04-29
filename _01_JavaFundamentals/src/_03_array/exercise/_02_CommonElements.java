package _03_array.exercise;

import java.util.Scanner;

public class _02_CommonElements {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String str1 = scan.nextLine();
		String str2 = scan.nextLine();

		String[] arr1 = str1.split(" ");
		String[] arr2 = str2.split(" ");

		String result = "";
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr1.length; j++) {
				if (arr2[i].equals(arr1[j])) {
					result += arr2[i] + " ";
				}
			}
		}

		scan.close();

		System.out.println(result);
	}
}
