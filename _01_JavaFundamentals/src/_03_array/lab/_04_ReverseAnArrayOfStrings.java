package _03_array.lab;

import java.util.Scanner;

public class _04_ReverseAnArrayOfStrings {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] charArr = scanner.nextLine().split(" ");

		int left = 0;
		int right = charArr.length - 1;

		while (left < right) {
			String temp = charArr[left];
			charArr[left++] = charArr[right];
			charArr[right--] = temp;
		}

		scanner.close();

		String reversedArr = String.join(" ", charArr);
		System.out.println(reversedArr);
	}
}
